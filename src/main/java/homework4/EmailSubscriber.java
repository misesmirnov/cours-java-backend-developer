package homework4;

public class EmailSubscriber implements Observer {
    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void update(String operationType, String resultString) {
        System.out.println("\nОтправка сообщения на email: " + email);
        System.out.println("Для отслеживаемой строки применена операция: " + operationType);
        System.out.println("Строка после изменений: " + resultString);
    }
}
