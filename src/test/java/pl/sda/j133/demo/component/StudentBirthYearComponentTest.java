package pl.sda.j133.demo.component;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.sda.j133.demo.exception.IllegalValueException;
import pl.sda.j133.demo.model.Student;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentBirthYearComponentTest {
    private final StudentBirthYearComponent birthYearComponent = new StudentBirthYearComponent();

    @Test
    @DisplayName("Oblicza poprawnie rok urodzenia jeśli obiekt student posiada przypisaną wartość dla pola wiek")
    void testBirthYearCalculation() {
        // GIVEN
        final var student = new Student(null, null, null, 25);

        // THEN
        final var wynik = birthYearComponent.calculateBirthYear(student);

        // ASSERT
        assertEquals(LocalDate.now().getYear() - 25, wynik);
    }

    @Test
    @DisplayName("Rzuca InvalidArgumentException jeśli wiek studenta nie posiada wartości.")
    void testBirthYearCalculationThrowsExceptionOnNull() {
        // GIVEN
        final var student = new Student(null, null, null, null);

        // THEN ASSERT
        assertThrows(IllegalValueException.class, () -> {
            birthYearComponent.calculateBirthYear(student);
        });
    }
}