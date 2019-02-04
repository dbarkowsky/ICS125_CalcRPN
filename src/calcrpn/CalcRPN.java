
package calcrpn;

/**
 * @author slang
 * Date Created: January 24, 2019
 * Date Updated: NA
 */
public class CalcRPN {

    /**
     * This source file instantiates the Model, View, and Controller portions
     *  of the RPN calculator.
     */
    public static void main(String[] args) {
        CalcRPNView theView = new CalcRPNView();        
    	CalcRPNModel theModel = new CalcRPNModel();       
        CalcRPNController theController = 
                new CalcRPNController(theView, theModel);        
        theView.setVisible(true);
    }
    
} // end CalcRPN
