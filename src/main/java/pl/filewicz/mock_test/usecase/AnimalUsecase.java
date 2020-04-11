package pl.filewicz.mock_test.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import pl.filewicz.mock_test.client.AnimalApi;
import pl.filewicz.mock_test.model.AnimalDto;
import pl.filewicz.mock_test.model.Status;
import pl.filewicz.mock_test.service.AnimalService;

@Component
@RequiredArgsConstructor
public class AnimalUsecase {

    private final AnimalApi animalApi;
    private final AnimalService service;

    public void execute(String name) {

        try {
            AnimalDto dto = service.cretaeAnimalDto(name);
            ResponseEntity<Void> response = wysylkaAnimal(dto);

            if (czyZmianaStanu(dto, response)) {
                System.out.println("zmiana stanu");
                zmianaStanu(dto,response);
                System.out.println(dto.getStatus());
            } else {
                System.out.println("nie zmieniono stanu!");
            }

        } catch (RestClientException e) {
            System.out.println("Nie udało się nawiązać połaczenia!");
            e.printStackTrace();
        }


    }

    private void zmianaStanu(AnimalDto animalDto, ResponseEntity responseEntity) {
        if (responseEntity.getStatusCodeValue() == 201) {
            animalDto.setStatus(Status.PRZYJETY_DO_ZOO);
        } else if (responseEntity.getStatusCodeValue() == 422) {
            animalDto.setStatus(Status.ODRZUCONY_PREZ_ZOO);
        }
    }

    private ResponseEntity<Void> wysylkaAnimal(AnimalDto animalDto) {

        try {
            animalApi.sendAnimal(animalDto);
            System.out.println("POomyslenie zapisano- client !");
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (HttpStatusCodeException e) {
            System.out.println("Jest połaczenie ale błąd  " + e.getStatusCode());
            return new ResponseEntity<>(e.getStatusCode());
        }
    }

    private boolean czyZmianaStanu(AnimalDto animal, ResponseEntity response) {
        if (response == null) {
            return false;
        }
        return response.getStatusCode() == HttpStatus.CREATED || response.getStatusCode() == HttpStatus.UNPROCESSABLE_ENTITY;
    }

}
