# Chat app

<h2>📣 Project description 📣</h2>
Real time chat application that uses Spring Boot 3 for backend and Angular 14 as a client. This application is built up using Streaming Text Oriented Messaging Protocol which is based on WebSocket with usage of memory message broker. Application support authentication based on JWT tokens. For this purpose Spring Security OAuth2 is used. Chat's messages are stored in PostgreSQL database. Client uses StompJs library for sending and receiving messages. The project works well, but there are a lot of things that can be improved and many features that can be added.

<h2>Features</h2>

* Real time chat app

* User authentication based on JWT tokens

* 3-layer architecture for backend: Controllers, Services and Repositories

* Stateless application

## <h2>Technologies</h2>
### Backend
* Java 17
* Spring Boot 3
* Spring Security
* Spring Data JPA
* Spring Web
* PostgreSQL
* Hibernate
* Liquibase
### Frontend
* TypeScript
* Angular 14
* StompJS
* HTML/CSS
### Common
* Docker

## <h2>:bomb:Instructions for launching the project:bomb:</h2>
<h4>To run this project locally, follow these steps:</h4>

1️⃣ You should install <a href="https://docs.docker.com/get-docker/">Docker</a> for easy launching

2️⃣  Clone this project from GitHub
```bash
https://github.com/PavloPolovyi/chat-application
```
3️⃣ Navigate to project folder in terminal and run following command:
```bash
docker compose build
```
4️⃣ Then run:
```bash
docker compose up
```
:five: Go to the browser and use the following url to test the application: 
```bash
http://localhost:9090
```
:six: If port 9090 is busy on your machine, just change NGINX_LOCAL_PORT value and update CORS_ORIGIN after this in the .env file.


