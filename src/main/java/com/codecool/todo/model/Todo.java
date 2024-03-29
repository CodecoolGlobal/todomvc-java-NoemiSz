package com.codecool.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Todo {
    @Id
    @GeneratedValue
    private long id;

    private String title;

    @Builder.Default
    private Status status = Status.ACTIVE;

    public boolean isComplete() {
        return this.status == Status.COMPLETE;
    }

}
