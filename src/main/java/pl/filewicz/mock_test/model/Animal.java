package pl.filewicz.mock_test.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Region region;
    private boolean isWild;
    private String decription;
    private Status status;

    public Animal(String name, Region region, boolean isWild, String decription) {
        this.name = name;
        this.region = region;
        this.isWild = isWild;
        this.decription = decription;
    }
}
