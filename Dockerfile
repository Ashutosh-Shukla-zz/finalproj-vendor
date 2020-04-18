FROM openjdk:8-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/demo-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT java -jar \
    -Djava.security.egd=file:/dev/./urandom \
    -Dspring.datasource.url=${MYSQL_HOST} \
    -Dspring.datasource.username=${MYSQL_USER} \
    -Dspring.datasource.password=${MYSQL_PASSWORD} \
    /app.jar