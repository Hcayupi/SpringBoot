## Spring Boot

Proyecto Spring Boot las dependencias / starters:

Starters para presistencias:
* H2
* Spring Data JPA

Starters para web:
* Spring Boot Dev tools
* Spring Web

Aplicación API REST con acceso a base de datos H2 para persistir la información

El acceso se puede realizar desde Postman o Navegador


## Entidad Book

1.- Book
2.- BookRepository
3.- BookController
    1.- Buscar todos los libros
    2.- Buscar un solo libro
    3.- Crear un nuevo libro
    4.- Actualizar un libro existente   
    5.- Borrar un libro
    6.- Borrar todos los libros

Setting Up Swagger 2 with a Spring REST API Using Springfox

1.- Spring Boot 2.7 
2.- Adding the Maven Dependency
    <dependency>
        <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
        <version>3.0.0</version>
    </dependency>
3.-Spring Boot Dependency
    <dependency>
        <groupId>io.springfox</groupId>
            <artifactId>springfox-boot-starter</artifactId>
        <version>3.0.0</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.4.0</version>
    </dependency>
    3.1- Enabling Springfox's Swagger UI
            <dependency>
                <groupId>io.springfox</groupId>
                    <artifactId>springfox-swagger-ui</artifactId>
                <version>3.0.0</version>
            </dependency>
4.- Integrating Swagger 2 Into the Project
    4.1.- Java Configuration
            @Configuration
            public class SpringFoxConfig {                                    
                @Bean
                public Docket api() {
                    return new Docket(DocumentationType.SWAGGER_2)  
                    .select()                                  
                    .apis(RequestHandlerSelectors.any())              
                    .paths(PathSelectors.any())                          
                    .build();                                           
                }
            }
5.- http://localhost:8080/swagger-ui/