import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { ContactService } from '../../core/services/contact.service';
import { ContactRequest } from '../../core/models/profile.model';

@Component({
  selector: 'app-contact-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './contact-form.component.html',
  styleUrl: './contact-form.component.css'
})
export class ContactFormComponent {
  model: ContactRequest = { name: '', email: '', message: '' };

  submitting = false;
  statusMessage = '';
  statusType: 'success' | 'error' | '' = '';

  constructor(private contactService: ContactService) {}

  onSubmit(form: NgForm): void {
    if (form.invalid) {
      return;
    }

    this.submitting = true;
    this.statusMessage = '';
    this.statusType = '';

    this.contactService.sendMessage(this.model).subscribe({
      next: (res) => {
        this.statusMessage = res.message;
        this.statusType = res.success ? 'success' : 'error';
        this.submitting = false;
        if (res.success) {
          form.resetForm();
        }
      },
      error: (err) => {
        console.error(err);
        this.statusMessage =
          err?.error?.message ?? "Couldn't reach the server. Make sure the backend is running.";
        this.statusType = 'error';
        this.submitting = false;
      }
    });
  }
}
