package com.maulik.portfolio.controller;

import com.maulik.portfolio.dto.ApiResponse;
import com.maulik.portfolio.dto.ContactRequest;
import com.maulik.portfolio.model.ContactMessage;
import com.maulik.portfolio.repository.ContactMessageRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    private final ContactMessageRepository contactMessageRepository;
    private final JavaMailSender mailSender;

    @Value("${portfolio.contact.notify-email}")
    private String notifyEmail;

    public ContactController(ContactMessageRepository contactMessageRepository, JavaMailSender mailSender) {
        this.contactMessageRepository = contactMessageRepository;
        this.mailSender = mailSender;
    }

    /**
     * Saves a contact form submission to the database and emails a notification.
     * If email sending fails (e.g. SMTP misconfiguration), the message is still
     * saved to the database and the user still gets a success response — a
     * flaky mail provider shouldn't lose a genuine inquiry.
     */
    @PostMapping
    public ResponseEntity<ApiResponse> submitMessage(@Valid @RequestBody ContactRequest request) {
        ContactMessage message = new ContactMessage(
                request.getName(),
                request.getEmail(),
                request.getMessage(),
                LocalDateTime.now()
        );
        contactMessageRepository.save(message);

        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(notifyEmail);
            mail.setReplyTo(request.getEmail());
            mail.setSubject("Portfolio contact form: " + request.getName());
            mail.setText(
                    "New message from your portfolio site:\n\n"
                            + "Name: " + request.getName() + "\n"
                            + "Email: " + request.getEmail() + "\n\n"
                            + request.getMessage()
            );
            mailSender.send(mail);
        } catch (Exception e) {
            // Don't fail the request just because email delivery had an issue —
            // the message is already safely saved in the database above.
            log.error("Failed to send contact-form notification email", e);
        }

        return ResponseEntity.ok(
                new ApiResponse(true, "Thanks for reaching out! I'll get back to you soon.")
        );
    }

    /**
     * Lists saved messages. Intended for local/admin use only while developing;
     * add authentication before exposing this in a real deployment.
     */
    @GetMapping
    public ResponseEntity<List<ContactMessage>> listMessages() {
        return ResponseEntity.ok(contactMessageRepository.findAll());
    }
}
