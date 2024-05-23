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


![Screenshot (6)](https://github.com/AbdulRafeyKhan/JavaAssignment2/assets/36784542/d4bc3699-e958-4ff4-ad7f-faf239c1ddd8)


![Screenshot (7)](https://github.com/AbdulRafeyKhan/JavaAssignment2/assets/36784542/538c15e6-de99-45f0-aeff-e0ba96418b88)



![Screenshot (5)](https://github.com/AbdulRafeyKhan/JavaAssignment2/assets/36784542/efa78a1f-c59c-4381-a962-08c4ae292ec1)

