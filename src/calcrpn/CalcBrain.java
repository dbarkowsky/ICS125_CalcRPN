package calcrpn;

import java.util.Stack;

public class CalcBrain implements CalcRPNOperations {

    Stack<Float> results;
    String operand;
    
    
    public CalcBrain() {
        results = new Stack<>();
        operand = "";
    }
    
    @Override
    public String digit(String digit) {
        operand += digit;
        return digit;
    }

    @Override
    public String operator(String op) {
        
        return null;
    }

    @Override
    public String clearEntry() {
        operand = "";
        return "\nCleared Digits\n";
    }

    @Override
    public String clear() {
        operand = "";
        results = new Stack<>();
        return "\nClear All\n";
    }

    @Override
    public String enterPressed() {
        if (operand != "") {
            results.push(Float.parseFloat(operand));
            operand = "";
        }
        return " ";
    }

    @Override
    public String addDecimal() {
        if (!operand.contains(".")){
            operand += ".";
            return ".";
        }
        return "";
    }
    
}