package pl.filewicz.mock_test.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import pl.filewicz.mock_test.client.AnimalApi;
import pl.filewicz.mock_test.model.AnimalDto;
import pl.filewicz.mock_test.model.Status;
import pl.filewicz.mock_test.model.Status_dto;
import pl.filewicz.mock_test.service.AnimalService;

@Component
@RequiredArgsConstructor
public class AnimalUsecase {

    private final AnimalApi animalApi;
    private final AnimalService service;

    public void execute(String name, Acknowledgment acknowledgment) {

        AnimalDto dto = null;

        try {
            dto = service.cretaeAnimalDto(name);
            ResponseEntity<Void> response = wysylkaAnimal(dto);

            if (czyZmianaStanu(dto, response)) {
                System.out.println("zmiana stanu obecny stan " + dto.getStatus());
                zmianaStanu(dto,response);
                System.out.println("stan po zmianie " + dto.getStatus());
                acknowledgment.acknowledge();
            } else {
                System.out.println("nie zmieniono stanu!");
            }

        } catch (RestClientException e) {
            System.out.println("Nie udało się nawiązać połaczenia!");

        }

        System.out.println("program konczy działanie!");
        System.out.println("-----------------------------------------");
    }

    private void zmianaStanu(AnimalDto animalDto, ResponseEntity responseEntity) {
        if (responseEntity.getStatusCodeValue() == 201) {
            animalDto.setStatus(Status_dto.WZIELI);
        } else if (responseEntity.getStatusCodeValue() == 422) {
            animalDto.setStatus(Status_dto.NIE_WZIELI);
        }
    }

    private ResponseEntity<Void> wysylkaAnimal(AnimalDto animalDto) {
        try {
            animalApi.sendAnimal(animalDto);
            System.out.println("wysłano " + animalDto.getName());
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
