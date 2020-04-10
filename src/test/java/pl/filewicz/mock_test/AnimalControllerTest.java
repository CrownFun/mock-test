package pl.filewicz.mock_test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.filewicz.mock_test.model.Animal;
import pl.filewicz.mock_test.model.AnimalDto;
import pl.filewicz.mock_test.repo.AnimalRepo;
import pl.filewicz.mock_test.rest.AnimalApi;
import pl.filewicz.mock_test.service.AnimalController;
import pl.filewicz.mock_test.service.AnimalService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AnimalControllerTest {

    @Mock
    private AnimalRepo animalRepo;

    @Mock
    private AnimalService animalService;

    @Mock
    private AnimalApi animalApi;

    @InjectMocks
    private AnimalController animalController;


    @Test
    public void test() {

        given(animalRepo.findAll()).willReturn(preparedata());
        List<Animal> animals = animalController.getAnimals();
        assertEquals(animals.size(), 3);
        verify(animalRepo, times(1)).findAll();


    }

    @Test
    public void test2() {


        AnimalDto fish = new AnimalDto("fish");

        when(animalService.cretaeAnimalDto("cat")).thenReturn(fish);
        when(animalApi.addAnimalDto(fish)).thenReturn("cat");

        animalController.execute("cat");

        verify(animalApi,times(1)).siema();
        verify(animalApi, atLeast(1)).addAnimalDto(fish);



    }


    private List<Animal> preparedata() {

        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("cat"));
        animals.add(new Animal("dog"));
        animals.add(new Animal("fax"));
        return animals;
    }

}