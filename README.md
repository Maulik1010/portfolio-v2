# Maulik Prajapati — Personal Profile Site (Angular + Spring Boot + MySQL)

```
portfolio-backend/     Spring Boot API (Java 17, Maven, MySQL)
portfolio-frontend/    Angular 17 app (standalone components)
```

## 1. Set up MySQL

Create the database (the app will create tables automatically, but the database itself needs to exist first):

```sql
CREATE DATABASE portfolio_db;
```

Then open `portfolio-backend/src/main/resources/application.properties` and set your real MySQL
username/password:

```properties
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

## 2. Run the backend

Requirements: Java 17+, Maven, and MySQL running locally (or update the URL to point at a remote instance).

```bash
cd portfolio-backend
mvn spring-boot:run
```

Starts the API on **http://localhost:8080**:

- `GET  /api/profile` — your profile data (summary, skills, experience, projects, education) as JSON
- `POST /api/contact` — saves a contact form submission (`{ name, email, message }`) to MySQL
- `GET  /api/contact` — lists saved messages (for your own use while developing — add authentication before exposing this publicly)

Hibernate auto-creates the `contact_message` table on first run (`spring.jpa.hibernate.ddl-auto=update`).

### Updating your info

Everything shown on the site lives in one place:
`portfolio-backend/src/main/java/com/maulik/portfolio/controller/ProfileController.java`. Edit the
`PROFILE` object and restart — no frontend changes needed.

### Adding real email notifications (optional)

Right now, messages are saved to MySQL only. To also email them to yourself, add
`spring-boot-starter-mail`, configure your SMTP provider's credentials via environment variables
(never hardcode them), and call `JavaMailSender` inside `ContactController.submitMessage()`.

## 3. Run the frontend

Requirements: Node.js 18+ and npm.

```bash
cd portfolio-frontend
npm install
npm start
```

This runs `ng serve` on **http://localhost:4200**. Make sure the backend (step 2) is running first,
since the app loads all of its content from the API on load.

The API URL is set in `src/environments/environment.ts` (`http://localhost:8080/api` for local dev)
and `src/environments/environment.prod.ts` (update this to your deployed backend URL before
building for production).

## 4. Project structure (frontend)

```
src/app/
├── app.component.ts/html/css       Shell: header, nav, composes all sections
├── core/
│   ├── models/profile.model.ts     TypeScript interfaces matching the backend JSON
│   └── services/
│       ├── profile.service.ts      GET /api/profile
│       └── contact.service.ts      POST /api/contact
└── components/
    ├── hero/                       Name, title, summary, animated pipeline diagram
    ├── about/
    ├── skills/
    ├── experience/
    ├── projects/
    ├── education/
    ├── contact-form/               Template-driven form, calls ContactService
    └── site-footer/
```

Each component is standalone (no NgModules needed) and receives data via `@Input()` from
`AppComponent`, which fetches the profile once in `ngOnInit()`.

## 5. Building for production

**Backend:**
```bash
cd portfolio-backend
mvn clean package
java -jar target/portfolio-1.0.0.jar
```

**Frontend:**
```bash
cd portfolio-frontend
npm run build
```
Output goes to `dist/portfolio-frontend/`. Deploy those static files to any static host (Netlify,
Vercel, GitHub Pages, S3, etc.), and update `environment.prod.ts` with your real backend URL and
`CorsConfig.java`'s `allowedOrigins` with your real frontend domain before deploying the backend.

## Notes

- This was scaffolded and built with the real Angular CLI and verified with `ng build` to confirm
  it compiles cleanly. `ng test` needs Chrome installed locally to run (Karma launches a headless
  Chrome instance), so run that on your own machine to confirm the included spec passes.
- The backend could not be compiled/tested in the environment this was generated in (no access to
  Maven Central or a MySQL instance there), so run `mvn spring-boot:run` on your machine to confirm
  it starts cleanly, and double check your MySQL credentials in `application.properties`.
