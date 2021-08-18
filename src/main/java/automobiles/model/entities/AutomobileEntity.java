package automobiles.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

    @Column(name = "engine_capacity", nullable = false)
    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Column(name = "registration_number", nullable = false, unique = true)
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Column(nullable = false)
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Column(name = "horse_power", nullable = false)
    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }
}
