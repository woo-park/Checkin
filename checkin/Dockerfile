FROM frolvlad/alpine-java:jdk8-slim
VOLUME /tmp
ADD  target/checkin-1.0.jar checkin.jar
EXPOSE 8070
ENTRYPOINT ["java","-jar","/checkin.jar"]
