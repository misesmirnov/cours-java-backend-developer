package homework4;

public class PhoneSubscriber implements Observer {
    private String phone;

    public PhoneSubscriber(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void update(String operationType, String resultString) {
        System.out.println("\nОтправка сообщения на Телефон: " + phone);
        System.out.println("Для отслеживаемой строки применена операция: " + operationType);
        System.out.println("Строка после изменений: " + resultString);
    }
}
