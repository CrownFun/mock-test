package pl.filewicz.mock_test.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.filewicz.mock_test.client.AnimalClient;
import pl.filewicz.mock_test.model.Animal;
import pl.filewicz.mock_test.model.AnimalDto;

@Component
@RequiredArgsConstructor
public class AnimalCreator {

    private final AnimalClient animalClient;

    public AnimalDto createAnimalDto(Animal animal){
        System.out.println(printHello());
        return AnimalMapper.INSTANCE.animalToDto(animal);
    }

    private String printHello() {
        return animalClient.hello();
    }

}
