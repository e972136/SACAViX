package com.rabbitmq.rabbitmqspringboot.dummy;

import com.rabbitmq.rabbitmqspringboot.publisher.IntercambioDatos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/test")
public class DummyController {

    private final DummyService dummyService;


    public DummyController(DummyService dummyService) {
        this.dummyService = dummyService;
    }

    @PostMapping()
    public void testSendMessage(@RequestBody IntercambioDatos msg){
        log.error("a Enviar {}",msg);
        dummyService.sendToRabbit(msg);
    }
}
