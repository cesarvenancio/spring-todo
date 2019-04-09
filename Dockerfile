FROM java:8
EXPOSE 9090
ADD /target/spring-task-1.0.0-RELEASE.jar springtask.jar
ENTRYPOINT ["java","-jar","springtask.jar"]