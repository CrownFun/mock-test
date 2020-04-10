package pl.filewicz.api;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepo extends JpaRepository<Animal,Long> {
}
