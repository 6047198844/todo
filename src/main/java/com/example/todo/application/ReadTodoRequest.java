package com.example.todo.application;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReadTodoRequest {
    private Long todoId;
}