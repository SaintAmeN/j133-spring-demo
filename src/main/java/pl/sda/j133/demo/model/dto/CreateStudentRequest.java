package pl.sda.j133.demo.model.dto;

import lombok.*;

// DTO - Data Transfer Object - obiekt którego używamy do komunikacji [ klient <-> aplikacja ]
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentRequest {
    private String firstName;   // mapowane na imie
    private String lastName;    // mapowane na nazwisko
    private Integer age;        // mapowane na wiek
}
