# Study APIR

API java para estudo de Spring Boot

## MER

![](assets/images/mer.png)

## Instalação

- Configuração do Swagger
    - https://springdoc.org/properties.html

- application.properties
    
    ```
    server.port=9000
	spring.application.name=study-apir
	pringdoc.swagger-ui.path=/
    ```

## Navegação

### Executar a API
- *Executando* **Maven**

    ```
    mvn spring-boot:run
    ```

### Documentação API (swagger)
	
- http://localhost:9000/swagger-ui/index.html

## Referencias

- https://springdoc.org/

## Docker 

### Comandos Docker

- **No BASH**

	- `docker ps` → visualizar containers


### Conexões com BD - MySQL

- My SQL

	```
	docker run -d \
		--name mysql \
		--rm \
		-e MYSQL_ROOT_PASSWORD=root_pwd \
		-e MYSQL_USER=new_user \
		-e MYSQL_PASSWORD=my_pwd \
		-p 3306:3306 \
		mysql
	```


