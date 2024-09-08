/*
 * (C) Copyright 2024 Fresher Spring. All rights reserved.
 * @Author HoangMH1
 * @Date Sep 08, 2024
 * @Version 1.0
 */

package com.edu.controller;

import com.edu.data.TodoItem;
import com.edu.data.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoRepository todoRepository;

    @GetMapping("/")
    public String items(Model model) {
        List<TodoItem> todos = todoRepository.findAll();
        model.addAttribute("itemList", todos);
        return "index";
    }

    @PostMapping("/todos/{id}/complete")
    public String completeTodo(@PathVariable Long id, Model model) {
        TodoItem todo = todoRepository.findById(id).orElseThrow();
        todo.setCompleted(!todo.isCompleted());
        todoRepository.save(todo);
        model.addAttribute("item", todo);
        return "todo";
    }

    @PostMapping("/todos")
    public String createTodo(Model model, @ModelAttribute TodoItem todoItem) {
        todoRepository.save(todoItem);
        model.addAttribute("item", todoItem);
        return "todo";
    }

    @DeleteMapping("/todos/{id}/delete")
    @ResponseBody
    public String deleteTodo(@PathVariable Long id) {
        todoRepository.deleteById(id);
        return "";
    }
}
