FROM openjdk:17

WORKDIR /app

COPY target/myapp.jar myapp.jar

ENV DB_HOST=13.233.91.52
ENV DB_USER=sharath
ENV DB_PASS=sharath

CMD ["java", "-jar", "myapp.jar"]
