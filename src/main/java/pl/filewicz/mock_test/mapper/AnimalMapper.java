package pl.filewicz.mock_test.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.filewicz.mock_test.model.Animal;
import pl.filewicz.mock_test.model.AnimalDto;

@Mapper(uses = RegionMapper.class)
@DecoratedWith(AnimalMapperDecorator.class)
public interface AnimalMapper {

    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);
    AnimalDto animalToDto(Animal animal);


}
