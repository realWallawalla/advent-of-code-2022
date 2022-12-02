# advent-of-code-2022

build project: ./gradlew build

docker build -t $dayXX .

to get solution for part 1 or 2, specify env variable:
$ docker run -e part=part1 "${dockerImage}"
