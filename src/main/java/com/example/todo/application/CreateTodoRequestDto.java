package com.example.todo.application;

import com.example.todo.domain.model.Status;
import com.example.todo.domain.model.StatusHistory;
import com.example.todo.domain.model.Task;
import com.example.todo.domain.model.Todo;
import com.example.todo.domain.value.StatusType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashSet;

@Getter
@Builder
public class CreateTodoRequestDto {
    private Task task; // 할일
    private Long priority; // 우선순위
    private LocalDateTime startDate; // 설정기간
    private LocalDateTime endDate; // 설정기간

    public Todo toEntity() {
        return Todo.builder()
                .task(this.getTask())
                .priority(this.getPriority())
                .startDate(this.getStartDate())
                .endDate(this.getEndDate())
                .statusHistory(StatusHistory.builder().status(new Status(StatusType.CREATE, LocalDateTime.now())).build())
                .build();
    }
}