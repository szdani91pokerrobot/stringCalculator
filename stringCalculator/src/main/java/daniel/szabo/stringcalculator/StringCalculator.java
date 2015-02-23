package daniel.szabo.stringcalculator;

import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_SEPARATOR = ",";

    public int add(String numbers) {
        if(numbers.isEmpty()) return 0;
        String separator = getSeparator(numbers);
        String[] splitNumbers = numbers.split(Pattern.quote(separator));
        if(splitNumbers.length == 1) {
            return Integer.parseInt(splitNumbers[0]);
        }
        int sum = 0;
        for (String number : splitNumbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private String getSeparator(String incomingString) {
        String separator = "";
        Boolean isThereANewSeparator = false;
        for (int i = 0; i < incomingString.length(); i++) {
            if(!Character.isDigit(incomingString.charAt(i))) {
                separator += incomingString.charAt(i);
                isThereANewSeparator = true;
            }
            if(Character.isDigit(incomingString.charAt(i)) && isThereANewSeparator) {
                break;
            }
        }
        if(separator.isEmpty()) {
            return DEFAULT_SEPARATOR;
        } else {
            return separator;
        }
    }
}
