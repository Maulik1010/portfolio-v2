package com.maulik.portfolio.controller;

import com.maulik.portfolio.dto.ApiResponse;
import com.maulik.portfolio.dto.ContactRequest;
import com.maulik.portfolio.model.ContactMessage;
import com.maulik.portfolio.repository.ContactMessageRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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

    private final ContactMessageRepository contactMessageRepository;

    public ContactController(ContactMessageRepository contactMessageRepository) {
        this.contactMessageRepository = contactMessageRepository;
    }

    /**
     * Saves a contact form submission to the database.
     *
     * NOTE: This currently persists messages to the H2 database only.
     * If you want messages emailed to you as well, add spring-boot-starter-mail,
     * configure your SMTP provider's credentials in application.properties,
     * and call a JavaMailSender here. Credentials should come from environment
     * variables, never hardcoded.
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
