import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Education } from '../../core/models/profile.model';

@Component({
  selector: 'app-education',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './education.component.html',
  styleUrl: './education.component.css'
})
export class EducationComponent {
  @Input() education: Education[] | null = null;
}
