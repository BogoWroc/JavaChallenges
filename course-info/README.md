Maven repository
---
https://central.sonatype.com

About application
---

Application is used for fetching list of Pluralsight courses for selected author and store it in the database.
Additionally, application exposes two endpoints for fetching data from database and for adding course notes.

Used technologies
---
- H2 database
- JAVA SE 17
- Jersey JAX-RS

How to use it?
--
- first run course-info-cli to fetch Pluralsight courses
- run server to expose REST API
- use http://localhost:8080/courses to display fetched list of courses
- 
How to add notes to selected course?
---
❯ curl -X POST -H "Content-Type: text/plain" -d "My course notes..." http://localhost:8080/courses/061f4437-be83-44c9-812f-82453fa3fb0b/notes


