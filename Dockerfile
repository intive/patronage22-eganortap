FROM openjdk:17.0.2-slim

WORKDIR /patronage22-eganortap

RUN groupadd appusers
RUN useradd -ms /bin/bash -G appusers appuser

USER appuser:appusers

ARG JAR_FILE=target/patronage22-eganortap-*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/patronage22-eganortap/app.jar"]