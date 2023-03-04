package pl.sda.j133.demo.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateStudentResponse {
    private Long identifier;
    private String firstName;
    private String lastName;
    private Integer age;
}
