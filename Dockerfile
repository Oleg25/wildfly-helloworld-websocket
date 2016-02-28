FROM jboss/wildfly:10.0.0.Final
MAINTAINER Oleg Velmisov <velmisoff123@gmail.com>


ENV APP_DOWNLOAD_URL https://github.com/Oleg25/wildfly-helloworld-websocket

RUN curl -L -o ${JBOSS_HOME}/standalone/deployments/ROOT.war ${APP_DOWNLOAD_URL}

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
