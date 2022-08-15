package com.example.todo.application;

import com.example.todo.domain.model.Todo;
import com.example.todo.domain.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReadTodoService {
    private final TodoRepository todoRepository;
    @Transactional
    public Todo read(ReadTodoRequest readTodoRequest) {
        validateId(readTodoRequest.getTodoId());
        return todoRepository
                .findById(readTodoRequest.getTodoId())
                .orElseThrow(() -> new TodoException("존재하지 않는 값입니다."));
    }

    private void validateId(Long todoId) {
        if (todoId == null) throw new TodoException("아이디 값이 있어야 합니다.");
    }
}