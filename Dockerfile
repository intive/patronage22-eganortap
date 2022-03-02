FROM openjdk:17-alpine
WORKDIR /patronage22-eganortap
COPY target/*.jar app.jar
RUN addgroup appusers && adduser -S appuser -G appusers
USER appuser:appusers
EXPOSE 8080/tcp
ENTRYPOINT ["java","-jar","/patronage22-eganortap/app.jar"]