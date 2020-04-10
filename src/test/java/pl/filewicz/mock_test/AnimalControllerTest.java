package pl.filewicz.mock_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.filewicz.mock_test.client.AnimalClient;
import pl.filewicz.mock_test.model.Animal;
import pl.filewicz.mock_test.model.AnimalDto;
import pl.filewicz.mock_test.model.REGION_DTO;
import pl.filewicz.mock_test.service.AnimalService;
import pl.filewicz.mock_test.usecase.AnimalUsecase;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnimalControllerTest {

    @Mock
    private AnimalClient animalClient;

    @Mock
    private AnimalService animalService;

    @InjectMocks
    private AnimalUsecase usecase;


    @Test
    public void test2() {


        AnimalDto fish = new AnimalDto("fish", REGION_DTO.AFRICA,true);

        when(animalService.cretaeAnimalDto("bear")).thenReturn(fish);
        when(animalClient.saveAnimal(fish)).thenReturn(new ResponseEntity<>(HttpStatus.CREATED));

        usecase.execute("bear");


        verify(animalService,times(1)).cretaeAnimalDto("bear");
        verify(animalClient, atLeast(1)).saveAnimal(fish);


    }



}