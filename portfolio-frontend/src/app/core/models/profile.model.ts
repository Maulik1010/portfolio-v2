export interface Experience {
  role: string;
  company: string;
  location: string;
  dates: string;
  bullets: string[];
}

export interface Project {
  title: string;
  description: string;
  tech: string[];
}

export interface Education {
  degree: string;
  school: string;
  dates: string;
}

export interface Profile {
  name: string;
  title: string;
  location: string;
  email: string;
  phone: string;
  summary: string;
  skills: { [category: string]: string[] };
  experience: Experience[];
  projects: Project[];
  education: Education[];
}

export interface ContactRequest {
  name: string;
  email: string;
  message: string;
}

export interface ApiResponse {
  success: boolean;
  message: string;
}
