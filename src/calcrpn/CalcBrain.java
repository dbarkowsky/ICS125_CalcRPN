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

        return null;
    }

    @Override
    public String operator(String op) {

        return null;
    }

    @Override
    public String clearEntry() {

        return null;
    }

    @Override
    public String clear() {

        return null;
    }

    @Override
    public String enterPressed() {

        return null;
    }

    @Override
    public String addDecimal() {

        return null;
    }
    
}