FROM openjdk:17
COPY target/JavaAssignment2-0.0.1-SNAPSHOT.jar JavaAssignment2.jar
ENTRYPOINT ["java","-jar","/JavaAssignment2.jar"]