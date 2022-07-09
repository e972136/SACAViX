package com.gaspar.todoapi.repository;

import com.gaspar.todoapi.entity.Task;
import com.gaspar.todoapi.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    List<Task> findAllBytaskStatus(TaskStatus taskStatus);

    @Modifying
    @Query(
            value = "UPDATE task SET finished=true where id = :id",
            nativeQuery = true)
    int markTaskAsFinish(Integer id);


    @Modifying
    @Query(
            value = "DELETE FROM task where id = :id",
            nativeQuery = true)
    int deleteTask(Integer id);
}
