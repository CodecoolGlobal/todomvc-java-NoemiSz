package com.codecool.todo.repository;

import com.codecool.todo.model.Status;
import com.codecool.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAll();

    @Override
    Todo getOne(Long aLong);

    @Override
    <S extends Todo> S saveAndFlush(S s);

    @Override
    void delete(Todo todo);

    List<Todo> findByStatus(Status status);
}
