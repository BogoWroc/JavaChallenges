How to generate a simple project
---

mvn archetype:generate -DartifactId=maven-archetype-simple -DarchetypeGroupId=org.apache.maven.archetypes -DinteractiveMode=false -DgroupId=org.example -DartifactId=jdbc-app -Dpackage=org.example

How to run
---
1. docker compose up -d
2. wait a minute for DB up and init
3. run App.java

How to stop
---
1. docker compose down