FROM ccr.ccs.tencentyun.com/lib-std/java:3.0
ADD ./  /root/wmp-api
WORKDIR /root/wmp-api
RUN /apache-maven-3.5.4/bin/mvn package
CMD ["java","-jar","target/wmp-api.jar","--spring.config.location=/etc/application.properties"]

