package pl.filewicz.mock_test.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import pl.filewicz.mock_test.kafka.AnimalEvent;

@Service
public class AnimalConsumer {

    @KafkaListener(topics = "${app.topic.example}")
    public void receive(@Payload AnimalEvent event, @Headers MessageHeaders headers){

        headers.keySet().forEach(key -> {
            System.out.println("nagłowek " + headers.get(key));
        });

        System.out.println("odebrano komunikat  z kafki " + event.getName());

    }

}
