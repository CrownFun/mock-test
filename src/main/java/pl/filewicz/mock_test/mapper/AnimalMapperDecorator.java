package pl.filewicz.mock_test.mapper;

import pl.filewicz.mock_test.model.Animal;
import pl.filewicz.mock_test.model.AnimalDto;
import pl.filewicz.mock_test.model.REGION;
import pl.filewicz.mock_test.model.REGION_DTO;

public abstract class AnimalMapperDecorator implements AnimalMapper {

    private final AnimalMapper delegate;

    public AnimalMapperDecorator(AnimalMapper animalMapper) {
        this.delegate = animalMapper;
    }

    @Override
    public AnimalDto animalToDto(Animal animal) {
        AnimalDto animalDto = delegate.animalToDto(animal);
        animalDto.setRegion_dto(convertRegion(animal.getRegion()));
        return animalDto;
    }

    private static REGION_DTO convertRegion(REGION region) {

        REGION_DTO regionDto = null;


        switch (region) {
            case ASIA:
                regionDto = REGION_DTO.ASIA;
                break;
            case AFRICA:
                regionDto = REGION_DTO.AFRICA;
                break;
            case EUROPE:
                regionDto = REGION_DTO.EUROPE;
                break;
            case AMERICA:
                regionDto = REGION_DTO.AMERICA;
                break;
            case AUSTRALIA:
                regionDto = REGION_DTO.AUSTRALIA;
                break;
        }
        return regionDto;
    }
}
