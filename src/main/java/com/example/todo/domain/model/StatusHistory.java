package com.example.todo.domain.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "status_history")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private Long todoId;
    @Embedded
    private Status status;
}