package automobiles.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "automobiles")
public class AutomobileEntity extends BaseEntity {
    private UserEntity owner;
    private MakerEntity maker;
    private ModelEntity model;
    private Integer engineCapacity;
    private String registrationNumber;
    private String colour;
    private Integer horsePower;


    public AutomobileEntity() {
    }

    @ManyToOne
    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    @ManyToOne
    public MakerEntity getMaker() {
        return maker;
    }

    public void setMaker(MakerEntity maker) {
        this.maker = maker;
    }

    @ManyToOne
    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    @Positive
    @Column(name = "engine_capacity", nullable = false)
    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Pattern(regexp = "^[A-Z]{1,2}[0-9]{4}[A-Z]{2}$")
    @Column(name = "registration_number", nullable = false, unique = true)
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @NotBlank
    @Column(nullable = false)
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Positive
    @Column(name = "horse_power", nullable = false)
    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }
}
