package com.codestates.ToDoApp.mapper;


import com.codestates.ToDoApp.dto.TodoDto;
import com.codestates.ToDoApp.entity.Todo;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public Todo todoPostDtoToTodo(TodoDto.Post todoPost) {
        Todo todo = new Todo();
        todo.setTodoOrder(todoPost.getTodoOrder());
        todo.setCompleted(todoPost.isCompleted());
        todo.setTitle(todoPost.getTitle());

        return todo;
    }

    public Todo todoPatchDtoToTodo(TodoDto.Patch todoPatch) {
        Todo todo = new Todo();
        todo.setTodoOrder(todoPatch.getTodoOrder());
        todo.setCompleted(todoPatch.isCompleted());
        todo.setTitle(todoPatch.getTitle());

        return todo;
    }
}
