## Stage 1: Construcción con la imagen del constructor Maven Quarkus nativo
FROM quay.io/quarkus/ubi-quarkus-graalvmce-builder-image:22.3-java17 AS build

# Copiar archivos necesarios para la construcción
COPY --chown=quarkus:quarkus mvnw /code/mvnw
COPY --chown=quarkus:quarkus .mvn /code/.mvn
COPY --chown=quarkus:quarkus pom.xml /code/

# Cambiar de usuario y establecer el directorio de trabajo
USER quarkus
WORKDIR /code

# Descargar dependencias Maven
RUN ./mvnw -B org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline

# Copiar código fuente y empaquetar la aplicación
COPY src /code/src
RUN ./mvnw package

## Stage 2: Crear la imagen final de Docker
FROM registry.access.redhat.com/ubi8/openjdk-17:1.14

# Establecer directorio de trabajo
WORKDIR /work/

# Copiar resultados de la construcción desde la etapa de construcción
COPY --from=build --chown=185 /code/target/quarkus-app/lib/ /deployments/lib/
COPY --from=build --chown=185 /code/target/quarkus-app/*.jar /deployments/
COPY --from=build --chown=185 /code/target/quarkus-app/app/ /deployments/app/
COPY --from=build --chown=185 /code/target/quarkus-app/quarkus/ /deployments/quarkus/

# Exponer el puerto 8080
EXPOSE 8080

# Cambiar de usuario
USER 185

# Configurar variables de entorno
ENV JAVA_OPTS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"

# Punto de entrada
ENTRYPOINT [ "/opt/jboss/container/java/run/run-java.sh" ]
