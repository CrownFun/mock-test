package pl.filewicz.api.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.filewicz.api.model.AnimalDto;

@RestController
@RequestMapping("/api")
public class AnimalApi {

    @PostMapping("/save")
    public ResponseEntity<Void> addAnimals(@RequestBody AnimalDto animalDto) {
        System.out.println("zapis a Api!");
        if (animalDto.getName().equals("cat")) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        } else
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello from rest Api:)";
    }


}
