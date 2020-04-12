package pl.filewicz.mock_test.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import pl.filewicz.mock_test.kafka.AnimalEvent;

@Service
@RequiredArgsConstructor
public class AnimalProducer {

    private final KafkaTemplate<String, AnimalEvent> kafkaTemplate;

    @Value("${app.topic.example}")
    private String topic;

    public void send(AnimalEvent event){
        System.out.println("wysyłanie komunikatu przez producera "+event.getName());

        Message<AnimalEvent> message = MessageBuilder
                .withPayload(event)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        kafkaTemplate.send(message);
    }


}
