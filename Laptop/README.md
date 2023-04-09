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


## Entidad Laptop

1.- Laptop
2.- LaptopRepository
3.- LaptopController
    1.- Buscar todos los Laptop
    2.- Buscar un solo Laptop
    3.- Crear un nuevo Laptop
    4.- Actualizar un Laptop existente   
    5.- Borrar un Laptop
    6.- Borrar todos los Laptop

Setting Up Swagger 2 with a Spring REST API Using Springfox

1.- Spring Boot 2.7 
2.- Adding the Maven Dependency
    	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
3.-Swagger

    <!-- https://mvnrepository.com/artifact/io.springfox/springfox-boot-starter -->
		<dependency>
			<groupId>io.springfox</groupId>
			<artifactId>springfox-boot-starter</artifactId>
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