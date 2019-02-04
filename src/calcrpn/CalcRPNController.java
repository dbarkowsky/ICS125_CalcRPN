
package calcrpn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 * @author slang
 * Date Created: January 24, 2019
 * Date Updated: NA
 */

public class CalcRPNController {

    /* This source file is the Controller portion of the MVC RPN 
       calculator.  It creates the listeners for the GUI elements
       defined in the View. Process control from the View and the 
       Model is co-ordinated through this Controller module.
    */
    private final CalcRPNView theView;
    private final CalcRPNModel theModel;
	
	public CalcRPNController(CalcRPNView theView
                                 , CalcRPNModel theModel) {
		this.theView = theView;
		this.theModel = theModel;
                
                // Attach listeners to the View GUI elements.
                this.theView.addCalculateListener(new ButtonListener());					     
	}
        

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            //  Retrieve the button information.
            JButton button = (JButton)ae.getSource();
            
            // Retrieve the name on the button that was clicked.
            String buttonText = button.getText();
            
            // Send the button text to the Model for processing.
            String message = theModel.processCalc(buttonText);
            
            // Update the view's Text Area element with the result.
            theView.updateView(message);
        }
    } // end ButtonListener
    
} // end CalcRPNController
