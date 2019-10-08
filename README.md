### **Intuit Demo**  
- High-Level Requirements :
    - Employees can follow their colleagues, post messages to their followers
    - Use corporate LDAP for user Management
    - On an average, every employee will send approximately 10 messages a day to their followers
    - On the home page we need to show 100 most recent tweets. Optionally you can support pagination.
    - You are welcome to assume unspecified requirements to make it better for the customers
    - You are expected to explain the rationale for your choice of technologies and architectural patterns
   
- Execution Details
    - All users are authorized using SpringSecurity LDAP. Once a user is authorized, it is logged in until other user logs in.
    - Credentials that can be used for testing
        - username: urvashi  password: urvashi
        - username: don password: don
        - username: admin password: admin (For admin role)

- All the endpoints implemented are listed below.
    - /login - authorize a user
    - /follow - follow a user
    - /tweet - post a tweet
    - /feed - get feed for a user
    - /unfollow - unfollow a user
    - /followees - list all the followees
    - /tweets - list all tweets posted by a user
    - /admin - only admin user has access to this endpoint
    - /anonymous - No authorization required for this endpoint
 
- Github Code Details
    - master branch - Main implementation using Spring boot, MongoDB, Exception Handling, Request body validation, Spring LDAP Authentication
    - in-Memory branch - Initial implementation with an in-memory database. I started with this to understand the basics and then implemented with MongoDB which is checked in the master branch.
