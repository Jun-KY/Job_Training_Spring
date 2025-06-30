package com.Jun.ToDoList.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ToDoService {
    private final List<Task> tasks = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public List<Task> getAllTasks() {
        return tasks;
    }
    public void addTask(String description){
        tasks.add(new Task(idCounter.getAndIncrement(),description));

//        for (Task task : tasks){
//            System.out.println(task.getId() + task.getDescription() + task.isCompleted());
//        }
    }

    public void toggleTaskCompletion(int taskId){
        for (Task task : tasks){
            if(task.getId() == taskId){
                task.setCompleted(!task.isCompleted());
                break;
            }
        }
    }

    public void updateTask(int taskId, String newDescription) {
        for (Task task: tasks){
            if(task.getId() == taskId){
                task.setDescription(newDescription);
                break;
            }
        }
    }

    public void deleteTask(int taskId){
        tasks.removeIf(t -> t.getId() == taskId);
    }

    public static class Task{
        private final int id;
        private String description;
        private boolean completed = false;

        public Task(int id, String description){
            this.id = id;
            this.description = description;
        }

        public int getId(){return id;}
        public String getDescription(){return description;}
        public boolean isCompleted() {return completed;}

        public void setDescription(String description){
            this.description = description;
        }
        public void setCompleted(boolean completed) {
            this.completed = completed;
        }
    }
}
