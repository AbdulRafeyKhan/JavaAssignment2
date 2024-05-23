Steps to Run Application

# pull mysql image

- docker pull mysql

# create network to run mysql and spring container

- docker network create sprsql

#create mysql container

- docker run -d -p 3307:3306 --net sprsql  --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=assembly mysql:latest

#clean and package  to create jar file

- mvn clean package

#create spring app image

- docker build -t assemblydockerimage .

#create spring app containetr

- docker run -p 9090:8080 --name spring-c --net sprsql  -e MYSQL_HOST=mysqldb -e MYSQL_PORT=3306 -e MYSQL_DB_NAME=assembly
