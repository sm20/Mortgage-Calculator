package lab4;
import java.lang.Math;

/**
 * Class that deals with all the calculations based on the user input for the initial values.
 * It contains calculation, getter, and setter methods
 * @author Sajid C.
 *
 */
public class CalculationsModel {

	
	private double numPayments;
	private double principal;
	private double annualIntRate;
	
	private double interestFactor;
	private double blendedPayment;
	private double intAndPrincipal;
	private double totalIntPaid;
	private double iPRatio;
	
	private double compoundFreq;
	private double paymentFreq;
	
	/**
	 * Constructor to set the initial values for the variables for the number of payments,
	 * principal, and annualIntRate.
	 */
	public CalculationsModel()
	{
		this.numPayments = 0;
		this.principal = 0;
		this.annualIntRate = 0;
		this.compoundFreq = 2;
		this.paymentFreq = 12;
	}
	
	public void setPaymentFreq(double freq)
	{
		this.paymentFreq = freq;
	}
	/**
	 *  Given a double representing the number of payments, this method sets the respective instance variable
	 *  in this class for further calculations.
	 * @param numOfPayments The Number of monthly payments.
	 */
	public void setNumPayments(double numOfPayments)
	{
		this.numPayments = numOfPayments;
	}
	/**
	 *  Given a double representing the principal amount, this method sets the respective
	 * instance variable in this class for further calculations.
	 * @param principal The total amount loaned
	 */
	public void setPrincipal(double principal)
	{
		this.principal = principal;
	}
	/**
	 * Given a double representing the annual interest rate as a percent, this method
	 * divides it by 100 to ready it for calculations, and sets the respective
	 * instance variable in the class for further calculations
	 * @param intRate The annual interest rate the user enters.
	 */
	public void setAnnualIntRate(double intRate)
	{
		
		this.annualIntRate = (intRate/100);
	}
	
	
	
	/**
	 * Using a double Compound Frequency and Payment Frequency, this method calculates the interest factor
	 * using the interest factor formula.

	 */
	public void calcInterestFactor()
	{
		double power = (compoundFreq/paymentFreq);
		interestFactor = (Math.pow(((annualIntRate/compoundFreq)+1), power))-1;
	}
	/**
	 * 
	 * @return The interestFactor, as a double.
	 */
	public double getInterestFactor()
	{
		return interestFactor;
	}
	
	/**
	 * A method that calculates the amount of the blended monthly payment and assigns it to
	 * a variable, using the respective formula.
	 */
	public void calcBlendedPayment()
	{
		blendedPayment = ((principal * interestFactor)/(1-(Math.pow((interestFactor + 1),(-numPayments)))));
	}
	/**
	 * 
	 * @return The blended monthly payment, as a double.
	 */
	public double getBlendedPayment()
	{
		return blendedPayment;
	}
	
	/**
	 * Calculates the Total Interest and Principal and assigns it to a variable.
	 */
	public void calcTotalInterestAndPrincipal()
	{
		intAndPrincipal = blendedPayment*numPayments;
	}
	/**
	 * 
	 * @return The total interest and principal, as a double.
	 */
	public double getTotalInterestAndPrincipal()
	{
		return intAndPrincipal;
	}
	
	/**
	 * Calculates the Total interest paid over the length of the mortgage and assigns it t a variable.
	 */
	public void calcTotalInterestPaid()
	{
		totalIntPaid = intAndPrincipal-principal;
	}
	/**
	 * 
	 * @return The total interest paid over the length of the mortgage, as a double.
	 */
	public double getTotalInterestPaid()
	{
		return totalIntPaid;
	}
	
	/**
	 * Calculates the interest/principal ratio and assigns it to a variable.
	 */
	public void calcIntPrincipalRatio()
	{
		iPRatio = totalIntPaid/principal;
	}
	/**
	 * 
	 * @return The interest/principal ratio, as a double.
	 */
	public double getIntPrincipalRatio()
	{
		return iPRatio;
	}
	
	/**
	 * A method that calculates and returns the average interest paid per year.
	 * @return The average interest paid per year.
	 */
	public double calcAvgIntYear()
	{
		return (totalIntPaid/(numPayments/12));
	}
	/**
	 * A method that calculates and returns the average interest per month.
	 * @return The average interest paid per month.
	 */
	public double calcAvgIntMonth()
	{
		return (totalIntPaid/numPayments);
	}
	/**
	 * Calculates and returns the amortization expressed in years.
	 * @return The amortization expressed in years.
	 */
	public double amorInYears()
	{
		return (numPayments/12);
	}
	
}
