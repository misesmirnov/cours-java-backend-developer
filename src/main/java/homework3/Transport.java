package homework3;

import homework3.type.TransportModel;

public abstract class Transport {
    protected TransportModel model;
    protected Integer maxSpeed;

    public Transport(Integer maxSpeed, TransportModel model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public abstract String getInfo();

    public abstract void move();

    public abstract void stop();

    public Integer getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Integer maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public TransportModel getModel() {
        return model;
    }

    public void setModel(TransportModel model) {
        this.model = model;
    }
}
