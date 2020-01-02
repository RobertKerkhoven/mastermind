
https://www.baeldung.com/spring-boot-run-maven-vs-executable-jar
RUN application in exploded form:
mvn spring-boot:run

**prod-env**

BUILD and RUN application,
mvn clean package spring-boot:repackage
java -jar target/demo-0.0.1-SNAPSHOT.jar

**Login to H2 database**

username: sa
password: 
http://localhost:8585/h2-console
