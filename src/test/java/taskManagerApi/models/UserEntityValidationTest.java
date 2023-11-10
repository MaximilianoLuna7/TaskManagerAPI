package taskManagerApi.models;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

// This class contains tests to validate the constraints of UserEntity class.
class UserEntityValidationTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // Test for ensuring that 'username' is not blank.
    @Test
    void testUsernameNotBlank() {
        UserEntity user = UserEntity.builder()
                .username(null)
                .hashedPassword("hashedPassword123")
                .fullName("John Doe")
                .build();

        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        assertEquals(1, violations.size());
        assertEquals("username", violations.iterator().next().getPropertyPath().toString());
    }

    // Test for ensuring that 'username' has the correct size.
    @Test
    void testUsernameSize() {
        UserEntity user = UserEntity.builder()
                .username("a")
                .hashedPassword("hashedPassword123")
                .fullName("John Doe")
                .build();

        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        assertEquals(1, violations.size());
        assertEquals("username", violations.iterator().next().getPropertyPath().toString());
    }

    // Test for ensuring that 'username' is not blank and has the correct size.
    @Test
    void testUsernameNotBlankAndSize() {
        UserEntity user = UserEntity.builder()
                .username("")
                .hashedPassword("hashedPassword123")
                .fullName("John Doe")
                .build();

        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        assertEquals(2, violations.size());
        assertEquals("username", violations.iterator().next().getPropertyPath().toString());
    }

    // Test for ensuring that 'hashedPassword' is not blank.
    @Test
    void testHashedPasswordNotBlank() {
        UserEntity user = UserEntity.builder()
                .username("johndoe")
                .hashedPassword("")
                .fullName("John Doe")
                .build();

        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        assertEquals(1, violations.size());
        assertEquals("hashedPassword", violations.iterator().next().getPropertyPath().toString());
    }

    // Test for ensuring that 'fullName' is not blank.
    @Test
    void testFullNameNotBlank() {
        UserEntity user = UserEntity.builder()
                .username("johndoe")
                .hashedPassword("hashedPassword123")
                .fullName(null)
                .build();

        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        assertEquals(1, violations.size());
        assertEquals("fullName", violations.iterator().next().getPropertyPath().toString());
    }

    // Test for ensuring that 'fullName' has the correct size.
    @Test
    void testFullNameSize() {
        UserEntity user = UserEntity.builder()
                .username("johndoe")
                .hashedPassword("hashedPassword123")
                .fullName("a")
                .build();

        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        assertEquals(1, violations.size());
        assertEquals("fullName", violations.iterator().next().getPropertyPath().toString());
    }

    // Test for ensuring that 'fullName' is not blank and has the correct size.
    @Test
    void testFullNameNotBlankAndSize() {
        UserEntity user = UserEntity.builder()
                .username("johndoe")
                .hashedPassword("hashedPassword123")
                .fullName("")
                .build();

        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        assertEquals(2, violations.size());
        assertEquals("fullName", violations.iterator().next().getPropertyPath().toString());
    }
}
