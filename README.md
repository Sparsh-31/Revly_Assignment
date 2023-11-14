# Doubt Solving Platform

## Tech Stack
- **Backend:** Java, Spring Boot, Spring Data JPA
- **Database:** MySQL
- **Authentication:** JSON Web Tokens (JWT)

## Features
1. **User Management:**
   - Registration and login for Students and Tutors.
   - User roles: Student, Tutor.

2. **Doubt Creation:**
   - Students can create doubt requests specifying the class grade, language, and doubt subject.
   - Doubt requests are processed in real-time.

3. **Tutor Availability:**
   - Tutors can set their availability status.
   - Periodic polling function to update tutor availability.
   - CRON job to count real-time available tutors.

4. **Doubt Handling:**
   - Matching logic to connect students with available tutors based on language, class grade, and subject expertise.
   - Clarifying answers provided by tutors for doubt requests.

5. **Doubt History:**
   - Students can view their doubt history, sorted by timestamp.

## Getting Started

### Prerequisites
- JDK 17
- MySQL

### Installation
1. Clone the repository.
   ```bash
   git clone https://github.com/Sparsh-31/Revly_Assignment.git
   cd Revly_Assignment
   ```

2. Set up the database.
   - Create a MySQL database named `Revly`.
   - Update `application.properties` with your database configuration.

3. Run the application.
   ```bash
   ./mvnw spring-boot:run
   ```

### Usage
- Access the application at [http://localhost:8080](http://localhost:8080).
- [Any additional usage instructions]

## Technologies Used
- [Java](https://www.java.com/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)
- [JSON Web Tokens (JWT)](https://jwt.io/)

## Important Endpoints
- **Registration:** `/api/register` (POST)
- **Login:** `/api/login` (POST)
- **Create Doubt Request:** `/api/doubt/create` (POST)
- **Get Doubt History:** `/api/doubt/history/{userId}` (GET)

