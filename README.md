# Spring-boot-restapi

I have used this project as a fun way of learning Spring Boot during these Coronavirus Days, it is not mean to be used for anything at all, is just an academic project for learning purposes. This is an Restful API which is created to manage a group of clients in a Front-End application, in my case, I used Angular but this is totally irrelevant as a project limitation since a Restful API is being used.

## Getting Started

In case you want to try this project, feel free to download it and remember to give me a little credit if you use it professionally.

### Prerequisites

The whole application is build using Java and Spring Boot as a framework, you will need a JDK (preferably 1.8, this is the one I used) and as an interface to manage relational data JPA, as you might be thinking now, you need and enviromment where you can create a MySQL db to connect with this Restful API.

As soon as you clone the repo and try to run it using IntelliJ (seriously, I recommend using this IDE) you will notice file "application.properties" and some other important files are missing, this is because at those files there is some stuff i didn't want to share and I added them to my .gitignore, you can check this file to know which files are left to add in case you want to get a successful run. 

Here you can see an example of how file "application.properties" should be in order to run the application properly:

```
spring.datasource.url=jdbc:mysql://localhost/db_springboot_backend?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=user
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=create-drop
logging.level.org.hibernate.SQL=debug
spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB

```
As you can see, in this file all you have to do is setting the database resource and adding some configuration params to make possible some stuff as uploading a large image to the backend and using JPA to manage your persistent data. You really want to let parameters as "logging.level.org.hibernate.SQL=debug" to know what is JPA doing behind the scenes at server reload and "spring.jpa.hibernate.ddl-auto=create-drop" to run, everytime this happens, a SQL script which is supposed to fill our database with dummy data. This SQL script is located on /src/main/resources/import.sql 

Once everything has been set up successfully, you can use Postman to make your own requests.

## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - The Java framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Tomcat](http://tomcat.apache.org/) - As a development server
* [MySQL](https://www.mysql.com/) - As relational database
* [OpenSSL](https://www.openssl.org/) - As a tool for generating RSA keys.

## Authors

* **Alejandro Perdomo** - [Apergot](https://github.com/Apergot)

## License

This project has NO LICENSE, so, the work is under exclusive copyright by default.