package pl.filewicz.mock_test.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.filewicz.mock_test.model.Animal;

public interface AnimalRepo extends JpaRepository<Animal,Long> {

    Animal findByName(String name);
}
