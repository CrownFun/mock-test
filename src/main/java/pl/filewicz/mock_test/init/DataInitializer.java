package pl.filewicz.mock_test.init;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.filewicz.mock_test.model.Animal;
import pl.filewicz.mock_test.model.REGION;
import pl.filewicz.mock_test.repo.AnimalRepo;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final AnimalRepo animalRepo;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        System.out.println("zapisuje zwierzaki init");
        animalRepo.save(new Animal("cat", REGION.EUROPE, false, "kfhksdhf"));
        animalRepo.save(new Animal("tiger", REGION.ASIA, true, "kfhksdhf"));
        animalRepo.save(new Animal("lion", REGION.AMERICA, true, "kfhksdhf"));
        animalRepo.save(new Animal("snake", REGION.AUSTRALIA, true, "kfhksdhf"));
    }

}
