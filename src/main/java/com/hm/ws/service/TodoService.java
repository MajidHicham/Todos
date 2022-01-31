package com.hm.ws.service;

import com.hm.ws.exception.TodoNotFoundException;
import com.hm.ws.model.Todo;
import com.hm.ws.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoService {

    private final TodoRepository todoRepository;

    public List<Todo> findAllTodos() {
        log.info("Fetching all todos");
        return todoRepository.findAll();
    }

    public Todo getTodo(Long id) {
        log.info("Fetch todo {}", id);
        return todoRepository.findById(id).orElseThrow(() -> new TodoNotFoundException("Todo by id " + id + " not exist"));
    }

    @Transactional
    public Todo saveTodo(Todo todo) {
        log.info("Saving todo {} in database", todo);
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}
