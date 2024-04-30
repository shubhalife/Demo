FROM openjdk:8-jdk-alpine
COPY ./target/demo-service.jar demo-service.jar
ENV JAVA_OPTS="-Xmx512mg -Xms256m"
ENTRYPOINT ["java","-jar","demo-service.jar"]