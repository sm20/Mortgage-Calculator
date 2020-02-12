package lab4;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * A view class that creates and displays the GUI layout input and out that the user sees.
 * @author Sajid C.
 *
 */
public class CalculatorView {

	private JFrame frame;
	private JLabel amortLabel;
	private JTextField amortTxt;
	private JLabel principalAmt;
	private JTextField principalTxt;
	private JLabel rateLabel;
	private JTextField rateTxt;
	
	private JButton calcButton;
	private JRadioButton biWeekly;
	private JRadioButton weekly;
	private JRadioButton monthly;
	
	private JLabel monthlyPayAmtRes;
	private JLabel totIntRes;
	private JLabel totIntPrincipalRes;
	private JLabel intPrincipalRatioRes;
	private JLabel avgIntYearRes;
	private JLabel avgIntMonthRes;
	private JLabel amortYearRes;
	
	/**
	 * Constructor to set the GUI frame
	 */
	public CalculatorView()
	{
		frame = new JFrame("Mortgage Calculator");
		frame.setSize(845, 790);
		createGUI();
	}
	
	/**
	 * Method that creates all the elements of the GUI.
	 */
	public void createGUI()
	{
		Container pane = frame.getContentPane();
		pane.setLayout(new GridLayout(16,1)); //10 rows and 1 column
		
		
		
				
		JLabel titleLabel = new JLabel("This mortgage calculator will display statistics based on the values you enter below, for the amortization, principal, and annual interest rate:");
		pane.add(titleLabel);
		
		JLabel titleLabel2 = new JLabel("Please enter respective values in to all of the following text boxes and press calculate: ");
		pane.add(titleLabel2);
		
		
		
		JPanel payFreqPanel = new JPanel();
		payFreqPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel payFreqLabel = new JLabel("Payment Frequency: ");

		
		biWeekly = new JRadioButton("bi-weekly");
		weekly = new JRadioButton("weekly");
		monthly = new JRadioButton("monthly");
		

		ButtonGroup group1 = new ButtonGroup();
		group1.add(monthly);
		group1.add(biWeekly);
		group1.add(weekly);
		monthly.setSelected(true);
		
		payFreqPanel.add(payFreqLabel);
		payFreqPanel.add(monthly);
		payFreqPanel.add(biWeekly);
		payFreqPanel.add(weekly);
		
		pane.add(payFreqPanel);
		
		
		JPanel compoundFreqPanel = new JPanel();
		compoundFreqPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel compoundFreqLabel = new JLabel("Compounding Fequency(in months) ");
		compoundFreqPanel.add(compoundFreqLabel);
		
		JTextField compoundFreqTxt = new JTextField(15);
		compoundFreqTxt.setPreferredSize(new Dimension(20,20));
		compoundFreqPanel.add(compoundFreqTxt);
		
		pane.add(compoundFreqPanel);
					
		
		
		
		
		JPanel amortPanel = new JPanel();
		amortPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		amortLabel = new JLabel("Amortization (in months)");
		amortPanel.add(amortLabel);
		
		amortTxt = new JTextField(15);
		amortTxt.setPreferredSize(new Dimension(20,20));
		amortPanel.add(amortTxt);
		
		
		
		JPanel principalPanel = new JPanel();
		principalPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		principalAmt = new JLabel("Principal Amount ($)");
		principalPanel.add(principalAmt);
		
		principalTxt = new JTextField(15);
		principalTxt.setPreferredSize(new Dimension(20,20));
		principalPanel.add(principalTxt);
		
		
		
		JPanel ratePanel = new JPanel();
		ratePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		rateLabel = new JLabel(" Annual Interest Rate (%)");
		ratePanel.add(rateLabel);
		
		rateTxt = new JTextField(15);
		rateTxt.setPreferredSize(new Dimension(20,20));
		ratePanel.add(rateTxt);
		
		
		
		JPanel calcButtonPanel = new JPanel();
		calcButtonPanel.setLayout(new FlowLayout());
		
		calcButton = new JButton(" Calculate");
		calcButtonPanel.add(calcButton);
		
		
		
		JPanel monthlyPayAmtPanel = new JPanel();
		monthlyPayAmtPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		JLabel monthlyPayAmtLabel = new JLabel("Blended Monthly Payment Amount:");
		monthlyPayAmtPanel.add(monthlyPayAmtLabel);
		
		monthlyPayAmtRes = new JLabel("");
		monthlyPayAmtPanel.add(monthlyPayAmtRes);
		
		
		JPanel totIntPanel = new JPanel();
		totIntPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		JLabel totIntLabel = new JLabel("Total Interest Paid over length of Mortgage:");
		totIntPanel.add(totIntLabel);
		
		totIntRes = new JLabel("");
		totIntPanel.add(totIntRes);
		
		
		JPanel totIntPrincipalPanel = new JPanel();
		totIntPrincipalPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		JLabel totIntPrincipalLabel = new JLabel("Total Interest and Principal:");
		totIntPrincipalPanel.add(totIntPrincipalLabel);
		
		totIntPrincipalRes = new JLabel("");
		totIntPrincipalPanel.add(totIntPrincipalRes);
		
		
		JPanel intPrincipalRatioPanel = new JPanel();
		intPrincipalRatioPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		JLabel intPrincipalRatioLabel = new JLabel("Interest/Principal Ratio:");
		intPrincipalRatioPanel.add(intPrincipalRatioLabel);
		
		intPrincipalRatioRes = new JLabel("");
		intPrincipalRatioPanel.add(intPrincipalRatioRes);
				
		
		JPanel avgIntYearPanel = new JPanel();
		avgIntYearPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		JLabel avgIntYearLabel = new JLabel("Average Interest paid per Year:");
		avgIntYearPanel.add(avgIntYearLabel);
		
		avgIntYearRes = new JLabel("");		
		avgIntYearPanel.add(avgIntYearRes);
		
		
		JPanel avgIntMonthPanel = new JPanel();
		avgIntMonthPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		JLabel avgIntMonthLabel = new JLabel("Average Interest paid per Month:");
		avgIntMonthPanel.add(avgIntMonthLabel);
		
		avgIntMonthRes = new JLabel("");
		avgIntMonthPanel.add(avgIntMonthRes);
		
		
		JPanel amortYearPanel = new JPanel();
		amortYearPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		JLabel amortYearLabel = new JLabel("Amortization Expressed in Years:");
		amortYearPanel.add(amortYearLabel); 
		
		amortYearRes = new JLabel("");
		amortYearPanel.add(amortYearRes);
		

		
		
		pane.add(amortPanel);
		pane.add(principalPanel);
		pane.add(ratePanel);
		pane.add(calcButtonPanel);
		
		JLabel titleResultLabel = new JLabel("The following results are displayed below:");
		pane.add(titleResultLabel);
		
		pane.add(monthlyPayAmtPanel);
		pane.add(totIntPanel);
		pane.add(totIntPrincipalPanel);
		pane.add(intPrincipalRatioPanel);
		pane.add(avgIntYearPanel);
		pane.add(avgIntMonthPanel);
		pane.add(amortYearPanel);
		
		
		frame.setVisible(true);
		
	}
	/**
	 * 
	 * @return The user inputed value of the amortization text field, as a string.
	 */
	public String getAmortTxt()
	{
		return amortTxt.getText();
	}
	/**
	 * 
	 * @return The user inputed value of the principal text field, as a string.
	 */
	public String getprincipalTxt()
	{
		return principalTxt.getText();
	}
	/**
	 * 
	 * @return The user inputer value for the annual interest rate text field, as a string.
	 */
	public String getRateTxt()
	{
		return rateTxt.getText();
	}
	
