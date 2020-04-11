package pl.filewicz.mock_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.filewicz.mock_test.kafka.AnimalEvent;
import pl.filewicz.mock_test.kafka.producer.AnimalProducer;
import pl.filewicz.mock_test.usecase.AnimalUsecase;

@SpringBootApplication
public class MockTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MockTestApplication.class, args);
        AnimalProducer producer = ctx.getBean(AnimalProducer.class);
        AnimalEvent animalEvent = new AnimalEvent();


        try {

            Thread.sleep(500);
            animalEvent.setName("cat");
            producer.send(animalEvent);

            Thread.sleep(500);
            animalEvent.setName("tiger");
            producer.send(animalEvent);

            Thread.sleep(500);
            animalEvent.setName("lion");
            producer.send(animalEvent);

            Thread.sleep(500);
            animalEvent.setName("snake");
            producer.send(animalEvent);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        AnimalUsecase usecae = ctx.getBean(AnimalUsecase.class);
//        usecae.execute("tiger");


    }

}
