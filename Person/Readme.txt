-------------------This is a Person data Stroing CRUD application created using java and its frameworks:------------------------

Programming languages used for this project:
1)Java (8)
2)Spring boot (2.7.7 snapshot)
3)Mysql
4)AWS Cloud RDS
Maven repositories are back bone for this project such as :
1)Lambok
2)ThymeLeaf
3)Spring Web
4)Java Fx Persistance validation
---->
For installing Maven project we need to Have maven type project support in eclipse.
Then we need Some tools to set a spring boot application:
Spring Tools 4 (aka Spring Tool Suite) 4.17
Eclipse Webdeveloper Tools for web editing tools.

1)This Personal Data application is used to store that data in AWS RDS Mysql database.
 it has many classes and a interface as listed below.
  i) Person class:
     it needes annotaions like Lambok @Data Generator, @Enity to create tables in database.
  ii)PersonController: 
     it has @controller annotation and @Autowired to get The personrepository in this class and mainly it has the Mappinggs to URl
  iii)PersonApplication:
  it is the main application which has the @SpringBootApplication annotaion to start the application.
  iv)page cache: 
  Page cache file is used to store the data into the cache
  v)pagecacheconfig:
   This class contains configuration for page cache and @Bean for page cache
  vi)PageCounter:
  this class contains @component and @Data annotaions to create Getteers and seeters 
  vii)Pagecouncontroller:
  this class contains mappings for pagecounter class and @restcontroller annotations
  viii)PageCountConfig:
  this is @configuration annotaion for pagecounter.
1)interface
  i)PersonRepository:
   this interface has the methods to crud application by implimenting Crudrepositor

Application Starting Procedure:
1)to run this application run personApplication.java it starts running on localhost:8080 port to accsess the web application.
2)To make this web application attarctive i used bootsrap in all the html pages
3)To get the data from java to web page used thymleaf in all pages.
4)The first page is index.html '/' in URl
it has the features like nav bar to navigate to all pages from index and it has sample advertisement images of tools used in project
and it has a counter which displayes the count every three seconds automatically.
5)By clicking on Create button navigates personform.html
which has input fileds for data input it takes input from data and stores into data base after clicking subminting button.
6)Saved.html files has the success message and displayed when dat is stored on databse.
7)if it has any error it will agin tranfered to personform.html
8)If we want to se all the details of person which already stored in the database and naviagets to listperson.html.
9)all the pages have the autocounter and navbar to navigate.
10) application properties class have the information to connect databse in aws.
11)EmployeesRepository  interface which extends the CrudRepository to make the system perform the persisting of the data into the database.	
12)Test cases are there to test all methods in the project.
13)Pom.xml file contains all dependencies required to fnish the application as shown below.
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-aws-jdbc</artifactId>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>

Appliction.properties:

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://database-1.cq4xewe3g9v9.us-east-2.rds.amazonaws.com:3306/students
spring.datasource.username=admin
spring.datasource.password=12345678Aa
cloud.aws.region.static=us-east-2
cloud.aws.stack.auto=false
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

