FROM openjdk:21-jdk-slim
WORKDIR /app
COPY build/libs/*.jar app.jar
ENV SPRING_DATA_MONGODB_URI=mongodb://mongo:27017/taskDB
CMD ["java", "-jar", "app.jar"]
EXPOSE 8080
