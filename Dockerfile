FROM openjdk:8
ADD target/spring-boot-test.jar spring-boot-test.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "spring-boot-test.jar"]
