FROM openjdk:11-jdk-slim as build
COPY . /home/app/stradar
WORKDIR /home/app/stradar
RUN ./gradlew --no-daemon assemble

FROM openjdk:11-jre-slim
EXPOSE 8080
RUN useradd -m myuser
USER myuser
COPY --from=build home/app/stradar/stradar-server/build/libs/stradar-server*-all.jar stradar.jar
CMD java -noverify ${JAVA_OPTS} -jar stradar.jar
