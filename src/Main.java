import java.time.LocalDate;

public class Main {

    public static boolean findingLeapYear() {
        int currentYear = LocalDate.now().getYear();
        return (currentYear % 4 == 0 && currentYear % 100 != 0 || currentYear % 400 == 0);
    }

    public static int findingTypeOfOs() {
        int clientOs = 0;
        if (clientOs == 0) {
            return 0;
        } else if (clientOs == 1) {
            return 1;
        }
        return clientOs;
    }

    public static int findingClientDeviceYear() {
        int clientDeviceYear = 2020;
        return clientDeviceYear;
    }

    public static int findingDeliveryTimeForBankCard() {
        int deliveryDistance = 95;
        int deliveryTime = 1;

        if (deliveryDistance > 20) {
            deliveryTime++;
        }

        if (deliveryDistance > 60) {
            deliveryTime++;
        }
        return deliveryTime;
    }


    public static void main(String[] args) {
        objective1();
        objective2();
        objective3();
        System.out.printf("Средняя сумма трат за месяц составила %s рублей", averageSumSpentDuringMonth());
    }

    public static void objective1() {
        boolean leapYear = findingLeapYear();
        int currentYear = LocalDate.now().getYear();
        if (leapYear) {
            System.out.println(currentYear + " год високосный");
        } else {
            System.out.println(currentYear + " год не високосный");
        }
    }

    public static void objective2() {
        int clientOs = findingTypeOfOs();
        int clientDeviceYear = findingClientDeviceYear();
        int currentYear = LocalDate.now().getYear();
        if (clientOs == 0 && clientDeviceYear >= currentYear) {
            System.out.println("Установите версию приложения для iOS по ссылке");
        } else if (clientOs == 0 && clientDeviceYear < currentYear) {
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        }
        if (clientOs == 1 && clientDeviceYear >= currentYear) {
            System.out.println("Установите версию приложения для Android по ссылке");
        } else if (clientOs == 1 && clientDeviceYear < currentYear) {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        }
        if (clientOs != 0 && clientOs != 1) {
            System.out.println("Неизвестная ОС");
        }

    }

    public static void objective3() {
        int deliveryTime = findingDeliveryTimeForBankCard();
        System.out.println("Потребуется дней " + deliveryTime);

    }
//    Доп задание по методам
//    Снова вспоминаем домашнее задание по массивам. В нем была задача, которая требовала высчитать среднюю выплату за день.
//    Был дан сгенерированный массив из 30 значений от 100 до 200 тысяч, для его генерации допускается использовать метод из прошлого домашнего задания.
//    Нам нужно понять, какую в среднем сумму наша компания тратила в течение данных 30 дней.
//    Нужно написать программу, которая посчитает среднее значение трат за месяц (то есть сумму всех трат за месяц поделить на количество дней), и вывести в консоль результат в формате: «Средняя сумма трат за месяц составила … рублей».
//            Важно помнить: подсчет среднего значения может иметь остаток (то есть быть не целым, а дробным числом).
//    Нужно сгенерировать массив, подать его в наш метод, а внутри метода подсчитать сумму элементов и вычислить среднее значение, которое нужно вернуть из метода в виде результата.
//    Сложность в том, что метод нужно не просто написать, но еще и декомпозировать.
//    То есть для работы этого метода нужно будет создать еще методы (1 или более), которые его будут обслуживать и вычислять промежуточные результаты. Среднее значение нужно вычислять в дробном виде, так как результат должен быть точным.
//    Критерии оценки
//– Методы декомпозированы корректно.
//– Программа выводит корректный результат при изменении значений массива.
    public static int spendedSumDuringMonth() {
        int totalSumSpent = 0;
        int[] arr = generateRandomArray();
        for (int daySpending : arr) {
            totalSumSpent = totalSumSpent + daySpending;
        }
        return totalSumSpent;
    }

    public static double averageSumSpentDuringMonth() {
        int totalSumSpent = spendedSumDuringMonth();
        double averageSum = (double) totalSumSpent / generateRandomArray().length;
        return averageSum;
    }

    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
}
