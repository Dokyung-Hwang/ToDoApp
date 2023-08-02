package com.codestates.ToDoApp.repository;

import com.codestates.ToDoApp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}