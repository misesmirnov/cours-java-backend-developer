package homework3;

import homework3.contract.IEngine;
import homework3.type.FuelType;

public class FuelEngine implements IEngine {
    FuelType fuelType;
    Integer power;
    boolean isRunning;

    public FuelEngine(FuelType fuelType, boolean isRunning, Integer power) {
        this.fuelType = fuelType;
        this.isRunning = isRunning;
        this.power = power;
    }

    @Override
    public void start() {
        isRunning = true;
        System.out.println("Двигатель внутреннего сгорания Запущен");
    }

    @Override
    public void stop() {
        isRunning = false;
        System.out.println("Двигатель внутреннего сгорания Остановлен");
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public Integer getPower() {
        return power;
    }

}
