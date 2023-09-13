FROM amazoncorretto:17-alpine
ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:9090
COPY build/libs/*.jar book-client.jar
ENTRYPOINT ["java","-jar","/book-client.jar"]