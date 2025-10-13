package homework2;

import java.util.Scanner;

public class CalculationApp {
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
            String expression = scanner.nextLine().trim().toLowerCase();
            //Проверка на команды выхода
            if (expression.equals(EXIT)) {
                System.out.println("Выход...");
                break;
            }
            //Создаем парсер
            Parser parser = new Parser(expression);
            //проверка полученного выражения
            Validator validator = new Validator(parser.getPart());
            try {
                validator.validateExpression();
            } catch (ValidationException e) {
                System.out.println(e.getMessage());
                continue;
            }

            //Если все проверки прошли, то создаем калькулятор
            Calculator calculator = new Calculator(parser.getFirstOperand(),
                    parser.getSecondOperand(),
                    parser.getOperator());
            double result = calculator.calculate();
            if (!Double.isNaN(result)) {
                //если вернули корректный результат, то печатаем его в консоль
                System.out.println("Результат: " + result);
            }
        }
    }
}
