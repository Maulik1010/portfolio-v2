import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfileService } from './core/services/profile.service';
import { Profile } from './core/models/profile.model';

import { HeroComponent } from './components/hero/hero.component';
import { AboutComponent } from './components/about/about.component';
import { SkillsComponent } from './components/skills/skills.component';
import { ExperienceComponent } from './components/experience/experience.component';
import { ProjectsComponent } from './components/projects/projects.component';
import { EducationComponent } from './components/education/education.component';
import { ContactFormComponent } from './components/contact-form/contact-form.component';
import { SiteFooterComponent } from './components/site-footer/site-footer.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    HeroComponent,
    AboutComponent,
    SkillsComponent,
    ExperienceComponent,
    ProjectsComponent,
    EducationComponent,
    ContactFormComponent,
    SiteFooterComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  profile: Profile | null = null;
  loadError = false;

  constructor(private profileService: ProfileService) {}

  ngOnInit(): void {
    this.profileService.getProfile().subscribe({
      next: (data) => (this.profile = data),
      error: (err) => {
        console.error('Failed to load profile', err);
        this.loadError = true;
      }
    });
  }
}
