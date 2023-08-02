package com.codestates.ToDoApp.controller;

import com.codestates.ToDoApp.dto.TodoDto;
import com.codestates.ToDoApp.entity.Todo;
import com.codestates.ToDoApp.mapper.TodoMapper;
import com.codestates.ToDoApp.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    private final TodoMapper todoMapper;

    @PostMapping
    public ResponseEntity<Todo> postTodo(@RequestBody TodoDto.Post todoRequestPostDto) {
        Todo todo = todoService.saveTodo(todoMapper.todoPostDtoToTodo(todoRequestPostDto));

        return new ResponseEntity<>(todo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        List<Todo> todos = todoService.findTodos();

        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{todo-id}")
    public ResponseEntity<Todo> getTodo(@PathVariable("todo-id") long todoId) {
        Todo todo = todoService.findTodo(todoId);

        return ResponseEntity.ok(todo);
    }

    @PatchMapping("/{todo-id}")
    public ResponseEntity<Todo> patchTodo(@PathVariable("todo-id") long id, @RequestBody TodoDto.Patch todoRequestPatchDto) {
        Todo todo = todoService.updateTodo(id, todoMapper.todoPatchDtoToTodo(todoRequestPatchDto));

        return ResponseEntity.ok(todo);
    }

    @DeleteMapping
    public void deleteAllTodo() {
        todoService.deleteAllTodo();
    }

    @DeleteMapping("/{todo-id}")
    public void deleteTodo(@PathVariable("todo-id") long todoId) {
        todoService.deleteTodo(todoId);
    }
}
