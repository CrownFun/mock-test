package pl.filewicz.mock_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.filewicz.mock_test.mapper.AnimalMapper;
import pl.filewicz.mock_test.model.Animal;
import pl.filewicz.mock_test.model.AnimalDto;
import pl.filewicz.mock_test.model.Region;
import pl.filewicz.mock_test.model.Status;

@SpringBootApplication
public class MockTestApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(MockTestApplication.class, args);
        System.out.println("start");


        Animal animal = new Animal("fox", Region.EUROPE, false, "kfhksdhf", Status.ZŁAPANY);
        AnimalDto animalDto = AnimalMapper.INSTANCE.animalToDto(animal);
        System.out.println(animalDto);

    }

}
