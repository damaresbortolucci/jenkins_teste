FROM openjdk:11

WORKDIR /banana

COPY target/clinica_odonto-0.0.1-SNAPSHOT.jar /banana/clinica_odonto.jar

ENTRYPOINT ["java", "-jar", "clinica_odonto.jar"]