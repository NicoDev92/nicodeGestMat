FROM amazoncorreto:11-alpine-jdk
MAINTAINER Nicode
COPY target/gestion-matriculados-0.0.1-SNAPSHOT.jar  gm-nicode.jar
ENTRYPOINT ["java", "-jar", "/gm-nicode.jar"]