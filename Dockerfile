FROM gradle:6.9-jdk8 AS build
COPY . /app
WORKDIR /app
RUN gradle build --no-daemon

FROM amazoncorretto:8-alpine-jre

EXPOSE 8080

ENV JAVA_OPTS=""
ENV APP_HOME /app

#Create base app folder
RUN mkdir $APP_HOME
#Create folder to save configuration files
RUN mkdir $APP_HOME/config
#Create folder with application logs
RUN mkdir $APP_HOME/log

VOLUME $APP_HOME/log
VOLUME $APP_HOME/config

WORKDIR $APP_HOME

COPY --from=build /app/build/libs/*.jar app.jar

CMD java $JAVA_OPTS -jar app.jar