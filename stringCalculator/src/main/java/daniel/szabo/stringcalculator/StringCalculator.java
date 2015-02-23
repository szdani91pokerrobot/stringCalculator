package daniel.szabo.stringcalculator;

public class StringCalculator {

    public int add(String numbers) {
        if(numbers.isEmpty()) return 0;
        String[] splitNumbers = numbers.split(",");
        if(splitNumbers.length == 1) {
            return Integer.parseInt(splitNumbers[0]);
        }
        int sum = 0;
        for (String number : splitNumbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
