# Also, there is a clean separation between dependencies and application
# resources in a Spring Boot fat JAR file, and we can use that fact to improve
# performance. The key is to create layers in the container filesystem.
# The layers are cached both at build time and at runtime (in most runtimes),
# so we want the most frequently changing resources (usually the class
# and static resources in the application itself) to be layered after the more
# slowly changing resources. Thus, we use a slightly different implementation
# of the Dockerfile:


FROM openjdk:17-jdk-slim-bullseye
RUN adduser --system --group --disabled-password spring
USER spring
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
#ENTRYPOINT ["java","-cp","app:app/lib/*","hello.Application"]
