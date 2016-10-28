
import java.io.*;

public class Stock {
	//Variables
	private String timeStamp;			
	private String outputFileName;
	private String inputFileName;
	private double openingPrice;	//Double holding Next Price of Stock
	private double highestPrice;
	private double lowestPrice;
	private double closingPrice;
	private double volumeOfStocks;
	
	/**
	 * This sets the private variables to the default
	 */
	public Stock() {
		timeStamp = "12:00";
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
		//Assigns the name to the private variable
		timeStamp = t;
	}
	public void setOpeningPrice(double o) {
		openingPrice = o;
	}
	public void setHighestPrice(double h) {
		highestPrice = h;
	}
	public void setLowestPrice(double l) {
		lowestPrice = l;
	}
	public void setClosingPrice(double c) {
		closingPrice = c;
	}
	public void setVolumeOfStocks(double v) {
		volumeOfStocks = v;
	}
	
	public void SetOutputFileName(String s) {
		outputFileName = s;
	}
	public void SetInputFileName(String s) {
		inputFileName = s;
	}
	
	/**
	 * This returns the company name 
	 * @return
	 */
	public String getTimeStamp() {
		//returns the name of the company
		return timeStamp;
	}
	public double getOpeningPrice() {
		return openingPrice;
	}
	public double getHighestPrice() {
		return highestPrice;
	}
	public double getLowestPrice() {
		return lowestPrice;
	}
	public double getClosingPrice() {
		return closingPrice;
	}
	public double getVolumeOfStocks() {
		return volumeOfStocks;
	}
	
	public String getOutputFileName() {
		return outputFileName;
	}
	public String getInputFileName() {
		return inputFileName;
	}
	
	/**
	 * This changes next price according the percentage by a negative or positive number
	 */
	public void printHeaders(PrintWriter f){
		//Outputs the header names
		f.println("TIMESTAMP,CURRENT_PRICE,SHARES,P/L_PERCENT,PROFIT/LOSS,REALIZED_PROFIT/LOSS,HOLD/NONE,PURCHASE/SELL_PRICE,PURCHASE_COST");
	}
	
	/**
	 * This prints the Headers & stock information
	 * @param cN
	 * @param cS
	 * @param cP
	 * @param nP
	 * @param rn
	 */
	
}//Closes public Stock Class
