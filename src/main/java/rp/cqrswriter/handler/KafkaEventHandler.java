package rp.cqrswriter.handler;

import lombok.extern.java.Log;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import rp.cqrswriter.model.UserCreatedEvent;

@Log
@Service
public class KafkaEventHandler {

    private final KafkaTemplate<String, UserCreatedEvent> kafkaTemplate;

    public KafkaEventHandler(KafkaTemplate<String, UserCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @EventHandler
    public void on(UserCreatedEvent event) {
        log.info("onUserCreatedEvent" + event.toString());
        kafkaTemplate.send("cqrs", event);
    }
}
