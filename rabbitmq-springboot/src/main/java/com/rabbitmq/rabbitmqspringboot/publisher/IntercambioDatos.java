package com.rabbitmq.rabbitmqspringboot.publisher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@ToString
public class IntercambioDatos implements Serializable {
    Integer id;
    String message;
}
