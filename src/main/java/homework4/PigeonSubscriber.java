package homework4;

public class PigeonSubscriber implements Observer {
    private String pigeonName;

    public PigeonSubscriber(String pigeonName) {
        this.pigeonName = pigeonName;
    }

    public String getPigeonName() {
        return pigeonName;
    }

    public void setPigeonName(String pigeonName) {
        this.pigeonName = pigeonName;
    }

    @Override
    public void update(String operationType, String resultString) {
        System.out.println("\nОтправка сообщения Голубем: " + pigeonName);
        System.out.println("Для отслеживаемой строки применена операция: " + operationType);
        System.out.println("Строка после изменений: " + resultString);
    }
}
