package com.gaspar.todoapi.repository;

import com.gaspar.todoapi.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer> {

}
