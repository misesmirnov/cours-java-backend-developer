package homework1;

import java.util.Scanner;

public class CalcVar2 {
    public static String EXIT = "exit";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Калькулятор");
        System.out.println("""
                Может выполнять следующие операции:
                Сложение ( + )
                Вычитание ( - )
                Умножение ( * )
                Деление ( / )
                exit для выхода
                """);

        while (true) {
            System.out.println("Введите выражение в формате а + b или команду exit:");
            if (scanner.hasNextLine()) {
                //Если передали строку, то переходим к разбору выражения
                String expression = scanner.nextLine().trim().toLowerCase();
                if (expression.equals(EXIT)) {
                    //если передали exit. Заканчиваем работу калькулятора
                    System.out.println("Выход...");
                    break;
                } else {
                    String[] part = expression.split(" ");
                    if (part.length == 3) {
                        //если кол-во аргументов 3, то переходим к разбору и парсингу подстрок в значения операндов
                        double a = Double.parseDouble(part[0]);
                        double b = Double.parseDouble(part[2]);
                        String operator = part[1];
                        //вызом метода с вычислением
                        double result = calculate(a, b, operator);
                        if (!Double.isNaN(result)) {
                            //если вернули корректный результат, то печатаем его в консоль
                            System.out.println("Результат: " + calculate(a, b, operator));
                        }
                    } else {
                        System.out.println("Ошибка выражения! Предайте выражение в формате а + b");
                    }
                }
            } else {
                //Если передали не строку сразу отдаем ошибку. К парсингу строки не приступаем.
                System.out.println("Ошибка формата! Предайте выражение в формате а + b или команду exit");
            }

        }
    }

    public static double calculate(double a, double b, String operator) {
        // вызов метода калькулятора в зависимости от оператора.
        return switch (operator) {
            case "+" -> sum(a, b);
            case "-" -> sub(a, b);
            case "*" -> multiplication(a, b);
            case "/" -> division(a, b);
            default -> {
                System.out.println("Неизвестный тип операции: " + operator);
                yield Double.NaN;
            }
        };
    }

    public static double sum(double a, double b) {
        return a + b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }

    public static double multiplication(double a, double b) {
        return a * b;
    }

    public static double division(double a, double b) {
        if (b == 0) {
            System.out.println("Деление на ноль");
            return Double.NaN;
        }
        return a / b;
    }
}
