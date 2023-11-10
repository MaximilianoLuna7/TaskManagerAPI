package taskManagerApi.models;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

// This class contains tests to validate the constraints of TaskEntity class.
class TaskEntityValidationTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // test that checks if the @NotBlank annotation in the title works correctly.
    @Test
    void testTitleNotBlank() {
        TaskEntity task = TaskEntity.builder()
                .title("")
                .build();

        var violaions = validator.validate(task);
        assertFalse(violaions.isEmpty());
    }

    // Test that checks if the due date is in the correct format "yyyy-MM-dd".
    @Test
    void testDateFormatForDueDate() {
        TaskEntity task = TaskEntity.builder()
                .title("Test task")
                .dueDate(LocalDate.of(2023, 11, 30))
                .build();

        var violations = validator.validate(task);
        assertTrue(violations.isEmpty());
    }

    // Test that checks if the creation date is in the correct format "yyyy-MM-dd".
    @Test
    void testDateFormatForCreationDate() {
        TaskEntity task = TaskEntity.builder()
                .title("Test task")
                .creationDate(LocalDateTime.now())
                .build();

        var violations = validator.validate(task);
        assertTrue(violations.isEmpty());
    }

    // Test that checks if the update date is in the correct format "yyyy-MM-dd".
    @Test
    void testDateFormatForUpdateDate() {
        TaskEntity task = TaskEntity.builder()
                .title("Test task")
                .updateDate(LocalDateTime.now())
                .build();

        var violations = validator.validate(task);
        assertTrue(violations.isEmpty());
    }

    // Test that checks if the completion date is in the correct format "yyyy-MM-dd".
    @Test
    void testDateFormatForCompletionDate() {
        TaskEntity task = TaskEntity.builder()
                .title("Test task")
                .completionDate(LocalDate.now().atStartOfDay())
                .build();

        var violations = validator.validate(task);
        assertTrue(violations.isEmpty());
    }
}