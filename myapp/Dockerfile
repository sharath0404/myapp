FROM openjdk:17

WORKDIR /app

COPY target/myapp.jar myapp.jar

ENV DB_HOST=your-ec2-public-ip
ENV DB_USER=myuser
ENV DB_PASS=mypassword

CMD ["java", "-jar", "myapp.jar"]
