package homework3;

import homework3.contract.IEngine;
import homework3.contract.IPassengerTransport;
import homework3.type.CarBodyType;
import homework3.type.ComfortClassType;
import homework3.type.TransportModel;

public final class TaxiCar extends Car implements IPassengerTransport {
    private final Integer passengerSeat;
    private final ComfortClassType comfortClassType;
    private final IEngine engine;
    private Integer currentPassengers;

    public TaxiCar(Integer maxSpeed,
                   TransportModel model,
                   Integer numberOfWheels,
                   CarBodyType carBodyType,
                   Integer doorCount,
                   String vinNumber,
                   ComfortClassType comfortClassType,
                   Integer passengerSeat,
                   IEngine engine) {
        super(maxSpeed, model, numberOfWheels, carBodyType, doorCount, vinNumber);
        this.comfortClassType = comfortClassType;
        this.passengerSeat = passengerSeat;
        this.engine = engine;
        this.currentPassengers = 0;
    }

    @Override
    public String getInfo() {
        return "\nАвтомобиль Такси " + comfortClassType + " класса. " +
                "\nНа " + passengerSeat + " Пассажирских мест " +
                "\nЗанято " + currentPassengers + " мест " +
                "\nМодель авто:" + getModel().name() +
                "\nМаксимальна скорость: " + getMaxSpeed() +
                "\nКол-во колес: " + getNumberOfWheels() +
                "\nVIN : " + getVinNumber() +
                "\nКол-во дверей: " + getDoorCount() +
                "\nТип кузова: " + getCarBodyType().name() +
                "\nДвигатель: " + (engine.isRunning() ? "запущен" : "остановлен") +
                ", мощность: " + engine.getPower() + " л.с.";
    }

    @Override
    public void move() {
        if (!engine.isRunning()) {
            engine.start();
        }
        System.out.println("Такси едет");
    }

    @Override
    public void stop() {
        if (engine.isRunning()) {
            engine.stop();
        }
        System.out.println("Такси остановлено");
    }

    public ComfortClassType getComfortClassType() {
        return comfortClassType;
    }

    public IEngine getEngine() {
        return engine;
    }

    public Integer getPassengerSeat() {
        return passengerSeat;
    }

    @Override
    public boolean boardPassenger() {
        if (currentPassengers < passengerSeat) {
            currentPassengers++;
            System.out.println("Пассажир вошел в такси. Теперь пассажиров: " + currentPassengers + "/" + passengerSeat);
            return true;
        } else {
            System.out.println("Нет свободных мест! Мест: " + passengerSeat + ", уже занято: " + currentPassengers);
            return false;
        }
    }
}
