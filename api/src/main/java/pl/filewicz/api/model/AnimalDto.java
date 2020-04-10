package pl.filewicz.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnimalDto {

    private String name;
    private REGION_DTO  region_dto;
    private boolean isWilde;

    public AnimalDto(String name, REGION_DTO region_dto, boolean isWilde) {
        this.name = name;
        this.region_dto = region_dto;
        this.isWilde = isWilde;
    }

}
