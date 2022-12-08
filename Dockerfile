FROM adoptopenjdk/openjdk11
VOLUME /tmp
ARG JAR_FILE=build/libs/hc-product-service.jar
ADD ${JAR_FILE} hc-product-service.jar
EXPOSE 5003
ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","hc-product-service.jar"]
