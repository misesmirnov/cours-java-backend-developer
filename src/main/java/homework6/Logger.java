package homework6;

public class Logger implements Observer {

    @Override
    public void update(String message) {
        System.out.printf("INFO: %s%n", message);
    }
}
