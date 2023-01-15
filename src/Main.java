import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws CalcException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для выхода нажмите Enter");
        String expression = scanner.nextLine();
        while (expression.length() > 0) {
            System.out.println(calc(expression));
            expression = scanner.nextLine();
        }
    }

    public static String calc(String input) throws CalcException {
        // строка разбивается пробелами на части, эти части записываются в массив parts[]
        String[] parts = input.split(" ");

        // проверка введённой строки на соответствие формату операции
        if (parts.length != 3) {
            throw new CalcException("строка не соответствует одной из операций: 'a + b', 'a - b', 'a * b', 'a / b'");
        }

        String a = parts[0];
        String operator = parts[1];
        String b = parts[2];

        // валидные операнды
        List<String> ArabOperands = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        List<String> RomanOperands = Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");

        Converter converter = new Converter();

        // если операнды арабские
        if (ArabOperands.contains(a) && ArabOperands.contains(b)) {
            return calculate(a, operator, b);
        }
        // если операнды римские
        else if (RomanOperands.contains(a) && RomanOperands.contains(b)) {
            String arabResult = calculate(converter.convertToArab(a), operator, converter.convertToArab(b));
            // если результат с римскимим меньше 1
            if (Integer.parseInt(arabResult) < 0) {
                throw new CalcException("в римской системе нет отрицательных чисел");
            }
            else {
                return converter.convertToRoman(arabResult) ;
            }
        }
        // если операнды разных систем счислений
        else if ((ArabOperands.contains(a) || RomanOperands.contains(a)) &&
                (ArabOperands.contains(b) || RomanOperands.contains(b))) {
            throw new CalcException("одновременно используются разные системы счисления");
        }
        // если операнды невалидные
        else {
            throw new CalcException("используются неверные операнды");
        }

    }

    // выполнение операции
    static String calculate(String operand1, String operator, String operand2) throws CalcException {
        int a = Integer.parseInt(operand1);
        int b = Integer.parseInt(operand2);
        int result = switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new CalcException("строка не является допустимой математической операцией");
        };
        return Integer.toString(result);
    }
}
