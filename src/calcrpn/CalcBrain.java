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
        operand = op;
        Float a; 
        Float b;
        Stack<Float> storage = new Stack<>();
        Float c = new Float(0);
        
        if (operand != ""){
            if (results.size() < 2){
                return "";
            } else {
                if (results.peek() != "+" || results.peek() != "-" || results.peek() != "*" || results.peek() != "/" || results.peek() != "^"){
                    storage.push(Float.parseFloat(results.pop()));
                }
            }
            
            switch (operand){
                case "+":
                    c = a + b;
                    break;
                case "-":
                    c = b - a;
                    break;
                case "*":
                    c = a * b;
                    break;
                case "/":
                    c = b / a;
                    break;
                case "^":
                    c = (float)(Math.pow(b, a));
                    break;
            }
            
            results.push(c);
            operand = "";
        }
        
        
        return "\n" + c.toString() + "\n";
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