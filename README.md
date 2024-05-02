# Course-Registration-System

# Class Diagram
![2](https://github.com/shubhiscoding/Course-Registration-System/assets/146775311/03c1aad2-988f-4718-a135-b7e4804328ec)

# Running The Project

First step is to Clone the repo in your system and run the project.
General Endpoint: http://localhost:8080
## Admin Documentation

### Create Admin

- **Request Type:** POST
- **Endpoint:** `/admin/`
- **Request Example:**
```json
{
    "admin_UserName": "thisIsYourAdmin",
    "admin_Email": "myemail@mail.co",
    "admin_FirstName": "First",
    "admin_LastName": "Last",
    "admin_Password": "yourAdmin123"
}
```
- **Response Example:**
```json
{
    "admin_UserName": "thisIsYourAdmin",
    "admin_Email": "myemail@mail.co",
    "admin_FirstName": "First",
    "admin_LastName": "Last"
}
```

### Update Admin

- **Request Type:** PATCH
- **Endpoint:** `/admin/`
- **Request Example:**
```json
{
    "admin_UserName": "thisIsYourAdmin",
    "admin_Email": "myemail@mail.co",
    "admin_FirstName": "New name",
    "admin_LastName": "new Last name",
    "admin_Password": "yourAdmin123"
}
```
- **Response Example:**
```json
{
    "admin_UserName": "thisIsYourAdmin",
    "admin_Email": "myemail@mail.co",
    "admin_FirstName": "New name",
    "admin_LastName": "new Last name"
}
```

### Get Admin

- **Request Type:** GET
- **Endpoint:** `/admin/{username}`
- **Request Example:** Fill admin username in `{username}` in the endpoint
- **Response Example:**
```json
{
    "admin_UserName": "thisIsYourAdmin",
    "admin_Email": "myemail@mail.co",
    "admin_FirstName": "First",
    "admin_LastName": "Last"
}
```

### Delete Admin

- **Request Type:** DELETE
- **Endpoint:** `/admin/`
- **Request Example:**
```json
{
    "admin_UserName": "thisIsYourAdmin",
    "admin_Email": "myemail@mail.co",
    "admin_FirstName": "New name",
    "admin_LastName": "new Last name",
    "admin_Password": "yourAdmin123"
}
```
- **Response Example:** No response

## Course Documentation

### Add Course

- **Request Type:** POST
- **Endpoint:** `/courses/`
- **Request Example:**
```json
{
    "courseId": "",
    "name": "New course",
    "description": "Course on web3",
    "credits": "100",
    "departmentId": "1",
    "adminUsername": "Mein_Hoon_Giyan",
    "password": "admin1123"
}
```
- **Response Example:**
```json
{
    "courseId": 9,
    "name": "New course",
    "description": "Course on web3",
    "credits": 100,
    "department": null,
    "students": [],
    "instructor": "Kshitij"
}
```

### Update Course

- **Request Type:** PUT
- **Endpoint:** `/courses/`
- **Request Example:**
```json
{
    "courseId": "9",
    "name": "course",
    "description": "Course on web3",
    "credits": "100",
    "departmentId": "1",
    "adminUsername": "Mein_Hoon_Giyan",
    "password": "admin1123"
}
```
- **Response Example:**
```json
{
    "courseId": 9,
    "name": "course",
    "description": "Course on web3",
    "credits": 100,
    "department": null,
    "students": [],
    "instructor": "Kshitij"
}
```

### Delete Course

- **Request Type:** DELETE
- **Endpoint:** `/courses/{id}`
- **Request Example:** Replace `{id}` with the course ID in the endpoint
- **Response Example:** No response

## Instructor Documentation

### Get Instructor by ID

- **Request Type:** GET
- **Endpoint:** `/instructor/{id}`
- **Request Example:** Replace `{id}` with the instructor ID in the endpoint
- **Response Example:** Returns details of the instructor with the specified ID.

### Get All Instructors

- **Request Type:** GET
- **Endpoint:** `/instructor`
- **Response Example:** Returns details of all instructors.

### Get Instructor by Course ID

- **Request Type:** GET
- **Endpoint:** `/instructor/courses/{id}`
- **Request Example:** Replace `{id}` with the course ID in the endpoint
- **Response Example:** Returns details of the instructor associated with the specified course ID.

### Get Instructors by Department ID

- **Request Type:** GET
- **Endpoint:** `/instructor/department/{id}`
- **Request Example:** Replace `{id}` with the department ID in the endpoint
- **Response Example:** Returns details of all instructors associated with the specified department ID.

### Create Instructor

- **Request Type:** POST
- **Endpoint:** `/instructor`
- **Request Example:**
```json
{
    "name": "John Doe",
    "title": "Professor",
    "departmentId": 1,
    "adminUsername": "admin",
    "password": "admin123"
}
```
- **Response Example:** Returns details of the newly created instructor.

### Update Instructor

- **Request Type:** PUT
- **Endpoint:** `/instructor`
- **Request Example:**
```json
{
    "instructorId": 1,
    "name": "John Doe",
    "title": "Associate Professor",
    "departmentId": 1,
    "adminUsername": "admin",
    "password": "admin123"
}
```
- **Response Example:** Returns details of the updated instructor.

### Delete Instructor

- **Request Type:** DELETE
- **Endpoint:** `/instructor`
- **Request Example:**
```json
{
    "instructorId": 1,
    "adminUsername": "admin",
    "password": "admin123"
}
```
- **Response Example:** No response

## Department Documentation

### Get Department by ID

- **Request Type:** GET
- **Endpoint:** `/department/{id}`
- **Request Example:** Replace `{id}` with the department ID in the endpoint
- **Response Example:** Returns details of the department with the specified ID.

### Add Department

- **Request Type:** POST
- **Endpoint:** `/department/`
- **Request Example:**
```json
{
    "name": "Department of Computer Science",
    "adminUsername": "admin",
    "password": "admin123"
}
```
- **Response Example:** Returns details of the newly created department.

### Update Department

- **Request Type:** PUT
- **Endpoint:** `/department/`
- **Request Example:**
```json
{
    "departmentId": 1,
    "name": "New Department Name",
    "adminUsername": "admin",
    "password": "admin123"
}
```
- **Response Example:** Returns details of the updated department.

### Delete Department

- **Request Type:** DELETE
- **Endpoint:** `/department/`
- **Request Example:**
```json
{
    "departmentId": 1,
    "adminUsername": "admin",
    "password": "admin123"
}
```
- **Response Example:** Returns a success message indicating the department deletion.

## Student Documentation

### Add Student

- **Request Type:** POST
- **Endpoint:** `/students`
- **Request Example:**
```json
{
    "name": "John Doe",
    "email": "john@example.com",
    "courseId": 1,
    "adminUsername": "admin",
    "password": "admin123"
}
```
- **Response Example:** Returns details of the newly added student.

### Enroll Student

- **Request Type:** POST
- **Endpoint:** `/students/enroll`
- **Request Example:**
```json
{
    "name": "John Doe",
    "email": "john@example.com",
    "courseId": 1,
    "adminUsername": "admin",
    "password": "admin123"
}
```
- **Response Example:** Returns details of the enrolled student.

### Get Student by ID

- **Request Type:** GET
- **Endpoint:** `/students/{id}`
- **Request Example:** Replace `{id}` with the student ID in the endpoint
- **Response Example:** Returns details of the student with the specified ID.

### Get Students by Course ID

- **Request Type:** GET
- **Endpoint:** `/students/course/{id}`
- **Request Example:** Replace `{id}` with the course ID in the endpoint
- **Response Example:** Returns details of all students enrolled in the course with the specified ID.

### Update Student

- **Request Type:** PUT
- **Endpoint:** `/students`
- **Request Example:**
```json
{
    "studentId": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "adminUsername": "admin",
    "password": "admin123"
}
```
- **Response Example:** Returns details of the updated student.

### Delete Student

- **Request Type:** DELETE
- **Endpoint:** `/students/{id}`
- **Request Example:** Replace `{id}` with the student ID in the endpoint
- **Response Example:** No response
