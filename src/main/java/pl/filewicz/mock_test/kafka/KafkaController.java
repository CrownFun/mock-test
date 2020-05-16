package pl.filewicz.mock_test.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.web.bind.annotation.*;
import pl.filewicz.mock_test.kafka.producer.AnimalProducer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final AnimalProducer producer;
    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    @Autowired
    KafkaController(AnimalProducer producer) {
        this.producer = producer;
    }
    //    http://localhost:8084/kafka/animal
    @PostMapping(value = "/{animal}")
    public void sendMessageToKafkaTopic(@PathVariable("animal") String animal) {
        AnimalEvent animalEvent = new AnimalEvent();
        animalEvent.setName(animal);
        this.producer.send(animalEvent);
    }
    @GetMapping("/stop")
    public void stop() {
        System.out.println("Stop consumer");
        MessageListenerContainer listenerContainer = kafkaListenerEndpointRegistry.getListenerContainer("full-part-id");
        listenerContainer.stop();
    }

    @GetMapping("/start")
    public void start() {
        System.out.println("Start consumer");
        MessageListenerContainer listenerContainer = kafkaListenerEndpointRegistry.getListenerContainer("full-part-id");
        listenerContainer.start();
    }
}
