package taskManagerApi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskManagerApiApplicationTests {

	@Test
	void contextLoads() {

		int numero1 = 5;
		int numero2 = 3;

		Assertions.assertEquals(8, numero1 + numero2);
	}

}
