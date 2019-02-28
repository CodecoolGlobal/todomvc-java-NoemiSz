package com.codecool.todo.controller;

import com.codecool.todo.model.Todo;
import com.codecool.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

//List repository items
    @RequestMapping("/list")
    public List<Todo> todoList() {
        return todoRepository.findAll();
    }

// Add new
    @RequestMapping (value = "/addTodo", method = RequestMethod.POST)
    public String addTodo(@RequestParam (value = "todo-title") String title) {
        todoRepository.saveAndFlush(Todo.builder()
                .title(title)
                .build());
        return title;
    }
}
