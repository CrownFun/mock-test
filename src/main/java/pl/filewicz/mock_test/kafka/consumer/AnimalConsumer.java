package pl.filewicz.mock_test.kafka.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import pl.filewicz.mock_test.kafka.AnimalEvent;
import pl.filewicz.mock_test.usecase.AnimalUsecase;

@Service
@RequiredArgsConstructor
public class AnimalConsumer {

    private final AnimalUsecase animalUsecase;

    @KafkaListener(topics = "${app.topic.example}")
    public void receive(@Payload AnimalEvent event, @Headers MessageHeaders headers){


        System.out.println("odebrano komunikat  z kafki " + event.getName());
        animalUsecase.execute(event.getName());
    }

}
