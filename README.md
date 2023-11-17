# HOTELIER LISTINGS

## Description

This Kotlin Rest API manages items (a type of accommodation) and its bookings.
The API has been designed with the Open API specification. It's developed in Kotlin as main 
programming language, uses Spring Boot as web and data framework, and stores some relevant 
information in an H2 embedded database

### Endpoints

1. GET /items?hotelierId=: gets items that belong to a given hotelier
2. GET /items/{id}: gets an item by its id
3. POST /items: creates a new item
4. PUT /items/{id}: updates any property of an item
5. DELETE /items/{id}: deletes an item
6. POST /items/booking/{id}: books an item by reducing its availability by 1

### Prerequisites

- You will need the following installed.

```
Kotlin 1.8.22 or above
Java 17 or above
Maven 3.9.5 or above
```

### Building

- First generate a jar file of the application using maven. Go to the root folder of the project 
and execute:

```
./mvnw clean install (Linux/Mac) or mvn.bat clean install (Windows)
```

- Then, build a Docker image, so many instances can be easily executed at the same time. 
The following command will create a docker image that can be used to create multiple containers:

```
docker build --build-arg SERVER_PORT=8080 -t hotelier-listings .
```

### Executing

- To generate a container from the image generated in the previous step execute:

```
docker run -p 8080:8080 hotelier-listings
```

### Testing

- In the root folder of the project there's a postman collection (v2.1) with requests for every 
available endpoint. The file is `Trivago Challenge.postman_collection.json`

#### H2 Console
- The H2 web console has been enabled to check the data being updated at the moment. It can be 
accessed using the following information:

```
JDBC URL: jdbc:h2:mem:listingsdb;DB_CLOSE_DELAY=-1
Username: sa
Password: (empty string)
```

And these are helpful queries to run to check the data:

```
select * from hotelier;
select * from location;
select * from item;
```