package com.codestates.ToDoApp.service;


import com.codestates.ToDoApp.entity.Todo;
import com.codestates.ToDoApp.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> findTodos() {
        return todoRepository.findAll();
    }

    public Todo findTodo(Long id) {
        return verifyExistsTodo(id);
    }

    public Todo updateTodo(Long id, Todo todo){
        Todo findTodo = verifyExistsTodo(id);

        Optional.of(todo.getTodoOrder())
                .ifPresent(findTodo::setTodoOrder);
        Optional.ofNullable(todo.getTitle())
                .ifPresent(findTodo::setTitle);
        Optional.of(todo.isCompleted())
                .ifPresent(findTodo::setCompleted);

        return todoRepository.save(findTodo);
    }


    public void deleteAllTodo() {
        todoRepository.deleteAll();
    }

    public void deleteTodo(Long id) {
        Todo todo = verifyExistsTodo(id);
        todoRepository.delete(todo);
    }


    private Todo verifyExistsTodo(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }
}
