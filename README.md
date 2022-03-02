# JPAY Phone Number Exercise

This is a sample project of a simple webpage that serves data about users phone number's information.
The backend of the project was made using Java and SpringBoot, using SQLite as database.
The frontend of the project consists on a simple page created using html, css and javascript.


### Start the project
To be able to start the project, Apache Maven should be installed, and a Docker daemon should be running.


Open a terminal and navigate to the project main folder and then execute one of the following approaches:

#### First approach (compile.sh file provided)
* Run the compile.sh file. It is possible to choose the port if passed as argument, otherwise it will use 8080 as default

```bash
bash compile.sh
```
or
```bash
bash compile.sh 8180
```
This approach will build and run automatically.

#### Second approach (Install, build and run)

1 - From the root directory, install all the dependencies:
```bash
mvn clean install
```

2 - Install using the Dockerfile
```bash
docker build -t jpay .
```

3 - Run
```bash
docker run -p 8080:8080 jpay
```
