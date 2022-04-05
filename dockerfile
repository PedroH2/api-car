FROM java:8
WORKDIR /app
ADD ./paygen.jar /app
EXPOSE 2000
CMD java -jar api-car.jar

# java -jar /usr/local/runme/app.jar
ENTRYPOINT ["java","-jar","app.jar"]