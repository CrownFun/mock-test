package pl.filewicz.mock_test.init;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.filewicz.mock_test.model.Animal;
import pl.filewicz.mock_test.model.Region;
import pl.filewicz.mock_test.model.Status;
import pl.filewicz.mock_test.repo.AnimalRepo;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final AnimalRepo animalRepo;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        System.out.println("zapisuje zwierzaki init");
        animalRepo.save(new Animal("a", Region.EUROPE, false, "kfhksdhf", Status.ZŁAPANY));
        animalRepo.save(new Animal("b", Region.ASIA, true, "kfhksdhf",Status.ZŁAPANY));
        animalRepo.save(new Animal("c", Region.AMERICA, true, "kfhksdhf",Status.ZŁAPANY));
        animalRepo.save(new Animal("d", Region.AUSTRALIA, true, "kfhksdhf",Status.ZŁAPANY));
        animalRepo.save(new Animal("e", Region.AUSTRALIA, true, "kfhksdhf",Status.ZŁAPANY));
        animalRepo.save(new Animal("f", Region.AUSTRALIA, true, "kfhksdhf",Status.ZŁAPANY));
        animalRepo.save(new Animal("g", Region.AUSTRALIA, true, "kfhksdhf",Status.ZŁAPANY));
    }
}
