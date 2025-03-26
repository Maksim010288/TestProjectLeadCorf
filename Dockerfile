FROM openjdk:21

ADD /target/KeyCloackTestProject-0.0.1-SNAPSHOT.jar start.jar

ENTRYPOINT ["java","-jar","start.jar"]