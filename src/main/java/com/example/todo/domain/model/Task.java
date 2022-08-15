package com.example.todo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Getter
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private String description;
}