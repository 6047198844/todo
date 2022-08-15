package com.example.todo.domain.model;

import com.example.todo.domain.value.StatusType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Table(name = "todo")
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Todo {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId; // 아이디
    @Embedded
    private Task task; // 할일
    @Singular
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name="todoId")
    private Set<StatusHistory> statusHistories; // 상태
    private Long priority; // 우선순위
    private LocalDateTime startDate; // 설정기간
    private LocalDateTime endDate; // 설정기간
}