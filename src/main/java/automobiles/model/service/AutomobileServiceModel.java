package automobiles.model.service;

public class AutomobileServiceModel {
    private Integer engineCapacity;
    private String registrationNumber;
    private String colour;
    private Integer horsePower;
    private UserServiceModel owner;
    private MakerServiceModel maker;
    private ModelServiceModel model;

    public AutomobileServiceModel() {
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Integer engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public UserServiceModel getOwner() {
        return owner;
    }

    public void setOwner(UserServiceModel owner) {
        this.owner = owner;
    }

    public MakerServiceModel getMaker() {
        return maker;
    }

    public void setMaker(MakerServiceModel maker) {
        this.maker = maker;
    }

    public ModelServiceModel getModel() {
        return model;
    }

    public void setModel(ModelServiceModel model) {
        this.model = model;
    }
}
