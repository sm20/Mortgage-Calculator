package lab4;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * Class that directs communication between the CalculationsModel and CalculatorView classes.
 * User inputs from the GUI are taken from the view class and passed to the model class here.
 * These inputs are then calculated in the model class, and returned here, and finally passed back
 * to the view class to display the outputs the user requires. All object references are instantiated here as well.
 * @author Sajid C.
 *
 */
public class Controller {

	/**
	 * Main method of the program. Instantiates object references and handles them further.
	 * @param args
	 */
	public static void main(String [] args)
	{
		//instantiate model and view class, and display the GUI
		CalculatorView view = new CalculatorView();
		CalculationsModel model = new CalculationsModel();
	
		/**
		 * Inner class for handling window events. Extends the WindowAdapter class.
		 * @author Sajid C.
		 *
		 */
		class MyHandler extends WindowAdapter
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		}
		
		//instantiate a handler and window listener.
		MyHandler handler = new MyHandler();
		view.addWindowListener(handler);
		
		/**
		 * Inner class that implements ActionListener. It handles button events using listeners,
		 * and handles the users output and input.
		 * @author Sajid C.
		 *
		 */
		class ButtonListener implements ActionListener
		{
			/**
			 * Actionperformed method to deal with action event when buttons are pressed.
			 */
			public void actionPerformed(ActionEvent e)
			{
				
				{
					//get string from user input and use model to manipulate it
					model.setNumPayments(Double.parseDouble(view.getAmortTxt()));
					model.setPrincipal(Double.parseDouble(view.getprincipalTxt()));
					model.setAnnualIntRate(Double.parseDouble(view.getRateTxt()));
					
					//more calculations using the model class
					model.calcInterestFactor();
					model.calcBlendedPayment();
					model.calcTotalInterestAndPrincipal();
					model.calcTotalInterestPaid();
					model.calcIntPrincipalRatio();
					model.calcAvgIntYear();
					model.calcAvgIntMonth();
					
					//DecimalFormat creates a string out of a double, but changes it to have only two floating points.
					DecimalFormat df = new DecimalFormat("#.00");
					//uses getter methods from model and setResultsLabels method from view, to set the labels in view
					//from empty strings to the values after calculations are done, so that they are displayed.
					view.setResultLabels(df.format(model.getBlendedPayment()),
							df.format(model.getTotalInterestPaid())
							, df.format(model.getTotalInterestAndPrincipal()),
							df.format(model.getIntPrincipalRatio())
							,df.format(model.calcAvgIntYear()),
							df.format(model.calcAvgIntMonth()), 
							df.format(model.amorInYears()));
				}
				
			}
		}
//not implemented		
//		class RadioListener implements ActionListener
//		{
//			public void actionPerformed (ActionEvent e)
//			{
//				String button = e.getActionCommand();
//				if(button.equals("bi-weekly"))
//				{
//					model.setPaymentFreq(24);
//					model.setNumPayments();
//					System.out.println("1");
//				}
//				else if(button.equals("weekly"))
//				{
//					System.out.println("2");
//				}
//				else if(button.equals("monthly"))
//				{
//					System.out.println("3");
//				}
//			}
//		}
		
		//instantiates listener reference
		ButtonListener listener = new ButtonListener();
		view.addButtonListeners(listener);
		
//mot implemented
//		RadioListener radiolistener = new RadioListener();
//		view.addRadioListeners(radiolistener);
	}
	
}
