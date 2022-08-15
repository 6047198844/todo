package com.example.todo.domain.model;

import com.example.todo.domain.value.StatusType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    private StatusType statusType;
    private LocalDateTime updateDateTime;
}