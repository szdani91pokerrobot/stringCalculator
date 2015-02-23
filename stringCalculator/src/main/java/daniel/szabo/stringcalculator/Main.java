package daniel.szabo.stringcalculator;

public class Main {
    
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        System.out.println(calculator.add(""));
        System.out.println(calculator.add("1"));
        System.out.println(calculator.add("14"));
        System.out.println(calculator.add("14,8"));
        System.out.println(calculator.add("14,8,2,9,0"));
    }
}
