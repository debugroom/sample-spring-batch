# Dockerfile for cron batch

FROM       docker.io/debugroom/wedding:centos7
MAINTAINER debugroom

RUN yum install -y \
       java-1.8.0-openjdk \
       java-1.8.0-openjdk-devel \
       wget tar iproute

RUN wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
RUN sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
RUN yum install -y apache-maven
ENV JAVA_HOME /etc/alternatives/jre

RUN git clone https://github.com/debugroom/sample-spring-batch.git /usr/local/sample-spring-batch

RUN mvn install -f /usr/local/sample-spring-batch/pom.xml

RUN yum install -y cronie-noanacron
RUN mkdir -p /usr/local/app/sample-spring-batch
RUN mkdir -p /logs
ADD scripts/sample.sh /usr/local/app/sample-spring-batch/
RUN chmod 755 /usr/local/app/sample-spring-batch/sample.sh
RUN echo "*/1 * * * * /usr/local/app/sample-spring-batch/sample.sh" > /var/spool/cron/root

RUN echo "PATH="$PATH >> ~/.bashrc

RUN cp /etc/localtime /etc/localtime.org
RUN ln -sf  /usr/share/zoneinfo/Asia/Tokyo /etc/localtime

CMD crond -n