	/**
	 * Takes in all required result values from the controller, and sets them to the result labels
	 * in the CalculatorView class
	 * @param monthlyPayAmtRes Blended monthly payment amount after calculations. String.
	 * @param totIntRes Total interest paid over the length of the mortgage after calculations. String.
	 * @param totIntPrincipalRes Total interest and principal after calculations. String.
	 * @param intPrincipalRatioRes Interest/principal ratio after calculations. String.
	 * @param avgIntYearRes Average interest paid per year after calculations. String.
	 * @param avgIntMonthRes Average interest paid per month after calculations. String.
	 * @param amortYearRes Average interest paid per month after calculations. String.
	 */
	public void setResultLabels(String monthlyPayAmtRes, String totIntRes, String totIntPrincipalRes,
			String intPrincipalRatioRes, String avgIntYearRes, String avgIntMonthRes, String amortYearRes)
	{
		
		this.monthlyPayAmtRes.setText("$"+monthlyPayAmtRes);
		this.totIntRes.setText("$"+totIntRes);
		this.totIntPrincipalRes.setText("$"+totIntPrincipalRes);
		this.intPrincipalRatioRes.setText(intPrincipalRatioRes);
		this.avgIntYearRes.setText("$"+avgIntYearRes);
		this.avgIntMonthRes.setText("$"+avgIntMonthRes);
		this.amortYearRes.setText(amortYearRes+" Year(s)");
		
	}

	//can add rest of buttons here too?
	/**
	 * A method to initialize the listeners for buttons.
	 * @param listen Of type ActionListener. Incites an action.
	 */
	public void addButtonListeners(ActionListener listen)
	{
		calcButton.addActionListener(listen);
		
	}
	/**
	 * A method to initialize the listeners for windows/frames.
	 * @param listener of Type WindowListener. Incites an action.
	 */
	public void addWindowListener(WindowListener listener)
	{
		frame.addWindowListener(listener);
	}
	
	public void addRadioListeners(ActionListener listen)
	{
		monthly.addActionListener(listen);
		biWeekly.addActionListener(listen);
		weekly.addActionListener(listen);
	}
}
