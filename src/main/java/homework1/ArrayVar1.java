package homework1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayVar1 {
    public static void main(String[] args) {
        int arrayLength = setArrayLengthAndValidation();
        Double[] array = new Double[arrayLength];
        initArray(array);
        System.out.println("Массив: " + Arrays.toString(array));
        System.out.println("Максимальное число массива: %s".formatted(getMax(array)));
        System.out.println("Минимальное число массива: %s".formatted(getMin(array)));
        System.out.println("Среднее значение: %s".formatted(getAvg(array)));
        System.out.println("Сортировка :" + Arrays.toString(sort(array)));
        System.out.println("Сортировка reverse :" + Arrays.toString(sortReverse(array)));
    }

    public static int setArrayLengthAndValidation() {
        int length = getValidInput("Введите размер массива (целое число больше 0): ", 0);
        System.out.printf("Вы указали длину массива: %s%n", length);
        return length;
    }

    public static void initArray(Double[] array) {
        Scanner scanner = new Scanner(System.in);
        int lower = 0;
        int upper = 1000;

        System.out.println("Указать границы генерации случайных чисел? да/нет:");
        String response = scanner.nextLine().toString().toLowerCase();
        if (response.equals("да")) {
            lower = getValidInput("Укажите нижнюю границу генерации: ", 0);
            upper = getValidInput("Укажите верхнюю границу генерации: ", 0);
        } else {
            System.out.println("Заполняем массив случайными значениями");
        }

        System.out.println("Заполнить массив доробными числами? да/нет:");
        String needDoubleValue = scanner.nextLine().toString().toLowerCase();
        if (needDoubleValue.equals("да")) {
            fillArrayDouble(array, lower, upper);
        } else {
            fillArrayInteger(array, lower, upper);
        }
    }

    public static int getValidInput(String msg, int minValue) {
        Scanner scanner = new Scanner(System.in);
        int value;
        while (true) {
            System.out.println(msg);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value >= minValue) {
                    return value;
                } else {
                    System.out.println("Значение должно быть больше " + minValue);
                }
            } else {
                System.out.println("Некорректный ввод. Введите целое число больше " + minValue);
            }
        }
    }

    public static void fillArrayDouble(Double[] array, int lower, int upper) {
        for (int i = 0; i < array.length; i++) {
            array[i] = randomDouble(lower, upper);
        }
    }

    public static void fillArrayInteger(Double[] array, int lower, int upper) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(randomInt(lower, upper).toString());
        }
    }


    public static double getMax(Double[] array) {
        double max = array[0];
        for (double el : array) {
            max = el > max ? el : max;
        }
        return max;
    }

    public static double getMin(Double[] array) {
        double min = array[0];
        for (double el : array) {
            min = el < min ? el : min;
        }
        return min;
    }

    public static Double[] sort(Double[] array) {
        Arrays.sort(array);
        return array;
    }

    public static Double[] sortReverse(Double[] array) {
        Arrays.sort(array, Collections.reverseOrder());
        return array;
    }

    public static double getAvg(Double[] array) {
        double sum = 0;
        for (double el : array) {
            sum = sum + el;
        }
        return sum / array.length;
    }

    public static Double randomDouble(int min, int max) {
        return Math.random() * (max - min) + min;
    }

    public static Integer randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
