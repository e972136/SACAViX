package com.gaspar.todoapi.controller;

import com.gaspar.todoapi.dto.TaskDto;
import com.gaspar.todoapi.entity.Task;
import com.gaspar.todoapi.entity.TaskStatus;
import com.gaspar.todoapi.service.TaskService;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/byEstatus/{status}")
    public List<Task> listOfTasksByStatus(@PathVariable TaskStatus status){
        return taskService.findByStatus(status);
    }

    @PatchMapping("/setFinished/{id}")
    public Task setFinished(@PathVariable Integer id){
        return taskService.setFinished(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Integer id){
        return taskService.deleteId(id);
    }
}
