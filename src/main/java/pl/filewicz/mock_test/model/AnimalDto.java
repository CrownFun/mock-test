package pl.filewicz.mock_test.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnimalDto {

    private String name;
    private Region_dto region_dto;
    private boolean isWilde;
    private Status status;

    public AnimalDto(String name, Region_dto region_dto, boolean isWilde) {
        this.name = name;
        this.region_dto = region_dto;
        this.isWilde = isWilde;
    }
}
