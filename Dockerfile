FROM moxm/java:1.8-full

RUN mkdir -p /java

WORKDIR /java

COPY target/*.jar app.jar

EXPOSE 8080

ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom"

CMD sleep 5; java -jar app.jar $JAVA_OPTS
