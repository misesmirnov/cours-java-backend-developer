package homework3;

import homework3.contract.ILoadable;
import homework3.type.TransportModel;

public class CargoPlane extends AirTransport implements ILoadable {
    private boolean isLoaded;

    public CargoPlane(Integer maxSpeed,
                      TransportModel model,
                      Integer maxFlightAltitude) {
        super(maxSpeed, model, maxFlightAltitude);
    }

    @Override
    public String getInfo() {
        return "\nГрузовой самолет: " +
                "\nМодель самолета:" + getModel().name() +
                "\nМаксимальна скорость: " + getMaxSpeed() +
                "\nМаксимальная высота полета: " + getMaxFlightAltitude();
    }

    @Override
    public void move() {
        System.out.println("Самолет летит");
    }

    @Override
    public void stop() {
        System.out.println("Самолет приземлился");
    }

    @Override
    public void loadCargo() {
        if (isLoaded) {
            System.out.println("Загрузка не удалась. Самолет уже загружен");
        } else {
            this.isLoaded = true;
            System.out.println("Самолет успешно загружен");
        }
    }

    @Override
    public void unloadCargo() {
        if (isLoaded) {
            this.isLoaded = false;
            System.out.println("Самолет успешно разгружен");
        } else {
            System.out.println("Нечего разгружать. Самолет уже пустой");
        }
    }
}
