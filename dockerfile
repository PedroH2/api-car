FROM adoptopenjdk/openjdk11:alpine

# java -jar /usr/local/runme/app.jar
ENTRYPOINT ["java","-jar","app.jar"]