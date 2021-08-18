package automobiles.model.entities;

import automobiles.model.entities.enumerations.CarType;
import automobiles.model.entities.enumerations.EngineType;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "models")
public class ModelEntity extends BaseEntity {
    private String name;
    private Integer year;
    private EngineType engine;
    private CarType carType;

    public ModelEntity() {
    }

    public ModelEntity(String name, Integer year, EngineType engine, CarType carType) {
        this.name = name;
        this.year = year;
        this.engine = engine;
        this.carType = carType;
    }

    @NotNull
    @Column(nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Min(1672)
    @Column(nullable = false)
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @NotNull
    @Enumerated
    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    @NotNull
    @Enumerated(EnumType.STRING)
    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
