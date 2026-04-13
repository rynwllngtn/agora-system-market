FROM eclipse-temurin:25-jre

COPY target/agoramarket-0.0.1.jar agoramarket-0.0.1.jar

ENTRYPOINT ["java", "-jar", "agoramarket-0.0.1.jar"]