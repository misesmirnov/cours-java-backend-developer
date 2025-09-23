package homework3;

import homework3.type.TransportModel;

public final class Bicycle extends GroundTransport {
    private final Integer gear;

    public Bicycle(Integer maxSpeed,
                   TransportModel model,
                   Integer numberOfWheels,
                   Integer gear) {
        super(maxSpeed, model, numberOfWheels);
        this.gear = gear;
    }

    @Override
    public String getInfo() {
        return "\nВелосипед " +
                "\nСкоростей " + gear +
                "\nМодель авто: " + getModel().name() +
                "\nМаксимальна скорость: " + getMaxSpeed() +
                "\nКол-во колес: " + getNumberOfWheels();
    }

    @Override
    public void move() {
        System.out.println("Велосипед едет");
    }

    @Override
    public void stop() {
        System.out.println("Велосипед остановлен");
    }

    public Integer getGear() {
        return gear;
    }
}
