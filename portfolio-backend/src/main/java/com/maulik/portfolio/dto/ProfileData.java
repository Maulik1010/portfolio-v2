package com.maulik.portfolio.dto;

import java.util.List;
import java.util.Map;

public class ProfileData {

    private String name;
    private String title;
    private String location;
    private String email;
    private String phone;
    private String summary;
    private Map<String, List<String>> skills;
    private List<Experience> experience;
    private List<Project> projects;
    private List<Education> education;

    public ProfileData(String name, String title, String location, String email, String phone,
                       String summary, Map<String, List<String>> skills,
                       List<Experience> experience, List<Project> projects, List<Education> education) {
        this.name = name;
        this.title = title;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.summary = summary;
        this.skills = skills;
        this.experience = experience;
        this.projects = projects;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getSummary() {
        return summary;
    }

    public Map<String, List<String>> getSkills() {
        return skills;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public List<Education> getEducation() {
        return education;
    }

    public static class Experience {
        private String role;
        private String company;
        private String location;
        private String dates;
        private List<String> bullets;

        public Experience(String role, String company, String location, String dates, List<String> bullets) {
            this.role = role;
            this.company = company;
            this.location = location;
            this.dates = dates;
            this.bullets = bullets;
        }

        public String getRole() {
            return role;
        }

        public String getCompany() {
            return company;
        }

        public String getLocation() {
            return location;
        }

        public String getDates() {
            return dates;
        }

        public List<String> getBullets() {
            return bullets;
        }
    }

    public static class Project {
        private String title;
        private String description;
        private List<String> tech;
        private String liveUrl;
        private String githubUrl;

        public Project(String title, String description, List<String> tech, String liveUrl, String githubUrl) {
            this.title = title;
            this.description = description;
            this.tech = tech;
            this.liveUrl = liveUrl;
            this.githubUrl = githubUrl;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public List<String> getTech() {
            return tech;
        }

        public String getLiveUrl() {
            return liveUrl;
        }

        public String getGithubUrl() {
            return githubUrl;
        }
    }

    public static class Education {
        private String degree;
        private String school;
        private String dates;

        public Education(String degree, String school, String dates) {
            this.degree = degree;
            this.school = school;
            this.dates = dates;
        }

        public String getDegree() {
            return degree;
        }

        public String getSchool() {
            return school;
        }

        public String getDates() {
            return dates;
        }
    }
}
