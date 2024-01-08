FROM openjdk:17-jdk-slim
ADD ./build/libs/store-backend-0.0.1-SNAPSHOT.jar /store-backend-0.0.1-SNAPSHOT.jar
ADD ./run.sh /run.sh
RUN apt-get update && apt-get install -y netcat
RUN chmod a+x /run.sh
EXPOSE 8080:8080
CMD /run.sh