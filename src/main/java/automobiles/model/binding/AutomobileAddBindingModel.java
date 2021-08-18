package automobiles.model.binding;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class AutomobileAddBindingModel {
    private Integer engineCapacity;
    private String registrationNumber;
    private String colour;
    private Integer horsePower;
    private String ownerFirstName;
    private String ownerMiddleName;
    private String ownerLastName;
    private String maker;
    private String model;

    public AutomobileAddBindingModel() {
    }

    @Positive
    @NotBlank
    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    @Pattern(regexp = "^[A-Z]{1,2}[0-9]{4}[A-Z]{2}$")
    @NotBlank
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @NotBlank
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Positive
    @NotBlank
    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    @NotBlank
    public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    @NotBlank
    public String getOwnerMiddleName() {
        return ownerMiddleName;
    }

    public void setOwnerMiddleName(String ownerMiddleName) {
        this.ownerMiddleName = ownerMiddleName;
    }

    @NotBlank
    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    @NotBlank
    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
    @NotBlank
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
