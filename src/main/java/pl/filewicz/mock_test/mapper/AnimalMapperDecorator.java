package pl.filewicz.mock_test.mapper;

import pl.filewicz.mock_test.model.Animal;
import pl.filewicz.mock_test.model.AnimalDto;
import pl.filewicz.mock_test.model.Region_dto;
import pl.filewicz.mock_test.model.Status_dto;

public abstract class AnimalMapperDecorator implements AnimalMapper {

    private final AnimalMapper delegate;

    public AnimalMapperDecorator(AnimalMapper animalMapper) {
        this.delegate = animalMapper;
    }

    @Override
    public AnimalDto animalToDto(Animal animal) {
        AnimalDto animalDto = delegate.animalToDto(animal);
        Region_dto region_dto = RegionMapper.REGION_MAPPER.regionToDto(animal.getRegion());
        Status_dto status_dto = RegionMapper.REGION_MAPPER.stattusToStatusDto(animal.getStatus());
        animalDto.setRegion_dto(region_dto);
        animalDto.setStatus(status_dto);
        return animalDto;
    }
}
