## Spring Demo Application

### Wstęp / Introduction
To jest moja pierwsza aplikacja Springowa. Tutaj uczę się Springa.

### Funkcjonalność / Features
Aplikacja zawiera technologie: 
 - JPA, 
 - Spring Boot, 
 - MySQL, 
 - REST API

Aplikacja umożliwia:
 - Dodawanie encji student
 - Usuwanie encji student (po identyfikatorze)
 - Edycje encji student (możliwa jest zmiana pola 'imie')
 - Listowanie encji student
 - Szukanie encji student po identyfikatorze:
   - PathVariable -> /student/3
   - RequestParam -> /student/byId?studentId=3

### Jak skonfigurować i uruchomić / How to configure and run
Aby skonfigurować aplikację, należy dostarczyć parametry do połączenia z bazą danych. 
Parametry znajdują się w `/src/main/resources/application.yaml`. Należy wypełnić:

```yaml
spring:
  datasource:
    url: jdbc:mysql:// # wypełnij adres połączenia / fill connection string url
    password: # wypełnij hasło / fill password
    username: # wypełnij login / fill username
  jpa:
    hibernate:
      ddl-auto: update
```

Do uruchomienia aplikacji należy użyć komendy:
```shell
mvn spring-boot:run
```

### Autorzy / Authors
Pawełek
