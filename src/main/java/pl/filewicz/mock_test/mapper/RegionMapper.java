package pl.filewicz.mock_test.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;
import org.mapstruct.factory.Mappers;
import pl.filewicz.mock_test.model.Region;
import pl.filewicz.mock_test.model.Region_dto;
import pl.filewicz.mock_test.model.Status;
import pl.filewicz.mock_test.model.Status_dto;

@Mapper

public interface RegionMapper {


    RegionMapper REGION_MAPPER = Mappers.getMapper(RegionMapper.class);


    @ValueMappings({
            @ValueMapping(source = "ASIA", target = "AZJA"),
            @ValueMapping(source = "AFRICA", target = "AFRYKA"),
            @ValueMapping(source = "EUROPE", target = "EUROPA"),
            @ValueMapping(source = "AMERICA", target = "AMERYKA"),
            @ValueMapping(source = "AUSTRALIA", target = "AUSTRALIA")
    })
    Region_dto regionToDto(Region region);


    @ValueMappings({
            @ValueMapping(source = "ZŁAPANY",target = "KLATKA"),
            @ValueMapping(source = "PRZYJETY_DO_ZOO",target = "WZIELI"),
            @ValueMapping(source = "ODRZUCONY_PREZ_ZOO",target = "NIE_WZIELI")
    })
    Status_dto stattusToStatusDto(Status status);

}
