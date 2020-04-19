package pl.filewicz.mock_test.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;
import org.mapstruct.factory.Mappers;
import pl.filewicz.mock_test.model.Region;
import pl.filewicz.mock_test.model.Region_dto;

@Mapper

public interface RegionMapper {


    RegionMapper REGION_MAPPER = Mappers.getMapper(RegionMapper.class);


    @ValueMappings({
            @ValueMapping(source = "ASIA", target = "ASIA"),
            @ValueMapping(source = "AFRICA", target = "AFRICA"),
            @ValueMapping(source = "EUROPE", target = "EUROPE"),
            @ValueMapping(source = "AMERICA", target = "AMERICA"),
            @ValueMapping(source = "AUSTRALIA", target = "AUSTRALIA")
    })
    Region_dto regionToDto(Region region);

}
