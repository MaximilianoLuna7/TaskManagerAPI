package taskManagerApi.models;

import jakarta.validation.ConstraintViolationException;
import org.h2.engine.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TaskEntityTest {

    // Test that checks if the set and get methods for the title work correctly.
    @Test
    void testSetAndGetTitle() {
        TaskEntity task = new TaskEntity();
        task.setTitle("Test task");
        assertEquals("Test task", task.getTitle());
    }

    // Test that checks if the set and get methods for the description work correctly.
    @Test
    void testSetAndGetDescription() {
        TaskEntity task = new TaskEntity();
        task.setDescription("This is a test task");
        assertEquals("This is a test task", task.getDescription());
    }

    // Test that checks if the set and get methods for the due date work correctly.
    @Test
    void testSetAndGetDueDate() {
        TaskEntity task = new TaskEntity();
        LocalDate dueDate = LocalDate.of(2023, 11, 30);
        task.setDueDate(dueDate);
        assertEquals(dueDate, task.getDueDate());
    }

    // Test that checks if the set and get methods for the status work correctly.
    @Test
    void testSetAndGetStatus() {
        TaskEntity task = new TaskEntity();
        StatusEnum status = StatusEnum.IN_PROGRESS;
        task.setStatus(status);
        assertEquals(status, task.getStatus());
    }

    // Test that checks if the set and get methods for the creation date work correctly.
    @Test
    void testSetAndGetCreationDate() {
        TaskEntity task = new TaskEntity();
        LocalDateTime creationDate = LocalDateTime.now();
        task.setCreationDate(creationDate);
        assertEquals(creationDate, task.getCreationDate());
    }

    // Test that checks if the set and get methods for the update date work correctly.
    @Test
    void testSetAndGetUpdateDate() {
        TaskEntity task = new TaskEntity();
        LocalDateTime updateDate = LocalDateTime.now();
        task.setUpdateDate(updateDate);
        assertEquals(updateDate, task.getUpdateDate());
    }

    // Test that checks if the set and get methods for the completion date work correctly.
    @Test
    void testSetAndGetCompletionDate() {
        TaskEntity task = new TaskEntity();
        LocalDateTime completionDate = LocalDateTime.now();
        task.setCompletionDate(completionDate);
        assertEquals(completionDate, task.getCompletionDate());
    }

    // Test that checks if the set and get methods for the user work correctly.
    @Test
    void testSetAndGetUser() {
        TaskEntity task = new TaskEntity();
        UserEntity user = UserEntity.builder()
                .id(1L)
                .username("johndoe")
                .hashedPassword("hashedPassword123")
                .fullName("John Doe")
                .build();

        task.setUser(user);
        assertEquals(user, task.getUser());
    }

    // Test that checks if the builder method creates an instance of TaskEntity with the correct values.
    @Test
    void testBuilder() {
        UserEntity user = UserEntity.builder()
                .id(1L)
                .username("johndoe")
                .hashedPassword("hashedPassword123")
                .fullName("John Doe")
                .build();

        TaskEntity task = TaskEntity.builder()
                .id(1L)
                .title("Test task")
                .description("This is a test task")
                .dueDate(LocalDate.of(2023, 11, 30))
                .status(StatusEnum.IN_PROGRESS)
                .creationDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .completionDate(LocalDateTime.now())
                .user(user)
                .build();

        assertEquals(1L, task.getId());
        assertEquals("Test task", task.getTitle());
        assertEquals("This is a test task", task.getDescription());
        assertEquals(LocalDate.of(2023, 11, 30), task.getDueDate());
        assertEquals(StatusEnum.IN_PROGRESS, task.getStatus());
        assertNotNull(task.getCreationDate());
        assertNotNull(task.getUpdateDate());
        assertNotNull(task.getCompletionDate());
        assertNotNull(task.getUser());
    }
}