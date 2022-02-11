package calcrpn;

import java.util.Stack;

public class CalcBrain implements CalcRPNOperations {

    Stack<Float> results;
    String operand;
    
    
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
        
        Float result = new Float(0);
        
        //three possible scenarios...
        if (results.isEmpty() || (results.size() < 2 && operand == "")){
            //do nothing
            return "";
        } else if (results.size() >= 2 && operand == ""){
            //pop 2 and calculate
            result = calculate(op, results.pop(), results.pop());
        } else { // if operand is occupied and results are > 0
            //pop 1 and calculate
            result = calculate(op, Float.parseFloat(operand), results.pop());
        }
                      
        results.push(result);
        operand = "";
        return " " + op + "\n" + results.peek().toString() + " ";
    }

    /*
        Clears out the operand, and if the operand is already empty, removed an element from the stack
    */
    @Override
    public String clearEntry() {
        if (results.size() > 0 && operand == ""){
            results.pop();
        }
        operand = "";
        return "\nCleared Digits\n";
    }

    /*
        Clears out the operand and the entire results stack
    */
    @Override
    public String clear() {
        operand = "";
        results.clear();
        return "\nClear All\n";
    }

    /*
        Assuming operand is valid, pushes it to the stack and resets operand
    */
    @Override
    public String enterPressed() {
        if (operand != "" && !isOperator(operand)) {
            results.push(Float.parseFloat(operand));
            operand = "";
        }
        return " ";
    }

    /*
        Inserts decimal into operand if it's not already present.
    */
    @Override
    public String addDecimal() {
        if (!operand.contains(".")){
            operand += ".";
            return ".";
        }
        return "";
    }
    
    /*
        Calculation formula; Returns float; Takes operator, right part of calulation, left part of calculation
    */
    private Float calculate(String op, Float right, Float left){
        Float result = new Float(0);
        switch (op){
            case "+":
                result = left + right;
                break;
            case "-":
                result = left - right;
                break;
            case "*":
                result = left * right;
                break;
            case "/":
                result = left / right;
                break;
            case "^":
                result = (float)(Math.pow(left, right));
                break;
        }
        return result;
    }
    
    /*
        Checks to see if string is valid operator
    */
    private boolean isOperator(String operator){
        switch (operator){
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