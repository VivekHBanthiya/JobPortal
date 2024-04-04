# Spring Boot JobPortal Application with MySQL Database

This Spring Boot project demonstrates Backend working of JobPortal how to perform CRUD (Create, Read, Update, Delete) operations using a MySQL database. Follow these steps to set up and run the project:

## Tools Required
- **IntelliJ IDE:** We recommend using IntelliJ IDEA as the development environment.
- **Postman:** A popular tool for testing RESTful APIs.
- **MySQL Workbench:** For managing the MySQL database.

## Project Setup

1. Clone or download this project and open it in IntelliJ IDEA.
2. Ensure that you refresh Maven dependencies to avoid any potential errors.

## Database Configuration

Before running the application, make sure you have created a MySQL database schema named "JobPortal" using MySQL Workbench. And edit the application.properties file as per your database_name, username and password

## Running the Application

1. Run the `JobPortalApplication` class. If everything is set up correctly, you will see a message in the console saying "Started JobPortalApplication."

## Using Postman

In Postman, you can test the following five types of operations:

### 1. GET - Get Specific Jobs Data

To retrieve specific Jobs data using a Job ID, use the following URL:

```
GET http://localhost:8080/Jobs/{JobId}
```

Replace `{JobID}` with the actual Job ID you want to retrieve.

### 2. GETALL - Get All Jobs Data

To retrieve details of all Job, use the following URL:

```
GET http://localhost:8080/Jobs/all-Jobs
```

### 3. POST - Create New Job

To create a new Job, send a POST request to the following URL with JSON data in the request body:

```
POST http://localhost:8080/Jobs/new-Job
```

Example JSON request body:

```json
{
    "role": "Software Engineer",
    "company": "Amdocs",
    "location": "Pune",
    "maxSalary": 800000,
    "minSalary": 600000,
    "bond": false
}
```

### 4. PUT - Update Existing Job Details

To update existing Job details, send a PUT request to the following URL, replacing `{JobID}` with the Job ID you want to update:

```
PUT http://localhost:8080/Jobs/{JobId}
```

Include the updated Job data in the request body.

### 5. DELETE - Delete Job Data

To delete a Job by Job ID, send a DELETE request to the following URL:

```
DELETE http://localhost:8080/Jobs/{JobId}
```

Replace `{JobID}` with the Job ID you want to delete from the database.

## Enjoy Using the JobPortal Application!

Feel free to use this JobPortal application to manage Job available data in your MySQL database. If you encounter any issues or have questions, please refer to the project's documentation or seek assistance from the development team.
