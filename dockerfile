FROM java:8
WORKDIR /app
ADD ./demo-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD java -jar demo-0.0.1-SNAPSHOT.jar

# java -jar /usr/local/runme/app.jar
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]