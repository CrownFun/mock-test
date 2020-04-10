package pl.filewicz.mock_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.filewicz.mock_test.usecase.AnimalUsecase;

@SpringBootApplication
public class MockTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MockTestApplication.class, args);

        AnimalUsecase usecae = ctx.getBean(AnimalUsecase.class);
        usecae.execute("tiger");


    }

}
