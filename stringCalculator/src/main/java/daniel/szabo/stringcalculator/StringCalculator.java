package daniel.szabo.stringcalculator;

public class StringCalculator {

    public int add(String numbers) {
        if(numbers.isEmpty()) return 0;
        String[] splitNumbers = numbers.split(",");
        if(splitNumbers.length == 1) {
            return Integer.parseInt(splitNumbers[0]);
        }
        int firstNumber = Integer.parseInt(splitNumbers[0]);
        int secondNumber = Integer.parseInt(splitNumbers[1]);
        return firstNumber + secondNumber;
    }
}
