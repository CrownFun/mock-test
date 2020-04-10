package pl.filewicz.api;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AnimalApi {

    private final AnimalRepo animalRepo;


    @GetMapping("/animals")
    public List<Animal> getAnimals() {
        return animalRepo.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<Void> addAnimals(@RequestBody Animal animal) {
        System.out.println("zapis a Api!");
        if (animal.getWaga() == 100) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        } else
            animalRepo.save(animal);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        System.out.println("zapisuej zwierzaki");
        animalRepo.save(new Animal("spider"));
        animalRepo.save(new Animal("fox"));
        animalRepo.save(new Animal("spider"));
        animalRepo.save(new Animal("snake"));
    }


}
