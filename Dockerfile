FROM openjdk:14-alpine
COPY build/libs/micronaut-first-letter-issue-*-all.jar micronaut-first-letter-issue.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "micronaut-first-letter-issue.jar"]
