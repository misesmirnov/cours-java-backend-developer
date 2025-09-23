package homework3;

import homework3.contract.ILoadable;
import homework3.type.TransportModel;

public class Ship extends WaterTransport implements ILoadable {
    private boolean isLoaded;

    public Ship(Integer maxSpeed,
                TransportModel model,
                Integer draught) {
        super(maxSpeed, model, draught);
        this.isLoaded = false;
    }

    @Override
    public String getInfo() {
        return "\nКорабль " +
                "\nВодоизмещение " + getDraught() +
                "\nМодель судна: " + getModel().name() +
                "\nМаксимальна скорость: " + getMaxSpeed();
    }

    @Override
    public void move() {
        System.out.println("Корабль плывет");
    }

    @Override
    public void stop() {
        System.out.println("Корабль встал на якорь");
    }

    @Override
    public void loadCargo() {
        if (isLoaded) {
            System.out.println("Загрузка не удалась. Корабль уже загружен");
        } else {
            this.isLoaded = true;
            System.out.println("Корабль успешно загружен");
        }

    }

    @Override
    public void unloadCargo() {
        if (isLoaded) {
            this.isLoaded = false;
            System.out.println("Корабль успешно разгружен");
        } else {
            System.out.println("Нечего разгружать. Корабль пустой");
        }
    }
}
