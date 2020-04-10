package pl.filewicz.mock_test.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.filewicz.mock_test.service.AnimalController;
import pl.filewicz.mock_test.mapper.AnimalMapper;
import pl.filewicz.mock_test.model.Animal;
import pl.filewicz.mock_test.model.AnimalDto;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AnimalApi {

    private AnimalController animalController;
    private AnimalMapper animalMapper;


    @GetMapping("/animals")
    public List<Animal> getAnimals() {
        return preparedata();
    }

    @PostMapping("/animals")
    public void addAnimals(@RequestBody Animal animal) {
        animalController.addAnimal(animal);
    }
//
    private List<Animal> preparedata() {

//        List<Animal> animals = new ArrayList<>();
//        animals.add(new Animal("dog"));
//        animals.add(new Animal("fox"));
//        animals.add(new Animal("spider"));
        return null;
    }


    public String addAnimalDto(AnimalDto animalDto) {
        System.out.println("pomysle" +
                " zapisamo zwizrez " + animalDto.getName());
        if (animalDto.getName().equals("fox")) {
            return "fox";
        } else
            return "dog";
    }


    public void siema(){
        System.out.println("siemka ");
    }

}
