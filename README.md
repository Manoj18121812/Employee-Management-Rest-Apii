# 📌 Employee Management REST API 

A medium-level Spring Boot REST API for managing employees with smart features like search, filtering, sorting, and pagination.
Perfect for practicing real-world backend development with MySQL + JPA. 🚀

---

## 🚀 Features

### 👤 Employee CRUD (Basic)

* ➕ Add Employee
* 📄 Get All Employees
* 🔍 Get Employee by ID
* ✏️ Update Employee
* ❌ Delete Employee

---

### 🔥 Extra (Medium-Level) Features

* 🔎 Search by name (LIKE search)
* 🏢 Filter by Department
* 💰 Salary Range Filter (min–max)
* 📊 Sort by Salary (ASC / DESC)
* 📄 Pagination (page + size)

---

## 🛠 Tech Stack

* ☕ Java 17+
* 🌱 Spring Boot
* 🗄 MySQL
* 🔗 Spring Data JPA
* 📡 REST API
* 🧪 Postman

---

## 📦 Spring Initializr Dependencies

### Required

* Spring Web
* Spring Data JPA
* MySQL Driver

### Optional

* Lombok
* Spring Boot DevTools

---

## 🔧 application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🧪 POSTMAN TESTING (API Examples)

### ➤ Add Employee (POST)

`http://localhost:8080/api/employees`

**Body:**

```
{
  "name": "Manoj",
  "department": "IT",
  "salary": 45000
}
```

---

### ➤ Get All Employees (GET)

`http://localhost:8080/api/employees`

---

### ➤ Search by Name (LIKE)

`http://localhost:8080/api/employees/search/man`

---

### ➤ Get By Department

`http://localhost:8080/api/employees/department/IT`

---

### ➤ Salary Range Filter

`http://localhost:8080/api/employees/salary/30000/50000`

---

### ➤ Sort by Salary (ASC / DESC)

`http://localhost:8080/api/employees/sort/asc`

`http://localhost:8080/api/employees/sort/desc`

---

### ➤ Pagination

`http://localhost:8080/api/employees/page/0/5`

---
