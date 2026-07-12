package com.maulik.portfolio.controller;

import com.maulik.portfolio.dto.ProfileData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    // Edit the values below to update what shows on the site — no frontend
    // changes needed, since script.js pulls all of this from this endpoint.
    private static final ProfileData PROFILE = new ProfileData(
            "Maulik Prajapati",
            "Software Developer | Java · Spring Boot · REST APIs",
            "Hamilton, ON, Canada",
            "maulik1276@email.com",
            "(437) 977-7033",
            "Full-stack Software Developer with 2+ years of professional experience building backend "
                    + "microservices, RESTful APIs, and full-stack web applications using Java, Spring Boot, "
                    + "and Angular. Comfortable working across the full SDLC in Agile/Scrum environments, "
                    + "from technical design and development through testing and deployment. Solid grounding "
                    + "in relational and document databases, secure API design, and clean coding practices, "
                    + "with a track record of learning new tools and frameworks quickly.",
            Map.of(
                    "Languages", List.of("Java", "SQL", "TypeScript", "JavaScript", "HTML5", "CSS3", "XML", "JSON"),
                    "Frameworks", List.of("Spring Boot", "Spring MVC", "Angular", "Hibernate/JPA", "RESTful APIs"),
                    "Databases", List.of("MySQL", "PostgreSQL", "MS SQL Server", "Oracle", "MongoDB"),
                    "Security", List.of("OAuth-based authentication", "OWASP input-validation practices"),
                    "Tools", List.of("Git/GitHub", "Maven", "JUnit", "Postman", "JIRA", "IntelliJ IDEA"),
                    "Methodologies", List.of("Agile/Scrum", "SDLC", "UML")
            ),
            List.of(
                    new ProfileData.Experience(
                            "Software Developer",
                            "Oxagile",
                            "Remote",
                            "Jan 2026 – May 2026 (Contract)",
                            List.of(
                                    "Developed backend microservices using Java and Spring Boot, building RESTful APIs consumed by web and mobile client applications in a remote-first Agile team.",
                                    "Built and integrated Spring MVC modules with JPA/Hibernate ORM for database operations across relational (MySQL, PostgreSQL) and document-based (MongoDB) data stores.",
                                    "Implemented OAuth-based authentication and OWASP-aligned input validation across API endpoints.",
                                    "Participated in technical design discussions, code reviews, JUnit testing, and deployment coordination within a distributed team.",
                                    "Used Git/GitHub branching strategies and JIRA sprint tracking to manage and deliver incremental feature releases."
                            )
                    ),
                    new ProfileData.Experience(
                            "Junior Software Developer",
                            "Softweb Techies",
                            "Gujarat, India",
                            "Jun 2022 – Jul 2024",
                            List.of(
                                    "Designed, built, and shipped full-stack web applications using Java, Spring Boot, Angular, TypeScript, and MySQL, owning features from technical design through UAT and deployment.",
                                    "Built RESTful APIs connecting Angular frontend components with Spring Boot backend services and relational databases.",
                                    "Implemented CRUD operations, JPA/Hibernate ORM queries, and data validation across MySQL and MongoDB in production environments.",
                                    "Produced UML sequence and class diagrams to support system design communication with senior stakeholders.",
                                    "Applied OOP principles and clean coding practices; monitored post-deployment performance and resolved production issues."
                            )
                    )
            ),
            List.of(
                    new ProfileData.Project(
                            "Personal Portfolio Site",
                            "A full-stack personal portfolio built to showcase my projects, skills, and experience. "
                                    + "The frontend is built with Angular 17 using standalone components for a modular, "
                                    + "maintainable structure, while the backend is a Spring Boot REST API backed by "
                                    + "MySQL for dynamic content. Includes a working contact form that emails messages "
                                    + "directly and persists them to the database.",
                            List.of("Angular", "Spring Boot", "MySQL", "Java 17", "REST API"),
                            "https://maulik1010.github.io/portfolio-v2/",
                            "https://github.com/Maulik1010/portfolio-v2"
                    )
            ),
            List.of(
                    new ProfileData.Education(
                            "Advanced Diploma, Computer Programming",
                            "Sheridan College, Brampton, ON",
                            "Aug 2024 – Dec 2025"
                    ),
                    new ProfileData.Education(
                            "B.Sc., Computer Application & Information Technology",
                            "Hemchandracharya North Gujarat University",
                            "Aug 2020 – Apr 2023"
                    )
            )
    );

    @GetMapping
    public ProfileData getProfile() {
        return PROFILE;
    }
}
