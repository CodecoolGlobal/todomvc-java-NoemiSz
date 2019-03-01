package com.codecool.todo.service;

import com.codecool.todo.model.Status;
import com.codecool.todo.model.Todo;
import com.codecool.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Todo findById(Long id){
        return todoRepository.getOne(id);
    }

    public List<Todo> findAllByComplete(String status){
        List<Todo> results=new ArrayList<>();
        if(status.equals("complete")){
            results =todoRepository.findByStatus(Status.COMPLETE);
        }else if (status.equals("active")){
            results =todoRepository.findByStatus(Status.ACTIVE);
        }else if(status.equals("")) {
            results = todoRepository.findAll();
        }
        return results;
    }

    public void delete(Long id){
        Todo todoToDelete = todoRepository.getOne(id);
        todoRepository.delete(todoToDelete);
    }
}
