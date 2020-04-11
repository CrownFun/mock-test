package pl.filewicz.mock_test.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaManageController {

    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    @RequestMapping("/stop")
    public void stop() {
        MessageListenerContainer listenerContainer = kafkaListenerEndpointRegistry.getListenerContainer("full-part-id");
        listenerContainer.stop();
    }

    @RequestMapping("/start")
    public void start() {
        MessageListenerContainer listenerContainer = kafkaListenerEndpointRegistry.getListenerContainer("full-part-id");
        listenerContainer.start();
    }
}