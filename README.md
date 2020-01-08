
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

**Docker**

https://medium.com/better-programming/build-push-to-docker-with-maven-eea7c4b8cfa2

Ways to containerize the application(s):
1.  Spotify plugin, spotify/dockerfile-maven-plugin
    Define a private.registry.url property --> datagraphics
    
    add password to docker configuration:
    ~/.docker/config.json
    "auths": {
        "https://index.docker.io/v1/": {
          "auth": "FOO",
          "email": "me@me.com"
        }
    }
    FOO should be replaced with the username:password for the docker registry.
    echo -n 'username:password' | base64
    
    mvn dockerfile:build
    docker run --rm datagraphics/demo:0.0.1-SNAPSHOT
    mvn dockerfile:push
    or push with authentication via maven ($MAVEN_HOME/settings.xml)
    
    

2.  Fabric8 plugin 

3.  Google Cloud Platform (Jib)

In order to allow 