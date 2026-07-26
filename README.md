# 📚 Library Management System (Java JDBC)

A console-based **Library Management System** built with **Java**, **JDBC**, and **MySQL**. This project demonstrates CRUD operations, relational database design, SQL JOINs, and Java database connectivity.

## 🚀 Features

- 📖 Manage books
  - Add new books
  - View all books
  - Search books by title
  - Update book information
  - Delete books
  - Sort books (Title, Quantity)

- 👥 Manage members
  - Add new members

- 📚 Borrow management
  - Record borrowed books
  - View borrowing history using **INNER JOIN**

- 💾 MySQL database integration using JDBC

---

## 🛠️ Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL
- MySQL Workbench
- Maven
- IntelliJ IDEA

---

## 📂 Database Structure

### Books

| Column | Type |
|---------|------|
| book_id | INT (Primary Key, Auto Increment) |
| title | VARCHAR |
| author | VARCHAR |
| publish_date | DATE |
| quantity | INT |

### Members

| Column | Type |
|---------|------|
| member_id | INT (Primary Key, Auto Increment) |
| full_name | VARCHAR |
| email | VARCHAR |
| phone | VARCHAR |

### Borrow

| Column | Type |
|---------|------|
| borrow_id | INT (Primary Key, Auto Increment) |
| member_id | INT (Foreign Key) |
| book_id | INT (Foreign Key) |
| borrow_date | DATE |
| return_date | DATE |

---

## 📌 Project Structure

```
src
│
├── Database.java
├── LibraryManagement.java
└── pom.xml
```

---

## ⚙️ Setup

### 1. Clone the repository

```bash
git clone https://github.com/your-username/your-repository.git
```

### 2. Create the MySQL database

```sql
CREATE DATABASE library_db;
```

Import or create the required tables.

### 3. Configure the database connection

Update `Database.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/library_db";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

### 4. Install dependencies

Maven will automatically download the MySQL JDBC Driver.

---

## 📷 Console Menu

```
========== Library Management ==========
1. Add Book
2. Show Books
3. Update Book
4. Delete Book
5. Search Book
6. Sort Books
7. Add Member
8. Borrow Book
9. Show Borrow History
0. Exit
```

---

## 💡 SQL Concepts Used

- INSERT
- SELECT
- UPDATE
- DELETE
- ORDER BY
- INNER JOIN
- Foreign Key
- Primary Key
- PreparedStatement
- ResultSet

---

## 📚 What I Learned

Through this project, I learned:

- Designing relational databases
- Connecting Java to MySQL using JDBC
- Implementing CRUD operations
- Using PreparedStatement to prevent SQL Injection
- Retrieving data using ResultSet
- Working with Primary Keys and Foreign Keys
- Building SQL JOIN queries
- Structuring a Java console application

---

## 📄 Future Improvements

- Member CRUD
- Return book feature
- Login system
- Book availability validation
- Fine calculation for overdue books
- Search by author
- Pagination
- GUI version using JavaFX
- REST API version using Spring Boot

---

## 👨‍💻 Author

**Yusuf Hamasah**

Backend Developer Enthusiast

GitHub: https://github.com/your-username
