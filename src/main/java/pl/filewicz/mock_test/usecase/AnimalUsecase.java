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
            ResponseEntity<Void> response = animalClient.saveAnimal(dto);

            if (zmianastanu(dto,response)) {
                System.out.println("zmiana stanu");
            }else {
                System.out.println("nie zmieniono stanu!");
            }

        } catch (RestClientException e) {
            System.out.println("Nie udało się nawiązać połaczenia!");
            e.printStackTrace();
        }


    }

    private boolean zmianastanu(AnimalDto animal, ResponseEntity response) {
        if (response == null) {
            return false;
        }
        return response.getStatusCode() == HttpStatus.CREATED || response.getStatusCode() == HttpStatus.UNPROCESSABLE_ENTITY;
    }

}
