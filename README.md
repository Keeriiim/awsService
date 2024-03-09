# awsService

# Spring Book CRUD API

This project is a simple Spring Boot application that provides CRUD (Create, Read, Update, Delete) endpoints for managing books in a SQL database hosted on amazon.
The required domain to reach the endpoints are:
http://beanstalk-spring-crud-env.eba-diuswvnf.eu-north-1.elasticbeanstalk.com  
Below are the endpoints available with example code:

---

## Endpoints

### Add a Book
**Description:** Adds a new book to the database.
- **URL:** `/sqlbooks`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "title": "Example Book",
        "author": "John Doe"
    }
    ```
- **Response:**
    ```json
    {
        "id": 1,
        "title": "Example Book",
        "author": "John Doe"
    }
    ```

---

### Get All Books
- **Description:** Retrieves a list of all books from the database.
- **URL:** `/sqlbooks`
- **Method:** `GET`
- **Response:**
    ```json
    [
        {
            "id": 1,
            "title": "Example Book 1",
            "author": "John Doe"
        },
        {
            "id": 2,
            "title": "Example Book 2",
            "author": "Jane Smith"
        }
    ]
    ```


---

### Delete a Book
- **Description:** Deletes a book with the specified ID from the database.
- **URL:** `/sqlbooks/{id}`
- **Method:** `DELETE`
- **Response:**
    ```json
    {
        "id": 1,
        "title": "Example Book",
        "author": "John Doe"
    }
    ```


---

### Update a Book
- **Description:** Updates the details of a book with the specified ID in the database.
- **URL:** `/sqlbooks/{id}`
- **Method:** `PUT`
- **Request Body:**
    ```json
    {
        "title": "Updated Book Title",
        "author": "Jane Smith"
    }
    ```
- **Response:**
    ```json
    {
        "id": 1,
        "title": "Updated Book Title",
        "author": "Jane Smith"
    }
    ```


---






# Additional info
# CI-CD

- Github actions
  Ga was used to test the build function with Github, to see the yaml file see .github/workflows/maven.yaml
