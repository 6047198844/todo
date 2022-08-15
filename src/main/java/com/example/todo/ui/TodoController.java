package com.example.todo.ui;

import com.example.todo.application.*;
import com.example.todo.domain.model.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class TodoController {
    private final CreateTodoService createTodoService;
    private final ReadTodoService readTodoService;

    @PostMapping("/todo")
    private String create(@ModelAttribute CreateTodoRequest createTodoRequest) {
        try {
            final Long todoId = createTodoService.register(createTodoRequest.toDto());
            return String.format("성공적으로 등록되었습니다. 등록 ID %s", todoId);
        } catch (TodoException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/todo")
    private String findById(ReadTodoRequest readTodoRequest) {
        try {
            final Todo todo = readTodoService.read(readTodoRequest);
            return String.format("성공적으로 조회되었습니다. 등록 정보 %s", todo);
        } catch (TodoException e) {
            return e.getMessage();
        }
    }
}