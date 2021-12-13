<br/>
<p align="center">
    <a href="https://sulu.io/" target="_blank">

</a>
    <img width="1445" alt="Asset 7@2x" src="https://user-images.githubusercontent.com/79365505/145860319-d70204a9-1c44-43d5-b1a5-6339bb40909c.png">

</p>

<br/>

<h2 align="center">Welcome where the change begings.</h2>


<div align="center">
  <h3>
    <a href="https://media.istockphoto.com/photos/hole-in-white-paper-with-torns-edges-coming-soon-picture-id1279117626?b=1&k=20&m=1279117626&s=170667a&w=0&h=GE8hgZzX1SzETg6B1QnlDgVEJv9BSDHGG8Xyz1wNl30=">
      Website
    </a>
    <span> | </span>
    <a href="https://media.istockphoto.com/photos/work-in-progress-road-sign-picture-id155388466?k=20&m=155388466&s=612x612&w=0&h=6bdW6twAzWK1U6QV5-9PrF7WvMBOkUcG8LeUaiAinlE=">
      Create Account
    </a>
    <span> | </span>
    <a href="https://api.whatsapp.com/send?phone=625933118">
      Chat
    </a>
    <span> | </span>
    <a href="https://github.com/IMartinMenendez/bankingSystem/issues">
      Report an Issue
    </a>
  </h3>
</div>


<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block"> 📋 Table of Contents</h2></summary>
  <ol>
    <li>Installation and Documentation
    </li>
    <li>Microservices
    </li>
    <li>Extras
    </li>
    <li>Technology used</li>
    <li>Functionalities</li>
    <li>Author</li>
    <li> Have a question?</li>
    <li> Found a bug?</li>
    <li> Requirements</li>
    <li> License/li>
  </ol>
</details>

We want to live in a better place. We want to help others. That is why ecommit born. Because We truly believe we are in this world to help us each others.

<div align="center">
    <img width="400" alt="Asset 7@2x" src="https://user-images.githubusercontent.com/79365505/145860372-657df332-8a68-416e-8ce3-547d40d9e639.jpeg">
</div>

- How it works:
  - [x] Create an Account.
  - [x] Looking for events you wanted to attend.
  - [x] Don't find what are your looking for? Create your own and give the chance to other users to attend to it.
  - [x] Change the world.
  
---

##  🚀&nbsp; Installation and Documentation 

Please note, this project has 4 Microservices and an Edge connecting all of them. You will need tot have all up and running with Eureka to make this project work.
You will need to clone the project or download it as a zip from the [Final Project Repository](https://github.com/IMartinMenendez/FinalProject.git). Also, you will need to clone the front end repository to visualize the web. Do it on [Final Project Front End Repository](https://github.com/IMartinMenendez/FinalProjectFront.git) 
After that, you will need to replicate the database.
You can find the database structure Table.SQL file named [SQL Structure](https://github.com/IMartinMenendez/FinalProject/blob/master/sql.sql). Just copy and create them.
Also, you will need to set up the project and link it with the database. Please add the details on application.properties under the folder resources.
This set up will be very similar to this:

```
spring.flyway.enabled=false

spring.datasource.url=jdbc:mysql://yourdatabaseurl
spring.datasource.username=yourUserName
spring.datasource.password=yourPassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=validate

spring.jpa.show-sql=true

server.error.include-message=always
server.error.include-binding-errors=always

spring.jackson.serialization.write-dates-as-timestamps=false
```

You will need to do it also to test the application.

---

## ✏️&nbsp; Microservices

### Events

All related with Events, where they are saved and displayed
### Course

Similar Microservice to the Events. We will keep and display all courses with this Microservice.

### Users

Taking care of all security, login and logout methods and checking token to make sure the user is right to change, delete or create an event.

### Notifications

This Microservice use Kafka to display notifications to all users attending to an event, if this event is modified or deleted.
We want to make sure you don't miss anything.

### Edge

It will call all other events and will be the only contact from the front end.

![Dibujo sin título (1)](https://user-images.githubusercontent.com/79365505/145862868-b12fd9e1-e9b2-474c-99cf-32dce93a1cf4.png)


<br>

## 💻&nbsp; Technology used


![Java Badge](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Angular](https://img.shields.io/badge/angular-%23DD0031.svg?style=for-the-badge&logo=angular&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![MySQL](	https://img.shields.io/badge/Apache_Kafka-231F20?style=for-the-badge&logo=apache-kafka&logoColor=white)




---

## ⚙️ Extras

- Spring Security:
    - [x] To avoid display
    - [x] Have a default interest rate of 0.0025.
    - [x] Have a minimum balance of less than 1000 but no lower than 100.
  
- Apache Kafka:
  - [x] To deal with notifications for the events.

- Checking Accounts:
    - [x] Minimum Balance of 250 and a monthlyMaintenanceFee of 12.

---


## 💁‍♀️️‍ Author

<a href="https://imartinmenendez.github.io/portfolio/">
 <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/79365505?v=4" width="100px;" alt=""/>
 <br />
 <sub><b>Irene Martín</b></sub></a> <a href="https://imartinmenendez.github.io/portfolio/">🚀</a>
 <br />

[![Instagram Badge](https://img.shields.io/badge/-IMartinMenendez-E4405F?Instagram-E4405F?style=flat-square&labelColor=E4405F&logo=instagram&logoColor=white&link=https://www.instagram.com/irene_mmenendez/)](https://www.instagram.com/irene_mmenendez/) [![Linkedin Badge](https://img.shields.io/badge/-Irene_Martín-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/irene1martin2menendez/)](https://www.linkedin.com/in/irene1martin2menendez/)
[![Gmail Badge](https://img.shields.io/badge/-irene1martin2menendez@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:irene1martin2menendez@gmail.com)](mailto:irene1martin2menendez@gmail.com?subject=[GitHub])

I love to create and be in constant growth. I am a very curious person, always trying to improve my skills, get out of my comfort zone and challenge myself without losing the positive mindset and can-do attitude.


---

## 📫&nbsp; Have a question? Want to chat? Ran into a problem?

We are happy to hearing about your questions and concerns. Please don't hesitate to contact me for any issue you can experiment.

---

## 🤝&nbsp; Found a bug? Missing a specific feature?

Feel free to **file a new issue** with a respective title and description on the [Final Project Issues](https://github.com/IMartinMenendez/FinalProject/issues). I really will appreciate your feedback to improve the system.

---

## ✅&nbsp; Requirements

You should have Postman and IDE. Just clone the repository from [Final Project Issues](https://github.com/IMartinMenendez/FinalProject) and try it!

---

## ©️&nbsp; License

Made with ❤️&nbsp;️ in London. Copyright © 2021 Irene Martin and follow the [MIT License](LICENSE).
