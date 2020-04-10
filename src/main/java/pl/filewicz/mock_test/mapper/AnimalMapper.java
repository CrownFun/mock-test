package pl.filewicz.mock_test.mapper;

import org.springframework.stereotype.Component;
import pl.filewicz.mock_test.model.Animal;
import pl.filewicz.mock_test.model.AnimalDto;

@Component
public class AnimalMapper {

    public AnimalDto animalToDto(Animal animal) {

        return new AnimalDto(animal.getName());
    }

    public Animal dtoToAnimal(AnimalDto animalDto) {
        return new Animal(animalDto.getName());
    }


}
