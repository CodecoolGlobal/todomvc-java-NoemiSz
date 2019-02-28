package com.codecool.todo.service;

import com.codecool.todo.model.Todo;
import com.codecool.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;


    public void addTodo(String title){
        todoRepository.saveAndFlush(Todo.builder()
                .title(title)
                .build());
    }
    public List<Todo> todoList() {
        return todoRepository.findAll();
    }
}
