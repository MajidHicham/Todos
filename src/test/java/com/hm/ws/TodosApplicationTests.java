package com.hm.ws;

import com.hm.ws.model.Todo;
import com.hm.ws.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class TodosApplicationTests {

	@Autowired
	private TodoRepository todoRepository;

	@Test
	void contextLoads() {

		// given
		Todo todo = new Todo(null, "Learn Devops", LocalDateTime.now(), "devops@dev.fr", true);
		todoRepository.save(todo);

		assertNotNull(todoRepository.findById(1L));


	}

}
