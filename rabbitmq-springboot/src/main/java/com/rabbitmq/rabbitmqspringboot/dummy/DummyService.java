package com.rabbitmq.rabbitmqspringboot.dummy;

import com.rabbitmq.rabbitmqspringboot.publisher.IntercambioDatos;
import com.rabbitmq.rabbitmqspringboot.publisher.Publicador;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DummyService {
    @Autowired
    private Publicador publicador;

    public void sendToRabbit(IntercambioDatos datos){
       // log.info("Message {} enviado",message);
        publicador.send(datos);
    }

}
