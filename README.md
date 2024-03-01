# jis-development-server
Spring boot server for mail sender (API Rest)

## application.properties
**I git ignore this file, to dont make public some data, i will paste here how it must be written for this mail sender API work**
```
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=<your-gmail-user>
spring.mail.password=<your-application-password>
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.ssl.trust=smtp.gmail.com
spring.main.allow-circular-references=true
```
