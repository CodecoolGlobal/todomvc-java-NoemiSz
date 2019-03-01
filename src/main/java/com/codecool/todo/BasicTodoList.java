package com.codecool.todo;//import static spark.Spark.*;

import com.codecool.todo.model.Status;
import com.codecool.todo.repository.TodoRepository;
import com.codecool.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BasicTodoList{


    @Autowired
    private TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(BasicTodoList.class, args);
    }

    @Bean
    public CommandLineRunner init(){
        return args -> {
            Todo firstTodo = Todo.builder()
                    .title("first TODO item")
                    .build();
            todoRepository.save(firstTodo);
            Todo secondTodo = Todo.builder()
                    .title("second TODO item")
                    .build();
            todoRepository.save(secondTodo);
            Todo thirdTodo = Todo.builder()
                    .title("third TODO item")
                    .status(Status.COMPLETE)
                    .build();
            todoRepository.save(thirdTodo);
        };
    }
}



