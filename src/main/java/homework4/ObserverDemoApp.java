package homework4;

public class ObserverDemoApp {
    public static void main(String[] args) {
        //Создадим отслеживаемый объект
        StringBuilder stringBuilder = new StringBuilder(new java.lang.StringBuilder());

        //Создаем подписчиков
        Observer subscriber1 = new EmailSubscriber("123123123@ya.ru");
        Observer subscriber2 = new PhoneSubscriber("+79123647722");
        Observer subscriber3 = new PigeonSubscriber("WorldPigeon");

        //регистрируем подписчиков
        stringBuilder.registerObserver(subscriber1);
        stringBuilder.registerObserver(subscriber2);
        stringBuilder.registerObserver(subscriber3);

        //добавление строки
        stringBuilder.append("Привет как дела с паттерном OBSERVER");

        //Вставка
        stringBuilder.insert(7, "ТВОИ");

        //Удаляем подписчика
        stringBuilder.removeObserver(subscriber2);

        //Замена подстроки
        stringBuilder.replace(11, 15, "Успехи");

        //Удаляем подписчика
        stringBuilder.removeObserver(subscriber1);

        stringBuilder.delete(20, 25);
    }
}
