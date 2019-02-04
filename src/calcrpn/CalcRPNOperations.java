
package calcrpn;

/**
 *
 * @author slang
 * Date Created: January 24, 2019
 * Date Updated: NA
 * 
 * This is a special kind of class called an interface class.  This type of
 * class does not have a constructor method.  The only purpose of this type of
 * class is to provide another class with a set of methods that class must
 * implement.
 * 
 */
public interface CalcRPNOperations {
       
    /**
     * A single digit from the UI.
     * 
     * @param digit an integer
     * @return The result to display.
     */
    public String digit(String digit);
    /**
     * An arithmetic operator from the UI.
     * @param op
     * @return The result to display.
     */
    public String operator( String op);
    /**
     * The ClearEntry button on the UI has been pressed
     * so remove any digits typed so far.
     * 
     * @return A calculated value to display. 
     */
    public String clearEntry();
    /**
     * The Clear button on the UI has been pressed
     * so all memory in the calculator is cleared.
     * 
     * @return A message to display. 
     */
    public String clear();
    /**
     * The Enter button on the UI has been pressed.
     * @return A message to display.
     */
    public String enterPressed();
    /**
     * A decimal point on the UI has been pressed.
     * @return A message to display.
     */
    public String addDecimal();      
}