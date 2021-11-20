FROM maven:3.8.3-jdk-8-slim
WORKDIR /build
COPY . /build
RUN mvn clean package
EXPOSE 8080
ENTRYPOINT ["java","-jar","/build/target/pismo-1.0-SNAPSHOT.jar"]