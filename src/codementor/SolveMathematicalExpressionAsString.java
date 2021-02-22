package codementor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Challenge {
    private static final Character OPENING = '(';
    private static final Character CLOSING = ')';
    private static final Character ADDITION = '+';
    private static final Character SUBTRACTION = '-';
    private static final Character MULTIPLICATION = '*';
    private static final Character DIVISION = '/';
    private static final Set<Character> OPERATORS = Stream.of(ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION).collect(Collectors.toCollection(HashSet::new));

    private static Map<Character, Integer> OPERATOR_PRECEDENCE = new HashMap<Character, Integer>() {{
        put(OPENING, 0);
        put(CLOSING, 0);
        put(ADDITION, 1);
        put(SUBTRACTION, 1);
        put(MULTIPLICATION, 2);
        put(DIVISION, 2);
    }};
    
    public static double calc(String expression) {
        expression = expression.replaceAll(" ", "");
        Stack<Character> operators = new Stack<>();
        Stack<Double> values = new Stack<>();
        for (int pos = 0; pos < expression.length(); pos++) {
            Character currentChar = expression.charAt(pos);
            System.out.println("Current char: "+ currentChar);
            
            if (Character.isDigit(currentChar)) {
                System.out.println("It's digit: " + currentChar);
                Double value = new Double(0);
                while (pos < expression.length() && Character.isDigit(expression.charAt(pos))) {
                    value *= 10;
                    value += new Double(expression.charAt(pos)-'0');
                    pos++;
                }
                pos--;
                values.push(value);
            } else if (OPENING.equals(currentChar)) {
                System.out.println("It's Opening: " + currentChar);
                operators.push(OPENING);
            } else if (CLOSING.equals(currentChar)) {
                System.out.println("It's Closing: " + currentChar);
                while (!operators.isEmpty() && !OPENING.equals(operators.peek())) {
                    Character operator = operators.pop();
                    Double secondOperand = values.pop();
                    Double firstOperand = values.pop();
                    
                    Double result;
                    if (ADDITION.equals(operator)) {
                        result = new Double(firstOperand + secondOperand);
                        System.out.println("Result of " + firstOperand + " + " + secondOperand + " = " + result);
                    } else if (SUBTRACTION.equals(operator)) {
                        result = new Double(firstOperand - secondOperand);
                        System.out.println("Result of " + firstOperand + " - " + secondOperand + " = " + result);
                    } else if (MULTIPLICATION.equals(operator)) {
                        result = new Double(firstOperand * secondOperand);
                        System.out.println("Result of " + firstOperand + " * " + secondOperand + " = " + result);
                    } else {
                        result = new Double(firstOperand / secondOperand);
                        System.out.println("Result of " + firstOperand + " / " + secondOperand + " = " + result);
                    }
                    values.push(result);
                }
                if (!operators.isEmpty()) {
                    operators.pop();
                }
            } else if (OPERATORS.contains(currentChar)) {
                System.out.println("It's Operator: " + currentChar);
                while (!operators.isEmpty()
                        && OPERATOR_PRECEDENCE.get(operators.peek()) >= OPERATOR_PRECEDENCE.get(currentChar)) {
                    Character operator = operators.pop();
                    Double secondOperand = values.pop();
                    Double firstOperand = values.pop();
                    
                    Double result;
                    if (ADDITION.equals(operator)) {
                        result = new Double(firstOperand + secondOperand);
                        System.out.println("Result of " + firstOperand + " + " + secondOperand + " = " + result);
                    } else if (SUBTRACTION.equals(operator)) {
                        result = new Double(firstOperand - secondOperand);
                        System.out.println("Result of " + firstOperand + " - " + secondOperand + " = " + result);
                    } else if (MULTIPLICATION.equals(operator)) {
                        result = new Double(firstOperand * secondOperand);
                        System.out.println("Result of " + firstOperand + " * " + secondOperand + " = " + result);
                    } else {
                        result = new Double(firstOperand / secondOperand);
                        System.out.println("Result of " + firstOperand + " / " + secondOperand + " = " + result);
                    }
                    values.push(result);
                }
                operators.push(currentChar);
            }
        }
        while (!operators.isEmpty()) {
            Character operator = operators.pop();
            Double secondOperand = values.pop();
            Double firstOperand = values.pop();
            
            Double result;
            if (ADDITION.equals(operator)) {
                result = new Double(firstOperand + secondOperand);
                System.out.println("Result of " + firstOperand + " + " + secondOperand + " = " + result);
            } else if (SUBTRACTION.equals(operator)) {
                result = new Double(firstOperand - secondOperand);
                System.out.println("Result of " + firstOperand + " - " + secondOperand + " = " + result);
            } else if (MULTIPLICATION.equals(operator)) {
                result = new Double(firstOperand * secondOperand);
                System.out.println("Result of " + firstOperand + " * " + secondOperand + " = " + result);
            } else {
                result = new Double(firstOperand / secondOperand);
                System.out.println("Result of " + firstOperand + " / " + secondOperand + " = " + result);
            }
            values.push(result);
        }
        return values.pop();
    }
    
    public static void main(String[] args) {
        System.out.println(calc("1+1"));
    }
}
