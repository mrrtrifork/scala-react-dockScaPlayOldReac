# 1 - BUILD THE FRONTEND
FROM node:8.17.0-alpine as frontendcompiler

COPY both/example-f4dms /both/example-f4dms

WORKDIR /both/example-f4dms

# Install project dependencies
RUN npm i
# build frontend
RUN npm run build

# 2 - DEPLOY THE BACKEND
FROM hseeberger/scala-sbt:8u181_2.12.8_1.2.8 as webrunner

COPY both/simplescalaplay /both/simplescalaplay

# Copy frontend built files into assets static serving folder
COPY --from=frontendcompiler /both/example-f4dms/build/ /both/simplescalaplay/public/

WORKDIR /both/simplescalaplay

# update sbt libs
RUN sbt update

# compile scala web app
RUN sbt compile

EXPOSE 9000

# compile app and run server
CMD sbt run

#docker build -t imagetest2 .
#docker run -d -p 8080:9000 --name containerscalreac imagetest2