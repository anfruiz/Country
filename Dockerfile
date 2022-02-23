FROM adoptopenjdk/openjdk11-openj9:alpine-slim
VOLUME /tmp
COPY applications/app-service/build/libs/app-service.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
