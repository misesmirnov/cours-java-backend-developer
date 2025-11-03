package homework3;

import homework3.contract.ILoadable;
import homework3.type.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---Транспорт симулятор---");
        List<Transport> transports = createTransport();

        System.out.println("Список доступных команд:" +
                "\n1 - Получить информацию о всем транспорте" +
                "\n2 - Привести транспорт в движение" +
                "\n3 - Остановить транспорт" +
                "\n4 - Загрузить грузовой транспорт" +
                "\n5 - Разгрузить грузовой транспорт" +
                "\n0 - ВЫХОД");

        while (true) {
            System.out.println("\nВведите команду: ");
            int command = scanner.nextInt();
            if (command == 0)
                break;
            switch (command) {
                case 1 -> transports.forEach(t -> System.out.println(t.getInfo()));
                case 2 -> transports.forEach(Transport::move);
                case 3 -> transports.forEach(Transport::stop);
                case 4 -> transports.stream()
                        .filter(ILoadable.class::isInstance)
                        .map(ILoadable.class::cast)
                        .forEach(ILoadable::loadCargo);
                case 5 -> transports.stream()
                        .filter(ILoadable.class::isInstance)
                        .map(ILoadable.class::cast)
                        .forEach(ILoadable::unloadCargo);
                default -> System.out.println("Неизвестный тип команды");
            }
        }
    }

    public static List<Transport> createTransport() {
        System.out.println("***Создаем транспорт различных видов***");
        List<Transport> transports = new ArrayList<>();
        System.out.println("Транспорт с типом Такси");
        TaxiCar taxi1 = new TaxiCar(120,
                TransportModel.TOYOTA_CAMRY,
                4,
                CarBodyType.SEDAN,
                4,
                "43333-232323-2323",
                ComfortClassType.E,
                4,
                new FuelEngine(FuelType.PETROL, false, 250)
        );
        transports.add(taxi1);

        System.out.println("Транспорт с типом Такси");
        TaxiCar taxi2 = new TaxiCar(220,
                TransportModel.TESLA,
                4,
                CarBodyType.SEDAN,
                4,
                "432222-2323111123-23231111111",
                ComfortClassType.B,
                4,
                new ElectricEngine(BatteryType.LITHIUM_ION, false, 750)
        );
        transports.add(taxi2);

        System.out.println("Транспорт с типом Спорткар");
        SportCar sportCar = new SportCar(220,
                TransportModel.MACLAREN,
                4,
                CarBodyType.COUPE,
                2,
                "Отсутствует",
                true,
                new FuelEngine(FuelType.PETROL, false, 1000)
        );
        transports.add(sportCar);

        System.out.println("Транспорт с типом Велосипед");
        Bicycle bicycle = new Bicycle(40,
                TransportModel.TREK,
                2,
                16);
        transports.add(bicycle);

        System.out.println("Транспорт с типом Корабль");
        Ship ship = new Ship(55,
                TransportModel.MAERSK,
                15);
        transports.add(ship);

        System.out.println("Транспорт с типом Грузовой Самолет");
        CargoPlane cargoPlane = new CargoPlane(500,
                TransportModel.AIRBUS_A320,
                10000);
        transports.add(cargoPlane);

        return transports;
    }
}
