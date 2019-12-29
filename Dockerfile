FROM openjdk:11-jdk-slim
EXPOSE 8585
WORKDIR /home/demo
COPY /target/demo-0.0.1-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java","-jar","demo.jar"]