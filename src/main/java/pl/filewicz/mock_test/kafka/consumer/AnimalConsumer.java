package pl.filewicz.mock_test.kafka.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
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

//    @KafkaListener(topics = "${app.topic.example}",groupId ="HUJ",id ="full-part-id",containerFactory = "kafkaManualAckListenerContainerFactory")
    public void receive(@Payload AnimalEvent event, @Headers MessageHeaders headers, Acknowledgment acknowledgment ){

        System.out.println("odebrano komunikatu przez consumera " + event.getName());
        animalUsecase.execute(event.getName(),acknowledgment);

    }

}
