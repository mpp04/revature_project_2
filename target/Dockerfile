# DOCKERFILE

# start with the tomcat parent image
FROM tomcat:8.5-jdk-openjdk
# creating a container from above image and shutdown

# switch to the base directory
WORKDIR $CATALINA_HOME

# create an env var that points to our war on the local machine
ARG WAR_FILE=./target/*.war
# DOCKERFILE in the ./target , along with java_web.iml

# copy the war file to the webapps directory of tomcat

COPY $WAR_FILE ./webapps

# expose port 8080
EXPOSE 8080

CMD ["catalina.sh", "run"]

#image definition complete