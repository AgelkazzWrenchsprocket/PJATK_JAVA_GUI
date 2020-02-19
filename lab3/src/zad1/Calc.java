package zad1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

class Calc {
    private CalcOperation add = (a, b) -> (a.add(b)).stripTrailingZeros();
    private CalcOperation subtract = (a, b) -> (a.subtract(b)).stripTrailingZeros();
    private CalcOperation multiply = (a, b) -> (a.multiply(b)).stripTrailingZeros();
    private CalcOperation divide = (a, b) -> (a.divide(b, 7, RoundingMode.HALF_UP)).stripTrailingZeros();
    private CalcOperation exponentiation = (a, b) -> (a.pow(b.intValue()));

    String doCalc(String cmd) throws IndexOutOfBoundsException {
        String input[] = cmd.split("\\s+");
        Map<String, BigDecimal> operation = new HashMap<>();

        try {
            BigDecimal a = new BigDecimal(input[0]);
            BigDecimal b = new BigDecimal(input[2]);
            operation.put("+", add.operate(a, b));
            operation.put("-", subtract.operate(a, b));
            operation.put("*", multiply.operate(a, b));
            operation.put("/", divide.operate(a, b));
            operation.put("^", exponentiation.operate(a, b));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Invalid command to calc");
        }
        return operation.get(input[1]).toString();
    }

    @FunctionalInterface
    interface CalcOperation {
        BigDecimal operate(BigDecimal a, BigDecimal b);
    }
}