FROM gradle:alpine as BASE
WORKDIR /app
COPY ./ .
RUN gradle build

FROM openjdk:17-alpine
COPY --from=BASE /app/build/libs/day06-1.0-SNAPSHOT.jar /day06.jar
COPY input.txt .
CMD java -jar /day06.jar