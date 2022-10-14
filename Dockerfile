FROM openjdk:8
EXPOSE 8080
ADD target/UploadService.jar UploadService.jar
ENTRYPOINT ["java","-jar","UploadService.jar"]
