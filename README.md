#  Movie API - Spring Boot Application

##  Project Overview
The Movie API is a backend service built with Spring Boot that manages movies and user interactions.
It integrates seamlessly with the OMDb API using Spring’s WebClient, enabling administrators to search for movies by title or IMDb ID and import them directly into the local database.
Once imported, movies are persisted in a MySQL database (managed with Liquibase migrations) and become available to all registered users.

The application provides secure authentication and authorization using JWT tokens and enforces role-based access control:

Admins can manage movies (search, import, delete).

Users can browse, view details, and rate movies.

The project uses MapStruct for DTO ↔ Entity mapping and exposes a fully documented REST API with Swagger / OpenAPI.

This makes the Movie API a scalable, extensible, and production-ready backend service for movie management and integration with external movie data sources.


---

##  Technologies Used
- Java 24  
- Spring Boot
- Spring Security + JWT  
- Spring WebClient  
- MySQL Database  
- Swagger (springdoc-openapi) 

---

##  Features
- *Springboot* –  A framework for building Java-based applications.
- *JWT Authentication* – secure login and role-based access.
- *MySQL Database* – Relational batabase for users, movies, and ratings.
- *Liquibase* – database migrations for version control.
- *MapStruct* – DTO ↔ Entity mapping for clean code.
- *Spring WebClient* – fetch movie data from the OMDb API.
- *Swagger / OpenAPI 3.0* – interactive API documentation.

 
---

## Setup & Installation

### Prerequisites

### Make sure you have the following installed:

- Java 24+
- Maven 3+
- MySQL database
- OMDb API key (free signup: [omdbapi.com/apikey.aspx](https://www.omdbapi.com/apikey.aspx))
  
---

### Steps to run locally
#### 1- Clone repository:
```
git clone https://github.com/devmohamedfarag/movie-management-api.git
```
#### 2- Navigate to the project folder:
```
cd movie-api
```
#### 4- Configure application.properites

#### 5- Update DB credentials & OMDb API key

#### 6- Build the application:
```
./mvnw clean install
```

#### 7- Run migrations & start application
```
mvn spring-boot:run
```

---

## Databaase users seed:

##### 1- Admin: 
- username: admin
- password: admin123

##### 2- User: 
- username: mohamed
- password: user123
