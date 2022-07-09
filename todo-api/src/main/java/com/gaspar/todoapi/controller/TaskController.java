package com.gaspar.todoapi.controller;

import com.gaspar.todoapi.dto.TaskDto;
import com.gaspar.todoapi.entity.Task;
import com.gaspar.todoapi.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService  taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskDto taskDto){
        return taskService.createTask(taskDto);
    }

    @GetMapping("/all")
    public List<Task> listOfTasks(){
        return taskService.allTasks();
    }
}
