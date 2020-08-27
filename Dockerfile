FROM centos

MAINTAINER aksarav@middlewareinventory.com

RUN mkdir /opt/tomcat/

WORKDIR /opt/tomcat
RUN curl -O https://mirror.olnevhost.net/pub/apache/tomcat/tomcat-8/v8.5.57/bin/apache-tomcat-8.5.57.tar.gz
RUN tar xvfz apache*.tar.gz
RUN mv apache-tomcat-8.5.57/* /opt/tomcat/.
RUN yum -y install java-1.8.0-openjdk
RUN java -version

ARG WAR_FILE=./Project_1.war
COPY $WAR_FILE /opt/tomcat/webapps

ARG DIST_DIR=./dist
COPY $DIST_DIR /opt/tomcat/webapps/angular/dist

WORKDIR /opt/tomcat/webapps
# RUN curl -O -L https://github.com/AKSarav/SampleWebApp/raw/master/dist/SampleWebApp.war

EXPOSE 6400

CMD ["/opt/tomcat/bin/catalina.sh", "run"]

# java-1.8.0-openjdk
