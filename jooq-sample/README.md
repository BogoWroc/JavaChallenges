Goal
---
Build a simple application for CRUD operations via JOOQ library.

Environment
---
- JAVA 17 SE
- Docker

How to run?
---
- Run database backend
```cmd
docker compose up -d
```
- Generate database model using JOOQ
```cmd
mvn clean package
```
- Add generated artifacts to the classpath
```code
./target/generated-sources
```
- Run 
```cmd
org/example/Main.java
```
- View DB
Use web browser, login data are stored in .env file
```
http://localhost:8080
```

- Stop db

```cmd
 docker compose stop && docker compose rm -f
```
Materials
---
https://onexlab-io.medium.com/docker-compose-mysql-initdb-4c3388047dea
https://www.baeldung.com/jooq-intro
https://www.petrikainulainen.net/programming/jooq/using-jooq-with-spring-code-generation/
