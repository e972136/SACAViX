package com.gaspar.todoapi.service;

import com.gaspar.todoapi.dto.TaskDto;
import com.gaspar.todoapi.entity.Task;
import com.gaspar.todoapi.entity.TaskStatus;
import com.gaspar.todoapi.exception.ToDoExceptions;
import com.gaspar.todoapi.repository.TaskRepository;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(TaskDto taskDto) {
        Task nueva = Task.builder()
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .eta(taskDto.getEta())
                .createdDate(LocalDateTime.now())
                .finished(false)
                .taskStatus(TaskStatus.ON_TIME).build();
        Task save = taskRepository.save(nueva);
        return save;
    }

    public List<Task> allTasks() {
        return taskRepository.findAll();
    }

    public List<Task> findByStatus(TaskStatus taskStatus){
        return taskRepository.findAllBytaskStatus(taskStatus);
    }

    @Transactional
    public Task setFinished(Integer id){
        int i = taskRepository.markTaskAsFinish(id);
        if(i==0){
            throw  new ToDoExceptions("Task not found", HttpStatus.BAD_REQUEST);
        }
        Task task = taskRepository.findById(id).orElse(null);
        return task;
    }

    @Transactional
    public ResponseEntity<Boolean> deleteId(Integer id) {
        int i = taskRepository.deleteTask(id);
        if(i==0){
            throw  new ToDoExceptions("Task not found", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(true);
    }
}
