FROM openjdk

RUN mkdir /app

COPY /target/API_Endereco-0.0.1-SNAPSHOT.jar /app/api-endereco-0.0.1.jar

ENTRYPOINT ["java", "-jar", "/app/api-endereco-0.0.1.jar"]