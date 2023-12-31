package taskManagerApi.models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {

    @Test
    void testSetAndGetId() {
        UserEntity user = new UserEntity();
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    void testSetAndGetUsername() {
        UserEntity user = new UserEntity();
        user.setUsername("johndoe");
        assertEquals("johndoe", user.getUsername());
    }

    @Test
    void testSetAndGetHashedPassword() {
        UserEntity user = new UserEntity();
        user.setHashedPassword("hashedPassword123");
        assertEquals("hashedPassword123", user.getHashedPassword());
    }

    @Test
    void testSetAndGetFullName() {
        UserEntity user = new UserEntity();
        user.setFullName("John Doe");
        assertEquals("John Doe", user.getFullName());
    }

    @Test
    void testSetAndGetTasksList() {
        UserEntity user = new UserEntity();

        List<TaskEntity> tasksList = new ArrayList<>();
        TaskEntity task1 = TaskEntity.builder().id(1L).title("Tarea 1").build();
        TaskEntity task2 = TaskEntity.builder().id(2L).title("Tarea 2").build();
        tasksList.add(task1);
        tasksList.add(task2);

        user.setTasksList(tasksList);

        List<TaskEntity> retrievedTasksList = user.getTasksList();
        assertEquals(tasksList, retrievedTasksList);
    }


    @Test
    void testBuilder() {
        UserEntity user = UserEntity.builder()
                .id(1L)
                .username("johndoe")
                .hashedPassword("hashedPassword123")
                .fullName("John Doe")
                .build();

        assertNotNull(user);
        assertEquals(1L, user.getId());
        assertEquals("johndoe", user.getUsername());
        assertEquals("hashedPassword123", user.getHashedPassword());
        assertEquals("John Doe", user.getFullName());
    }
}