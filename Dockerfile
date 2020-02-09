FROM openjdk:11-jdk-slim as build
COPY . /home/app/stradar
WORKDIR /home/app/stradar
RUN ./gradlew --no-daemon assemble

FROM openjdk:11-jre-slim
EXPOSE 8080
COPY --from=build home/app/stradar/stradar/build/libs/stradar-*-all.jar stradar.jar
CMD java -noverify ${JAVA_OPTS} -jar stradar.jar
