# Library Management System REST API
This project aims to develop a RESTful API for a library management system. CRUD (Create, Read, Update, Delete) operations can be performed in the project.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok

## Endpoints

### Book

- **GET /api/books**: Retrieves a list of all books.
- **GET /api/books/{id}**: Retrieves details of a specific book.
- **POST /api/books**: Adds a new book.
- **PUT /api/books/{id}**: Updates information of a book.
- **DELETE /api/books/{id}**: Deletes a book.

### Author

- **GET /api/authors**: Retrieves a list of all authors.
- **GET /api/authors/{id}**: Retrieves details of a specific author.
- **POST /api/authors**: Adds a new author.
- **PUT /api/authors/{id}**: Updates information of an author.
- **DELETE /api/authors/{id}**: Deletes an author.

### Category

- **GET /api/categories**: Retrieves a list of all categories.
- **GET /api/categories/{id}**: Retrieves details of a specific category.
- **POST /api/categories**: Adds a new category.
- **PUT /api/categories/{id}**: Updates information of a category.
- **DELETE /api/categories/{id}**: Deletes a category.

### Publisher

- **GET /api/publishers**: Retrieves a list of all publishers.
- **GET /api/publishers/{id}**: Retrieves details of a specific publisher.
- **POST /api/publishers**: Adds a new publisher.
- **PUT /api/publishers/{id}**: Updates information of a publisher.
- **DELETE /api/publishers/{id}**: Deletes a publisher.

### Book Borrowing

- **GET /api/book-borrowings**: Retrieves a list of all book borrowing operations.
- **GET /api/book-borrowings/{id}**: Retrieves details of a specific book borrowing operation.
- **POST /api/book-borrowings**: Adds a new book borrowing operation.
- **PUT /api/book-borrowings/{id}**: Updates information of a book borrowing operation.
- **DELETE /api/book-borrowings/{id}**: Deletes a book borrowing operation.
