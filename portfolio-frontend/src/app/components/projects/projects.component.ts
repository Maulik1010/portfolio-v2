import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Project } from '../../core/models/profile.model';

@Component({
  selector: 'app-projects',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './projects.component.html',
  styleUrl: './projects.component.css'
})
export class ProjectsComponent {
  @Input() projects: Project[] | null = null;
}
