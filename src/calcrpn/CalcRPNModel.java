
package calcrpn;

/**
 *
 * @author slang
 * Date Created: January 24, 2019
 * Date Updated: NA
 */

public class CalcRPNModel {
    
    /* This source file is responsible for maintaining and processing
       information.  The calcBrain object is found here.  The other parts
       of the system (View and Controller) have no knowledge of calcBrain.
       The calcBrain determines the information stored in the RPN calculator
       and how information is processed with the operators.
    */
    
    CalcBrain calcBrain;
    
    CalcRPNModel() {
        calcBrain = new CalcBrain();
    }
    
    public String processCalc(String token) {
       /* 
          The processCalc figures out which button had been clicked based
          on the token value passed to it. If the token value is a digit
          0 to 9, then one of those digit buttons had been clicked.
       */
         
       switch (token) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                      return calcBrain.digit( token );                      
                      
            case "+":                     
            case "-":
            case "*":
            case "/":  
            case "^":                
                      return calcBrain.operator( token );                    
                     
            case "CE":
                      return calcBrain.clearEntry() ;                    
                    
            case "C":
                      return calcBrain.clear();                
                      
            case "ENTER":
                      return calcBrain.enterPressed();  
                     
            case ".":
                      return calcBrain.addDecimal();                     
                      
            default:
                      return "";
        }                    
    }  // end processCalc
} // end CalcRPNModel