package com.example.todo.domain;

import com.example.todo.domain.model.StatusHistory;
import org.springframework.data.repository.CrudRepository;

public interface StatusHistoryRepository extends CrudRepository<StatusHistory, Long> {
}
