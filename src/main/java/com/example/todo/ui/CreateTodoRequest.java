package com.example.todo.ui;

import com.example.todo.application.CreateTodoRequestDto;
import com.example.todo.domain.model.Task;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateTodoRequest {
    private String task; // 할일
    private Long priority; // 우선순위
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDate; // 설정기간
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDate; // 설정기간

    public CreateTodoRequestDto toDto() {
        return CreateTodoRequestDto.builder()
                .task(new Task(task))
                .priority(priority)
                .startDate(startDate)
                .endDate(endDate).build();
    }
}