FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN

COPY pom.xml /botapi/
COPY main /botapi/main/
COPY destiny2 /botapi/destiny2/
COPY util /botapi/util/
COPY demo /botapi/demo/
COPY test /botapi/test/

WORKDIR /botapi/
RUN mvn clean package

FROM openjdk:8-jdk-alpine
COPY --from=MAVEN_TOOL_CHAIN /botapi/main/target/botapi.jar app.jar

RUN sh -c 'touch /app.jar'

ENTRYPOINT ["java","-jar","/app.jar"]