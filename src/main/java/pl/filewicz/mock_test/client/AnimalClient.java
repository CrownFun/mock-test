package pl.filewicz.mock_test.client;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import pl.filewicz.mock_test.model.Animal;
import pl.filewicz.mock_test.model.AnimalDto;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AnimalClient {

    private final RestTemplate restTemplate;

    public List<Animal> getAllAnimals() {
        ResponseEntity<List<Animal>> exchange = restTemplate.exchange("http://localhost:8085/api/animals", HttpMethod.GET, null, new ParameterizedTypeReference<List<Animal>>() {
        });
        return exchange.getBody();

    }

    public String hello() {
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8085/api/hello", HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
        });
        return exchange.getBody();

    }


}
