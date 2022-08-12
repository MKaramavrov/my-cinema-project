# Cinema project

### Project's description
A simple web application, which was written using Spring technologies, that supports authentication, authorization, and  CRUD operations(see project's features).<br />


### Project's features
 - Authentication, authorization and creating of new users;
 - Assigning specific roles(USER, ADMIN);
 - Adding new movies, and cinema halls;
 - Combining movies and cinema halls in movie sessions;
 - Adding movie sessions to a ticket;
 - Adding tickets to shopping carts which are bounded to a specific user;
 - Closing order by adding all needed information to it and emptying the shopping cart;

Role access to specific resources for ADMIN and for USER is configured using the following rules:
```
POST:   /register - all
GET:    /cinema-halls - user/admin
POST:   /cinema-halls - admin
GET:    /movies - user/admin
POST:   /movies - admin
GET:    /movie-sessions/available - user/admin
POST:   /movie-sessions - admin
PUT:    /movie-sessions/{id} - admin
DELETE: /movie-sessions/{id} - admin
GET:    /orders - user
POST:   /orders/complete - user
PUT:    /shopping-carts/movie-sessions - user
GET:    /shopping-carts/by-user - user
GET:    /users/by-email - admin

```

### Database structure: 
![pic](schema_dependencies.png)

### Following technologies were applied in this project:
* Java (11);
* Apache Tomcat;
* MySQL;
* Hibernate;
* Spring Core;
* Spring MVC;
* Spring Security.



### How to run this project on your PC:
1. You will need an installed environment to run Java code;
2. You will also need installed MySQL;
3. Clone this project
4. Set up DB's parameters in hibernate.cfg.xml
5. Run the main() method in the Main class to see how it works.
6. You can use already initialized data or use your own inputs and write feedback :)

