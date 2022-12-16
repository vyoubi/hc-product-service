FROM adoptopenjdk/openjdk11
ARG JAR_FILE=target/hc-product-service.jar
ADD ${JAR_FILE} hc-product-service.jar
EXPOSE 5003
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","hc-product-service.jar"]
