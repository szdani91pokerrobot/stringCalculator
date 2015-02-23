package daniel.szabo.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_SEPARATOR = ",";
    private static final List<String> ignoredStrings = new ArrayList<>();

    static {
        ignoredStrings.add("-");
    }

    public int add(String numbers) throws Exception {
        if (numbers.isEmpty()) return 0;
        Boolean hasNegativeNumbers = numbers.contains("-");
        if (hasNegativeNumbers) {
            List<Integer> negativeNumbers = getNegativeNumbersFromString(numbers, getSeparator(numbers));
            String message = createNegativeNumbersExceptionMessage(negativeNumbers);
            throw new Exception(message);
        }
        String separator = getSeparator(numbers);
        String[] splitNumbers = numbers.split(Pattern.quote(separator));
        int sum = 0;
        try {
            for (String number : splitNumbers) {
                sum += Integer.parseInt(number);
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            return sum;
        }
        return sum;
    }

    private String createNegativeNumbersExceptionMessage(List<Integer> negativeNumbers) {
        String exceptionMessage = "Negatives not allowed: ";
        for (Integer negativeNumber : negativeNumbers) {
            exceptionMessage += negativeNumber + ", ";
        }
        //remove trailing comma
        return exceptionMessage.substring(exceptionMessage.length() - 2, exceptionMessage.length()).equals(", ") ? exceptionMessage.substring(0, exceptionMessage.length() - 2) : exceptionMessage;
    }

    private List<Integer> getNegativeNumbersFromString(String numbers, String separator) {
        String[] splitNumbers = numbers.split(Pattern.quote(separator));
        List<Integer> negativeNumbers = new ArrayList<>();
        for (String splitNumber : splitNumbers) {
            Integer parsedNumber = Integer.valueOf(splitNumber);
            if (parsedNumber < 0) {
                negativeNumbers.add(parsedNumber);
            }
        }
        return negativeNumbers;
    }

    private String getSeparator(String incomingString) {
        String separator = "";
        Boolean isThereANewSeparator = false;
        for (int i = 0; i < incomingString.length(); i++) {
            if (!Character.isDigit(incomingString.charAt(i)) && isNotOnIgnoredList(incomingString.charAt(i))) {
                separator += incomingString.charAt(i);
                isThereANewSeparator = true;
            }
            if (Character.isDigit(incomingString.charAt(i)) && isThereANewSeparator) {
                break;
            }
        }
        if (separator.isEmpty()) {
            return DEFAULT_SEPARATOR;
        } else {
            return separator;
        }
    }

    private boolean isNotOnIgnoredList(char c) {
        for (String ignoredString : ignoredStrings) {
            if (ignoredString.equals(String.valueOf(c))) {
                return false;
            }
        }
        return true;
    }
}
