# Study APIR

API java para estudo de Spring Boot

## Docker 

### Comandos Docker

- **No BASH**

	- `docker pull ubuntu` → download da imagem do SO ubuntu (tipo de linux)

	- `docker images` → fala as imagens que temos no docker

	- `docker run ubuntu` → executamos o container do ubuntu

	- `docker ps -a` → ver os containers criados através de imagem

- **No POWERSHELL**

	- `docker run -it ubuntu` → manter dentro do container executando - entrando no modo interativo
	- `uname` → mostra o nome do ambiente

	- `ls` → listar

	- `ls -lah` → listar em formato de “lista”

	- `exit` → sair do container

### Conexões com BD

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


## Instalação

*Limpar e criar pasta* */target*

## Navegação

### documentação API (swagger)
*executando* **Maven**

	mvn spring-boot:run
	
## Referencias

https://springdoc.org/
