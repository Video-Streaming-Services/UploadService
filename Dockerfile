FROM openjdk:8
EXPOSE 8080
ADD target/UploadService.jar UploadService.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","UploadService.jar"]
