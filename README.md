

https://www.baeldung.com/spring-boot-run-maven-vs-executable-jar
RUN application in exploded form:
mvn spring-boot:run

prod-env:
BUILD and RUN application,
mvn clean package spring-boot:repackage
java -jar target/spring-boot-ops.war
