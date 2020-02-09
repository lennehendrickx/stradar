FROM oracle/graalvm-ce:19.3.1-java11 as graalvm
COPY . /home/app/stradar
WORKDIR /home/app/stradar
RUN gu install native-image
RUN native-image --no-server -cp stradar/build/libs/stradar-*-all.jar

FROM frolvlad/alpine-glibc
EXPOSE 8080
COPY --from=graalvm /home/app/stradar .
ENTRYPOINT ["./stradar"]
