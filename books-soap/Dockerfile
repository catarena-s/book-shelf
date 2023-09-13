FROM amazoncorretto:17-alpine
COPY build/libs/*.jar book-soap.jar
ENTRYPOINT ["java","-jar","/book-soap.jar"]