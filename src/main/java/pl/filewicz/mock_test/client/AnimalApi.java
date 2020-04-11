package pl.filewicz.mock_test.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.filewicz.mock_test.model.AnimalDto;

@Component
@RequiredArgsConstructor
public class AnimalApi {

    private final RestTemplate restTemplate;


    public void sendAnimal(AnimalDto animalDto){
        System.out.println("wysyła się " + animalDto.getName());
        restTemplate.postForEntity("http://localhost:8085/api/save", animalDto, AnimalDto.class);
    }

}
