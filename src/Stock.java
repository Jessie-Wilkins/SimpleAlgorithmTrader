import java.io.*;

public class Stock {
	//Variables
	private String timeStamp;			//String containing the time stamp of the stock
	private String outputFileName;		//String containing the name of the output file
	private String inputFileName;		//String containing the name of the input file
	private double openingPrice;		//Double holding the opening Price of Stock
	private double highestPrice;		//Double containing the highest price for the stock
	private double lowestPrice;			//Double containing the lowest price for the stock
	private double closingPrice;		//Double containing the closing price for the stock
	private double volumeOfStocks;		//Double containing the number of stocks in circulation
	
	/**
	 * This sets the private variables to the default
	 */
	public Stock() {
		timeStamp = "00:00";
		outputFileName = "outputName";
		inputFileName = "inputName";
		openingPrice = 0;
		highestPrice = 0;
		lowestPrice = 0;
		closingPrice = 0;
		volumeOfStocks = 0;
		
	}//Closes Stock Method
	
	/**
	 * This sets the time stamp to the given string
	 * @param n
	 */
	public void setTimeStamp(String t){
		timeStamp = t;
	}
	/**
	 * Sets the opening price to the given double
	 * @param o
	 */
	public void setOpeningPrice(double o) {
		openingPrice = o;
	}
	/**
	 * Sets the highest price to the given double
	 * @param h
	 */
	public void setHighestPrice(double h) {
		highestPrice = h;
	}
	/**
	 * Sets the lowest price to the given double
	 * @param l
	 */
	public void setLowestPrice(double l) {
		lowestPrice = l;
	}
	/**
	 * Sets the closing price to the given double
	 * @param c
	 */
	public void setClosingPrice(double c) {
		closingPrice = c;
	}
	/**
	 * Sets the number of stocks in circulation to the given double
	 * @param v
	 */
	public void setVolumeOfStocks(double v) {
		volumeOfStocks = v;
	}
	/**
	 * Sets output file name to the given string
	 * @param s
	 */
	public void SetOutputFileName(String s) {
		outputFileName = s;
	}
	/**
	 * Sets input file name to the given string
	 * @param s
	 */
	public void SetInputFileName(String s) {
		inputFileName = s;
	}
	
	/**
	 * This returns the company name 
	 * @return
	 */
	public String getTimeStamp() {
		return timeStamp;
	}
	/**
	 * This returns the opening price
	 * @return
	 */
	public double getOpeningPrice() {
		return openingPrice;
	}
	/**
	 * This returns the highest price
	 * @return
	 */
	public double getHighestPrice() {
		return highestPrice;
	}
	/**
	 * Returns the lowest price
	 * @return
	 */
	public double getLowestPrice() {
		return lowestPrice;
	}
	/**
	 * Returns the closing price
	 * @return
	 */
	public double getClosingPrice() {
		return closingPrice;
	}
	/**
	 * Returns the volume of stocks in circulation
	 * @return
	 */
	public double getVolumeOfStocks() {
		return volumeOfStocks;
	}
	/**
	 * Returns the output file name
	 * @return
	 */
	public String getOutputFileName() {
		return outputFileName;
	}
	/**
	 * Returns the input file name
	 * @return
	 */
	public String getInputFileName() {
		return inputFileName;
	}
	
	/**
	 * This prints the Headers
	 * @param f
	 */
	public void printHeaders(PrintWriter f){
		f.println("TIMESTAMP,CURRENT_PRICE,SHARES,P/L_PERCENT,PROFIT/LOSS,REALIZED_PROFIT/LOSS,HOLD/NONE,PURCHASE/SELL_PRICE,PURCHASE_COST");
	}
	
	
	
}//Closes public Stock Class
