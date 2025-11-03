package homework3;

import homework3.type.CarBodyType;
import homework3.type.TransportModel;

public sealed abstract class Car extends GroundTransport permits TaxiCar, SportCar {
    protected String vinNumber;
    protected Integer doorCount;
    protected CarBodyType carBodyType;

    public Car(Integer maxSpeed, TransportModel model, Integer numberOfWheels, CarBodyType carBodyType, Integer doorCount, String vinNumber) {
        super(maxSpeed, model, numberOfWheels);
        this.carBodyType = carBodyType;
        this.doorCount = doorCount;
        this.vinNumber = vinNumber;
    }

    public CarBodyType getCarBodyType() {
        return carBodyType;
    }

    public void setCarBodyType(CarBodyType carBodyType) {
        this.carBodyType = carBodyType;
    }

    public Integer getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(Integer doorCount) {
        this.doorCount = doorCount;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }
}
