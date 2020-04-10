package pl.filewicz.mock_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.filewicz.mock_test.mapper.AnimalCreator;
import pl.filewicz.mock_test.repo.AnimalRepo;
import pl.filewicz.mock_test.mapper.AnimalMapper;
import pl.filewicz.mock_test.model.Animal;
import pl.filewicz.mock_test.model.AnimalDto;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepo animalRepo;
    private final AnimalCreator animalCreator;

    public AnimalDto cretaeAnimalDto(String name) {
        System.out.println("tworze zwierzaka");
        Animal animal = animalRepo.findByName(name);
        return animalCreator.createAnimalDto(animal);
    }

}
