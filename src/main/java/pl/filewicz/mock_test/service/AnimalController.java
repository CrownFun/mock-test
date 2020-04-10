package pl.filewicz.mock_test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.filewicz.mock_test.model.Animal;
import pl.filewicz.mock_test.model.AnimalDto;
import pl.filewicz.mock_test.repo.AnimalRepo;
import pl.filewicz.mock_test.rest.AnimalApi;
import pl.filewicz.mock_test.service.AnimalService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalRepo animalRepo;
    private final AnimalApi animalApi;
    private final AnimalService animalService;

    public List<Animal> getAnimals() {
        List<Animal> list = new ArrayList<>();
        System.out.println("metoda 1");
        animalRepo.findAll().iterator().forEachRemaining(list::add);
        System.out.println(list);
        return list;
    }

    public Animal addAnimal(Animal animal) {
        return animalRepo.save(animal);
    }

    public void execute(String name) {
        AnimalDto animalDto = animalService.cretaeAnimalDto(name);
        animalApi.addAnimalDto(animalDto);
       animalApi.siema();
    }


}
