package com.gaspar.todoapi.dto;

import com.gaspar.todoapi.entity.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    String title;
    String description;
    LocalDateTime eta;
}
