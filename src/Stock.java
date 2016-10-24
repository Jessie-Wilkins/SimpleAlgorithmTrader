
import java.io.*;

public class Stock {
	//Variables
	private String timeStamp;			
	private String outputFileName;
	private String inputFileName;
	private String holdingStatus;
	private double openingPrice;	//Double holding Next Price of Stock
	private double highestPrice;
	private double lowestPrice;
	private double closingPrice;
	private double volumeOfStocks;
	private double currentValueOfTotal;
	private double purchaseSellPrice;
	private double purchaseCost;
	private double percentageOfRevenue;
	private double actualRevenue;
	private double revenue;
	private int heldStocks;
	
	/**
	 * This sets the private variables to the default
	 */
	public Stock() {
		
	}//Closes Stock Method
	
	/**
	 * This sets the time stamp to the given string
	 * @param n
	 */
	public void setTimeStamp(String t){
		//Assigns the name to the private variable
		timeStamp = t;
	}
	public void setHoldingStatus(String hs) {
		holdingStatus = hs;
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
	
	public void SetCurrentValueOfTotal(double t) {
		currentValueOfTotal = t;
	}
	
	public void SetPurchaseSellPrice (double psp) {
		purchaseSellPrice = psp;
		
	}
	
	public void SetPurchaseCost (double pc) {
		purchaseCost = pc;
	}
	
	public void SetPercentageOfRevenue(double pr) {
		percentageOfRevenue = pr;
	}
	
	public void SetActualRevenue(double ar) {
		actualRevenue = ar;
	}
	
	public void SetRevenue(double r) {
		revenue = r;
	}
	
	public void SetOutputFileName(String s) {
		outputFileName = s;
	}
	public void SetInputFileName(String s) {
		inputFileName = s;
	}
	public void SetHeldStocks(int n) {
		heldStocks = n;
	}
	/**
	 * This returns the company name 
	 * @return
	 */
	public String getTimeStamp() {
		//returns the name of the company
		return timeStamp;
	}
	public String getHoldingStatus() {
		return holdingStatus;
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
	
	public double getCurrentValueOfTotal() {
		return currentValueOfTotal;
	}
	
	public double GetPurchaseSellPrice () {
		return purchaseSellPrice;
		
	}
	
	public double GetPurchaseCost () {
		return purchaseCost;
	}
	
	public double GetPercentageOfRevenue() {
		return percentageOfRevenue;
	}
	
	public double GetActualRevenue() {
		return actualRevenue;
	}
	
	public double getRevenue() {
		return revenue;
	}
	
	public String getOutputFileName() {
		return outputFileName;
	}
	public String getInputFileName() {
		return inputFileName;
	}
	public int getHeldStocks() {
		return heldStocks;
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
	public void printResults() {
		//Print results to screen for user to see the Stock Prices Fluctuation
		System.out.printf("%s,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%s,%.2f,%.2f\r\n", this.getTimeStamp(), this.getClosingPrice(), this.getHeldStocks(), this.GetPercentageOfRevenue(), this.getRevenue(), this.GetActualRevenue(), this.getHoldingStatus(), this.GetPurchaseSellPrice(), this.GetPurchaseCost());
	}
	
}//Closes public Stock Class
