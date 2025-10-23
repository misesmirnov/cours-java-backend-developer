package homework3;

import homework3.contract.IEngine;
import homework3.type.CarBodyType;
import homework3.type.TransportModel;

public final class SportCar extends Car {
    boolean nitroAvailable;
    private final IEngine engine;

    public SportCar(Integer maxSpeed,
                    TransportModel model,
                    Integer numberOfWheels,
                    CarBodyType carBodyType,
                    Integer doorCount,
                    String vinNumber,
                    boolean nitroAvailable,
                    IEngine engine) {
        super(maxSpeed, model, numberOfWheels, carBodyType, doorCount, vinNumber);
        this.nitroAvailable = nitroAvailable;
        this.engine = engine;
    }

    @Override
    public String getInfo() {
        return "\nСпортивный автомобиль " +
                "\nМодель: " + getModel().name() +
                "\nМаксимальна скорость: " + getMaxSpeed() +
                "\nРежим Нитро: " + (nitroAvailable ? "доступен" : "не доступен") +
                "\nДвигатель: " + (engine.isRunning() ? "запущен" : "остановлен") +
                ", мощность: " + engine.getPower() + " л.с.";
    }

    @Override
    public void move() {
        if (!engine.isRunning()) {
            engine.start();
        }
        System.out.println("Спорткар едет");
    }

    @Override
    public void stop() {
        if (engine.isRunning()) {
            engine.stop();
        }
        System.out.println("Спорткар остановлен");
    }

    public boolean isNitroAvailable() {
        return nitroAvailable;
    }

    public void setNitroAvailable(boolean nitroAvailable) {
        this.nitroAvailable = nitroAvailable;
    }

    public IEngine getEngine() {
        return engine;
    }
}
