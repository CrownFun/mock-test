package pl.filewicz.mock_test.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import pl.filewicz.mock_test.client.AnimalClient;
import pl.filewicz.mock_test.model.AnimalDto;
import pl.filewicz.mock_test.service.AnimalService;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AnimalUsecase {

    private final AnimalClient animalClient;
    private final AnimalService service;

    public void execute(String name) {
        AnimalDto dto = service.cretaeAnimalDto(name);
        try {
            ResponseEntity<Void> voidResponseEntity = Optional.ofNullable(dto)
                    .map(animalClient::saveAnimal)
                    .orElseThrow(() -> new RuntimeException("Nie udało sie utworzyc obiektu! "));

            if (zmianastanu(dto,voidResponseEntity)) {
                System.out.println("zmiana stanu");
            }

        } catch (RestClientException e) {
            System.out.println("Nie udało się nawiązać połaczenia!");
            e.printStackTrace();
        }


    }

    private boolean zmianastanu(AnimalDto animal, ResponseEntity entity) {
        if (entity == null) {
            return false;
        }
        return entity.getStatusCode() == HttpStatus.CREATED || entity.getStatusCode() == HttpStatus.UNPROCESSABLE_ENTITY;
    }

}
