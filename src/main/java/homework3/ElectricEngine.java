package homework3;

import homework3.contract.IEngine;
import homework3.type.BatteryType;

public class ElectricEngine implements IEngine {
    BatteryType batteryType;
    Integer power;
    boolean isRunning;

    public ElectricEngine(BatteryType batteryType, boolean isRunning, Integer power) {
        this.batteryType = batteryType;
        this.isRunning = isRunning;
        this.power = power;
    }

    @Override
    public void start() {
        isRunning = true;
        System.out.println("Электродвигатель запущен");
    }

    @Override
    public void stop() {
        isRunning = false;
        System.out.println("Электродвигатель Остановлен");
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
