package pl.filewicz.mock_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.filewicz.mock_test.rest.AnimalApi;
import pl.filewicz.mock_test.mapper.AnimalMapper;
import pl.filewicz.mock_test.model.Animal;
import pl.filewicz.mock_test.model.AnimalDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalApi animalApi;

    public AnimalDto cretaeAnimalDto(String name) {
        System.out.println("tworze zwierzaka");
        List<Animal> animals = animalApi.getAnimals();
        Animal animal1 = animals.stream().filter(animal -> animal.getName().equals(name)).collect(Collectors.toList()).get(0);
        return AnimalMapper.INSTANCE.animalToDto(animal1);
    }

}
