# Loan Origination System

This is a Java-based Loan Origination System (LOS) designed to manage loan applications and user administration efficiently. The system includes role-based dashboards for Admins, Managers, Loan Officers, Underwriters, and App Users. It provides functionalities such as loan application management, user registration, editing user details, toggling account statuses, and activity logging.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [Setup and Installation](#setup-and-installation)
- [Deployment](#deployment)
- [Database Setup](#database-setup)
- [Usage](#usage)
- [Future Enhancements](#future-enhancements)
- [License](#license)

## Features

- Role-based dashboards for Admins, Managers, Loan Officers, Underwriters, and App Users.
- User management: Register, edit, delete, and toggle user status (freeze/unfreeze).
- Loan application management: Create, view, assign, and track the status of loan applications.
- Search functionality for users and loan applications.
- Activity logging for recent system actions.
- Pagination and search capabilities for user and loan management.
- Integrated authentication and authorization using Spring Security.

## Technologies

- Java
- Spring Boot
- Thymeleaf
- Spring Security
- MySQL (Database)
- JPA/Hibernate
- Lombok
- AWS (EC2 & S3 for deployment)
- Git/GitHub for version control

## Setup and Installation

### Prerequisites

- Java 17 or higher
- Maven
- MySQL Database
- AWS EC2 (for deployment)
- AWS S3 (for static assets)

### Clone the Repository

1. Clone the project from GitHub:

    ```bash
    git clone https://github.com/r-bute/LoanOriginationSystem.git
    cd loan-origination-system
    ```

2. Install the necessary dependencies:

    ```bash
    mvn clean install
    ```

3. Configure application properties in `src/main/resources/application.properties`:

    ```properties
    spring.datasource.url=jdbc:mysql://<your-db-url>:3306/loanoriginationdb
    spring.datasource.username=root
    spring.datasource.password=<your-db-password>
    spring.jpa.hibernate.ddl-auto=update
    ```

4. Run the application:

    ```bash
    mvn spring-boot:run
    ```

### Database Setup

1. Create a MySQL database:
   
    ```sql
    CREATE DATABASE loanorigination;
    ```

2. Update the database credentials in `application.properties`.

3. Use JPA/Hibernate to auto-generate tables when the application runs for the first time.

## Deployment

### AWS EC2 and S3 Deployment

- Set up an EC2 instance on AWS for hosting the application.
- Use AWS S3 for static file storage (e.g., CSS, JS, images).
- Deploy the application using a combination of `scp` to copy files or set up continuous deployment with GitHub Actions.

1. **Connect to EC2**:

    ```bash
    ssh -i "your-key.pem" ec2-user@ec2-xx-xxx-xxx-xxx.compute-1.amazonaws.com
    ```

2. **Transfer JAR to EC2**:

    ```bash
    scp -i "your-key.pem" target/loan-origination-system.jar ec2-user@ec2-xx-xxx-xxx-xxx.compute-1.amazonaws.com:~
    ```

3. **Run the Application**:

    ```bash
    java -jar loan-origination-system.jar
    ```

## Usage

### Access the Application

Once deployed, access the application through your web browser at: http://184.72.163.103:8080/

