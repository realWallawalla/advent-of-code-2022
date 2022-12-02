FROM gradle:alpine as BASE
WORKDIR /app
COPY ./ .
RUN gradle build

FROM openjdk:17-alpine
COPY --from=BASE /app/build/libs/day02-1.0-SNAPSHOT.jar /day02.jar
COPY input.txt .
CMD java -jar /day02.jar