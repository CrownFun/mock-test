package pl.filewicz.mock_test.mapper;

import pl.filewicz.mock_test.model.Animal;
import pl.filewicz.mock_test.model.AnimalDto;
import pl.filewicz.mock_test.model.Region;
import pl.filewicz.mock_test.model.Region_dto;

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

    private static Region_dto convertRegion(Region region) {

        Region_dto regionDto = null;


        switch (region) {
            case ASIA:
                regionDto = Region_dto.ASIA;
                break;
            case AFRICA:
                regionDto = Region_dto.AFRICA;
                break;
            case EUROPE:
                regionDto = Region_dto.EUROPE;
                break;
            case AMERICA:
                regionDto = Region_dto.AMERICA;
                break;
            case AUSTRALIA:
                regionDto = Region_dto.AUSTRALIA;
                break;
        }
        return regionDto;
    }
}
