package calcrpn;

import java.util.Stack;

public class CalcBrain implements CalcRPNOperations {

    Stack<Float> results;
    String operand;
    Stack<Float> storage;
    
    
    public CalcBrain() {
        results = new Stack<>();
        operand = "";
    }
    
    /* 
        Adds digit to operand string. Returns digit for printing.
    */
    @Override
    public String digit(String digit) {
        operand += digit;
        return digit;
    }

    /*
        Receives operator and performs calculations. Returns string for printing.
    */
    @Override
    public String operator(String op) {
        
        storage = new Stack<>();
        Float c = new Float(0);
        
        if (op != ""){
            if (results.size() < 2){
                switch (op){
                    case "+":
                        c = Float.parseFloat(operand) + results.pop();
                        break;
                    case "-":
                        c =  results.pop() - Float.parseFloat(operand);
                        break;
                    case "*":
                        c = Float.parseFloat(operand) * results.pop();
                        break;
                    case "/":
                        c =  results.pop() / Float.parseFloat(operand);
                        break;
                    case "^":
                        c = (float)(Math.pow(results.pop(), Float.parseFloat(operand)));
                        break;
                }
                return " " + op + "\n" + c.toString() + "\n";
            } else {
                while(results.size() > 0 && !isOperand(results.peek().toString())
                    ){
                    storage.push(results.pop());
                }

                c = storage.pop();
                while(storage.size() > 0){
                    switch (op){
                        case "+":
                            c += storage.pop();
                            break;
                        case "-":
                            c -= storage.pop();
                            break;
                        case "*":
                            c *= storage.pop();
                            break;
                        case "/":
                            c /= storage.pop();
                            break;
                        case "^":
                            c = (float)(Math.pow(c, storage.pop()));
                            break;
                    }
                }
            }
            results.push(c);
            operand = "";
//            storage.clear();
        }
        
        
        return " " + op + "\n" + c.toString() + "\n";
    }

    @Override
    public String clearEntry() {
        operand = "";
        return "\nCleared Digits\n";
    }

    @Override
    public String clear() {
        operand = "";
        results.clear();
        storage.clear();
        return "\nClear All\n";
    }

    @Override
    public String enterPressed() {
        if (operand != "" && !isOperand(operand)) {
            results.push(Float.parseFloat(operand));
            operand = "";
        }
        
//        if (operand == "")
//            return results.peek().toString();
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
    
    private Float calculate(String operand){
        Float c = new Float(0);
        switch (operand){
            case "+":
                c += storage.pop();
                break;
            case "-":
                c -= storage.pop();
                break;
            case "*":
                c *= storage.pop();
                break;
            case "/":
                c /= storage.pop();
                break;
            case "^":
                c = (float)(Math.pow(c, storage.pop()));
                break;
        }
        return c;
    }
    
    private boolean isOperand(String operand){
        switch (operand){
            case "+":
                return true;
            case "-":
                return true;
            case "^":
                return true;
            case "*":
                return true;
            case "/":
                return true;
            default:
                return false;
        }
    }
    
}