package com.Jun.ToDoList.controller;

import com.Jun.ToDoList.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("/")
    public String showToDoList(Model model){
        model.addAttribute("todos", toDoService.getAllTasks());

        return "todolist";
    }

    @PostMapping ("/todos")
    public String addTask(@RequestParam("task") String task){
        toDoService.addTask(task);
        return "redirect:/";
    }

    @PostMapping ("/todos/toggle")
    public String toggleComplete(@RequestParam("taskId") int taskId){
        toDoService.toggleTaskCompletion(taskId);
        return "redirect:/";
    }

    @PostMapping ("todos/update")
    public String updateTask(@RequestParam("taskId") int taskId, @RequestParam("newDescription") String newDescription){
        toDoService.updateTask(taskId, newDescription);
        return "redirect:/";
    }

    @PostMapping ("/todos/delete")
    public String deleteTask(@RequestParam("taskId") int taskId){
        toDoService.deleteTask(taskId);
        return "redirect:/";
    }


}


