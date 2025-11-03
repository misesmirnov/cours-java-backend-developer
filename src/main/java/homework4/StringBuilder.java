package homework4;

import java.util.ArrayList;
import java.util.List;

public class StringBuilder implements Subject {

    private String operationType;
    private List<Observer> observers;
    private java.lang.StringBuilder stringBuilder;


    public StringBuilder(java.lang.StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        this.observers = new ArrayList<>();
    }

    public java.lang.StringBuilder getStringBuilder() {
        return stringBuilder;
    }

    public void setStringBuilder(java.lang.StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    @Override
    public void registerObserver(Observer o) {
        System.out.println("\nдобавляем подписчика: " + o.toString());
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        System.out.println("\nУдаляем подписчика: " + o.toString());
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        System.out.println("\nУведомляем подписчиков о изменениях отслеживаемого объекта");
        observers.forEach(x -> x.update(operationType, stringBuilder.toString()));
    }

    public void append(String part) {
        stringBuilder.append(part);
        this.operationType = "append";
        notifyObservers();
    }

    public void insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        this.operationType = "insert";
        notifyObservers();
    }

    public void replace(int start, int end, String str) {
        stringBuilder.replace(start, end, str);
        this.operationType = "replace";
        notifyObservers();
    }

    public void delete(int start, int end) {
        stringBuilder.delete(start, end);
        this.operationType = "delete";
        notifyObservers();
    }
}
