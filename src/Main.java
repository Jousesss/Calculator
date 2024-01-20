import java.util.Scanner;


public class Main {

    public static void main (String[] args) throws JousesssException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n/////   Калькулятор   /////\n\n--- Правила:" +
                "\n1. В строку нельзя писать буквы" +
                "\n2. Числа могут быть только от 1 до 10 (и только целые)" +
                "\n3. Между числами должен стоять один из операторов (+, -, *, /)" +
                "\n4. Между числами и оператором должен быть пробел (Например: 6 + 10 )" +
                "\n\n* При несоблюдении любого из правил появится ошибка и программа завершит свою работу :)");

        while (true) {
            System.out.println("\n\n--- Введите пример: ");

            String userInput = scanner.nextLine();
            String answer = Calc(userInput);

            if (answer != null) {
                System.out.println("--- Ответ: " + answer);
            } else {
                throw new JousesssException("Неизвестная ошибка ;(");  // На случай если вдруг каким-то магическим образом метод calc вернёт null
            }
        }
    }


    public static String Calc (String input) throws JousesssException {

        String[] parts = input.split(" ");

        int firstNumber;
        int secondNumber;
        String result;

        if (parts.length == 3) {
            try {
                firstNumber = Integer.parseInt(parts[0]);
                secondNumber = Integer.parseInt(parts[2]);
            } catch (Exception e) {
                throw new JousesssException("На месте цифр нельзя писать буквы или дробные числа!");
            }

            if ((firstNumber < 1 || firstNumber > 10) || (secondNumber < 1 || secondNumber > 10)) {
                throw new JousesssException("Цифры могут быть только от 1 до 10!");
            }

            switch (parts[1]) {
                case "-":
                    result = String.valueOf(firstNumber - secondNumber);
                    break;
                case "+":
                    result = String.valueOf(firstNumber + secondNumber);
                    break;
                case "*":
                    result = String.valueOf(firstNumber * secondNumber);
                    break;
                case "/":
                    result = String.valueOf(firstNumber / secondNumber);
                    break;
                default:
                    throw new JousesssException("Между числами должен быть один из операторов: -, +, *, /");
            }

            return result;

        } else if (parts.length < 3) {
            throw new JousesssException("Строка не является математической операцией, либо нужно поставить пробелы)!");
        } else if (parts.length > 3) {
            throw new JousesssException("В строке должны быть 2 числа и один оператор, не более!");
        }

        return null;
    }

}
