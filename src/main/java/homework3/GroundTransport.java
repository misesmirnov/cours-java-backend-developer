package homework3;

import homework3.type.TransportModel;

public sealed abstract class GroundTransport extends Transport permits Bicycle, Car {
    protected Integer numberOfWheels;

    public GroundTransport(Integer maxSpeed, TransportModel model, Integer numberOfWheels) {
        super(maxSpeed, model);
        this.numberOfWheels = numberOfWheels;
    }

    public Integer getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(Integer numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }
}
