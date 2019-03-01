package com.codecool.todo.controller;

import com.codecool.todo.model.Status;
import com.codecool.todo.model.Todo;
import com.codecool.todo.repository.TodoRepository;
import com.codecool.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    //List repository items
    @RequestMapping("/list")
    public List<Todo> todoList() {
        return todoService.todoList();
    }
    //List by status
    @PostMapping(value ="/list")
    public List<Todo> completedTodoList(@RequestParam (value = "status") String complete) {
        return todoService.findAllByComplete(complete);
    }

    // Add new
    @RequestMapping (value = "/addTodo", method = RequestMethod.POST)
    public String addTodo(@RequestParam (value = "todo-title") String title) {
        todoService.addTodo(title);
        return title;
    }
    // Delete by id
    @DeleteMapping(value ="todos/{id}")
    public Long removeById(@PathVariable Long id) {
        todoService.delete(id);
        return id;
    }

    }

