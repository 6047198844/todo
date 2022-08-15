package com.example.todo.application;

import com.example.todo.domain.*;
import com.example.todo.domain.model.*;
import com.example.todo.domain.value.StatusType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class CreateTodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public Long register(CreateTodoRequestDto createTodoRequestDto) {
        validatePriority(createTodoRequestDto.getPriority());
        validateTask(createTodoRequestDto.getTask());

        final Todo todo = createTodoRequestDto.toEntity();
        todoRepository.save(todo);
        return todo.getTodoId();
    }

    private void validatePriority(Long priority) {
        if (priority < 0) throw new TodoException("우선순위는 0 이상의 값을 가집니다.");
    }

    private void validateTask(Task task) {
        if (task == null || task.getDescription() == null || task.getDescription().isEmpty())
            throw new TodoException("할일은 0 이상의 문자열을 가집니다.");
    }
}