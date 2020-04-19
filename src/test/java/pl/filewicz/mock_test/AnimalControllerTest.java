package pl.filewicz.mock_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.kafka.support.Acknowledgment;
import pl.filewicz.mock_test.client.AnimalApi;
import pl.filewicz.mock_test.model.AnimalDto;
import pl.filewicz.mock_test.model.Region_dto;
import pl.filewicz.mock_test.service.AnimalService;
import pl.filewicz.mock_test.usecase.AnimalUsecase;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnimalControllerTest {

    @Mock
    private AnimalApi animalApi;

    @Mock
    private AnimalService animalService;

    @Mock
    private Acknowledgment acknowledgment;

    @InjectMocks
    private AnimalUsecase usecase;


    @Test
    public void test2() {


        AnimalDto fish = new AnimalDto("fish", Region_dto.AFRYKA,true);

        when(animalService.cretaeAnimalDto("bear")).thenReturn(fish);
        doNothing().when(animalApi).sendAnimal(fish);

        usecase.execute("bear",acknowledgment);


        verify(animalService,times(1)).cretaeAnimalDto("bear");
        verify(animalApi, atLeast(1)).sendAnimal(fish);

    }



}