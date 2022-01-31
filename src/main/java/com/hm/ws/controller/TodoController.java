package com.hm.ws.controller;

import com.hm.ws.model.Todo;
import com.hm.ws.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {


    private final TodoService todoService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all")
    public List<Todo> getAllTodos() {
        return todoService.findAllTodos();
    }

    @PostMapping("/add")
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.saveTodo(todo);
    }

    @PutMapping(value = "/edit/{id}")
    public Todo editTodo(@PathVariable("id") Long id, @RequestBody Todo todo) {
        return todoService.saveTodo(todo);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
    }
}
