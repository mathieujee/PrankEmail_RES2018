# PrankEmail_RES2018

As part of a homework of the course RES2018 (Heig-vd Réseaux), the objective of this project is to show how easy it is to send forged emails. A forged email is a fake email where all its information can be modified. For example, I could sent you an email and make it like it was Kim Jong Un sending you his nuclear codes.

This tool will allow you to send forged emails among a group of victims. The program will randomly choose one to be the sender, and the others member of the group will received a fake email from the sender.

In order to avoid sending tons of emails trough public SMTP servers, we will use a mock SMTP server. Mock servers are typically used during the development of an application sending emails. You can see this server as a sandbox. You can do whatever it pleased you with it without bothering anyone. 



### Setup a mock SMTP server (with Docker)

####Docker Installation

First of all you need to install Docker on your device. 

On Linux:

`sudo apt install docker.io`

On Windows:

https://docs.docker.com/docker-for-windows/install/

On Mac:

https://docs.docker.com/docker-for-mac/install/

Docker is a platform to develop, deploy and run applications with virtual containers. A container allows you to isolate an application and execute it from any devices. 



####Mock Server Installation

Afterwards, you need to install the mock SMTP server. We will be using "MockMock".

Setup instructions: 

https://github.com/tweakers-dev/MockMock



####Setup Docker Image

Now that these two tools are installed, we need to setup the Docker Image.

Create a directory. In this directory create a file a name it `dockerfile`. You also have to create a `src` directory and move the jar file of MockMock (`MockMock.jar`) in it.

Edit the `dockerfile` as followed: 

```dockerfile
FROM java:8

ADD src /opt/src/

WORKDIR /opt/src/

ENTRYPOINT ["java", "-jar", "MockMock.jar", "-p", "2525", "-h", "8080]

```



#### Build Docker Image

`docker build -t name-of-the-image path/to/docker/directory`

Don't use capital letters in the name of the image. If you are already working in the docker directory, you can type `.` instead of the path.



#### Run Docker Image

`docker run -p 2525:2525 -p 8080:8080 name-of-the-image`



#### MockMock mailbox

You have now access to your mock mailbox. Just use this short url with the ip of the Docker Container:

`http://ip-of-docker-container:8080`


### Configuration

The configuration files are in the ressources directory

`config.properties ` contains some configurations for the server and the project :

* Server address
* Server Port
* Number of groups
* People to CC

`victims.utf8` contains a list of email address for the prank.

`prankmails.utf8` contains some messages that will be send for the prank. To separat them, there are these symbol : `====`. 
 
 
### Implementation

There are three main parts for the project :

* `Configuration manager Part :` This part contains the code for reading configuration files and tranform data in java object for the prank. 

* `Prank part :` contains four classes, three of them are for the prank and the other one represent a person. The main class is PrankGenerator. It build a prank with objects from the configuration manager part.

* `SMTP part :` contains the data for the SMTP protocol and the client. The client starts a connexion with the server and send all data for each prank.


