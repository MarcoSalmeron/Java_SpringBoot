# Usa una imagen base con Java 21
FROM eclipse-temurin:21-jdk-alpine

# Crea un directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el JAR generado al contenedor
COPY target/dockerized.postgresql-0.0.1-SNAPSHOT.jar java-app.jar

# Expone el puerto típico de Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "java-app.jar"]