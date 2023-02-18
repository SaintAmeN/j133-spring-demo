package pl.sda.j133.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
public class J133SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(J133SpringDemoApplication.class, args);
    }

    // CRUD
    // CREATE   READ    UPDATE      DELETE
    // PUT/POST GET     POST/PATCH  DELETE   - Metody HTTP

    // Adres:
    //  - /student      - GET - pobierz studentów (wszystkich)
    //  - /student/3    - GET - pobierz studenta o id 3
    //  - /student?id=3 - GET - pobierz studenta o id 3
    //  - /student/3    - PATCH     - aktualizuj studenta o ID 3 (dane do aktualizacji są w ciele zapytania)
    //  - /student/3    - DELETE    - usuń studenta o ID 3
    //  - /student      - POST      - utwórz studenta (dane do stworzenia są w ciele zapytania)

    // Adres:
    //  - /car      - GET       - pobierz listę
    //  - /car/3    - GET       - pobierz samochód id 3
    //  - /car?id=3 - GET       - pobierz samochód id 3
    //  - /car/3    - PATCH     - aktualizacja ...
    //  - /car/3    - DELETE    - usun ...
    //  - /car      - POST      - utwórz ...
}
