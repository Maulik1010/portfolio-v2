import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-site-footer',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './site-footer.component.html',
  styleUrl: './site-footer.component.css'
})
export class SiteFooterComponent {
  @Input() name = 'Maulik Prajapati';
  year = new Date().getFullYear();
}
