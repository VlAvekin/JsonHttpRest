# JSON HTTP REST DB

Control systems versions: Maven;

Framework: SpringBoot;

Database: PostgreSQL, JPA, Hibernate, flyway;

Http client: OkHttp;

WEB: Freemarker, HTML, Bootstrap;

Test: Mockito, JUnit.

API
```
GET /
   Response:
         list data source db
```
```
GET /?data=url

   Request:
      param data=url
      
   Response:
      list data source db
```

```
Post /

  Body: 
      data=url

   Response:
      list data source db
      
```