import java.util.ArrayList;						//Imports ArrayList class so that array lists may be used
import java.util.Scanner;						//Imports Scanner class so that input may be accepted
import java.io.*;								//Imports all of the IO classes so the output file classes may be used

public class AlgorithmTrader {
	//Variables
	private double currentValueOfTotal;			//Value of a the total value of the held stocks
	private double purchaseSellPrice;			//Value of the stocks sold or bought
	private double purchaseCost;				//Cost of each stock that was bought
	private double percentageOfRevenue;			//Percentage increase from the revenue
	private double actualRevenue;				//Revenue that the user gains after selling the stocks
	private double revenue;						//Revenue that is possible if the user were to sell
	private int heldStocks;						//The number of held stocks
	private String holdingStatus;				//The status that indicates whether or not stocks are being held
	final private int BUY_SIGNAL_THREASHOLD = 5;
	final private double SELL_SIGNAL_THREASHOLD = 0.0012; 
	/*
	 * Constructor that sets the variables to default values
	 */
	public AlgorithmTrader() {
		//Sets these all to 0
		currentValueOfTotal=0;
		purchaseSellPrice = 0;
		purchaseCost = 0;
		percentageOfRevenue = 0;
		actualRevenue = 0;
		revenue = 0;
		heldStocks = 0;
		//Sets holdingStatus to "NONE"
		holdingStatus = "NONE";
	}//Closes AlgorithmTrader method
	
	/**
	 * Sets the currentValueOfTotal to the given value
	 * @param t
	 */
	public void SetCurrentValueOfTotal(double t) {
		currentValueOfTotal = t;
	}
	
	/**
	 * Sets the setPurchaseSellPrice to the given value
	 * @param psp
	 */
	public void SetPurchaseSellPrice (double psp) {
		purchaseSellPrice = psp;
		
	}
	
	/**
	 * Sets the purchaseCost to the given value
	 * @param pc
	 */
	public void SetPurchaseCost (double pc) {
		purchaseCost = pc;
	}
	
	/**
	 * Sets the percentageOfRevenue to the given value
	 * @param pr
	 */
	public void SetPercentageOfRevenue(double pr) {
		percentageOfRevenue = pr;
	}
	
	/**
	 * Sets the actualRevenue to the given value
	 * @param ar
	 */
	public void SetActualRevenue(double ar) {
		actualRevenue = ar;
	}
	
	/**
	 * Sets the revenue to the given value
	 * @param r
	 */
	public void SetRevenue(double r) {
		revenue = r;
	}
	
	/**
	 * Sets the heldStocks to the given value
	 * @param n
	 */
	public void SetHeldStocks(int n) {
		heldStocks = n;
	}
	
	/**
	 * Sets the holdingStatus to the given value
	 * @param hs
	 */
	public void setHoldingStatus(String hs) {
		holdingStatus = hs;
	}
	
	/**
	 * Returns the currentValueOfTotal
	 * @return
	 */
	public double getCurrentValueOfTotal() {
		return currentValueOfTotal;
	}
	
	/**
	 * Returns the purchaseSellPrice
	 * @return
	 */
	public double GetPurchaseSellPrice () {
		return purchaseSellPrice;
		
	}
	
	/**
	 * Returns the purchaseCost
	 * @return
	 */
	public double GetPurchaseCost () {
		return purchaseCost;
	}
	
	/**
	 * Returns the percentageOfRevenue
	 * @return
	 */
	public double GetPercentageOfRevenue() {
		return percentageOfRevenue;
	}
	
	/**
	 * Returns the actualRevenue
	 * @return
	 */
	public double GetActualRevenue() {
		return actualRevenue;
	}
	
	/**
	 * Returns the revenue
	 * @return
	 */
	public double getRevenue() {
		return revenue;
	}
	
	/**
	 * Returns the heldStocks
	 * @return
	 */
	public int getHeldStocks() {
		return heldStocks;
	}
	
	/**
	 * Returns the holdingStatus
	 * @return
	 */
	public String getHoldingStatus() {
		return holdingStatus;
	}
	
	/**
	 * Prints a line of the current stock information
	 * @param s
	 * @param i
	 * @param f
	 */
	public void printResults(ArrayList<Stock> s, int i, PrintWriter f) {
		//Print results to screen for user to see the Stock Prices Fluctuation
		f.printf("%s,%.4f,%d,%.2f,$%.2f,$%.2f,%s,%.2f,$%.2f\r\n", s.get(i).getTimeStamp(), s.get(i).getClosingPrice(), this.getHeldStocks(), this.GetPercentageOfRevenue(), this.getRevenue(), this.GetActualRevenue(), this.getHoldingStatus(), this.GetPurchaseSellPrice(), this.GetPurchaseCost());
	}
	
	/**
	 * Reads the data from the .csv input file into an object array
	 * @param fName
	 * @return
	 * @throws IOException
	 */
	public ArrayList<Stock> ReadInputData(String fName) throws IOException {
		//These create File objects for counting the lines and
		//for reading the given file
		File fileForCounting = new File(fName);
		File fileForReading = new File(fName);
		
		//Creates the Scanner objects for the files that
		//will count the lines and read in the file
		Scanner fCount = new Scanner(fileForCounting);
		Scanner fRead = new Scanner(fileForReading);

		//Declares and initializes to 0 the integer variable used
		//to keep track of the number of lines
		int i=0;
		//Declares the array list of the Stock class
		ArrayList<Stock> a = new ArrayList<Stock>(100);
		//Declares and initializes to 0, the integer variable used to count
		//the number of lines in the file
		int count = 0;
		
		//Counts the number of lines until there are no lines left
		while(fCount.hasNextLine()) {
			//Reads in the values and goes to next line
			fCount.nextLine();
			//Increments the count variable
			count++;
			System.out.println(count);
		}
		
		//Declares a string array that will be used to accept the input
		//of each line of the file
		String [] array = new String[count];
		
		//Reads in each line of the file into the 
		//string array as long as i is less than the 
		//count.
		while(i<count) {
			array[i] = fRead.nextLine();
			//Increments the i after reading in each line
			i++;
		}
		
		//Sets the string array to Stock object array list 
		//while i is less than the length of the array
		for(i=1; i<array.length; i++) {
			
			//Sets the string array to the string split into sub strings separated
			//by commas in the given array element 
			String [] stockRecords = array[i].split("[,]");
			
			//Declares the Stock class object
			//And adds it to the Stock array list
			Stock s = new Stock();			
			a.add(s);
			
			//Sets the given Stock array list elements setters of all the 
			//variables to the corresponding String array element
			a.get(i-1).setTimeStamp(stockRecords[0]);
			a.get(i-1).setClosingPrice(Double.parseDouble(stockRecords[1]));
			a.get(i-1).setHighestPrice(Double.parseDouble(stockRecords[2]));
			a.get(i-1).setLowestPrice(Double.parseDouble(stockRecords[3]));
			a.get(i-1).setOpeningPrice(Double.parseDouble(stockRecords[4]));
			a.get(i-1).setVolumeOfStocks(Integer.parseInt(stockRecords[5]));
		}
		//Closes the Scanner objects 
		fCount.close();
		fRead.close();
		
		//Returns the stock array list
		return a;
	}
	
	/**
	 * Determines when to buy stock - sets default to false
	 * @param s
	 * @param num
	 * @return
	 */
	public boolean EntryStrategy(ArrayList<Stock> s, int num) {
		//Sets the boolean variable to false
		boolean b = false;
		
		//Initiates the if else statements if the given number
		//is less than the array list size -1
		if(num<s.size()-1){
			//if the current price is less than the next price and 
			//the held stocks is equal to 0, it sets b = to true
			if(s.get(num+1).getClosingPrice() > s.get(num).getClosingPrice() && getHeldStocks() == 0){
				b =true;
			}
			//if no other conditions are satisfied, sets b = to false
			else {
				b = false;
			}
		}
		//Returns b
		return b;
	
	}
	
	/**
	 * Determines when to sell the held stocks
	 * @param s
	 * @param num
	 * @return
	 */
	public boolean ExitStrategy(ArrayList<Stock> s, int num) {
		//Declares and initializes to false the boolean variable
		boolean b = false;
		
		//The if statements will be initiated if the number
		//is less than the array list size -1
		if(num<s.size()-1) {
			//If the percentage gain is equal to or greater than .0012 or
			//the percentage loss is equal to or less than .0012 or the number is
			// equal to the array list of the Stock -2 and the held stocks is equal
			//to 10000, it sets b equal to true
			if(((s.get(num).getClosingPrice() - this.GetPurchaseSellPrice())/this.GetPurchaseSellPrice() >=.0012
				|| ((s.get(num).getClosingPrice() - this.GetPurchaseSellPrice())/this.GetPurchaseSellPrice()) <= -.0012 
				|| num==s.size()-2)
				&& getHeldStocks() == 10000 ){
				b = true;	
			}
			//If no other condition are satisfied, it sets b equal to false
			else{
				b = false;
			}
		}
		//Returns b
		return b;
	}//Closes ExitStrategy Boolean
	
	/**
	 * Runs the program according to the given parameters
	 * @param fName
	 * @param f
	 * @throws IOException
	 */
	public void Run(String fName, PrintWriter f) throws IOException{
		
		//Declares the array list of the Stock object
		ArrayList<Stock> stockFileData = new ArrayList<Stock>();
		
		//Sets input data to the array list of the Stock object
		//to the stock data
		stockFileData = ReadInputData(fName);
		
		//Declares the boolean variables for the entry strategy and the 
		//exit strategy
		boolean entryBool;
		boolean exitBool;
		
		//Prints the header of the file to the
		//output file
		stockFileData.get(0).printHeaders(f);
		
		//Declares and initializes integer variable used to count how many times
		//the entryBool is true to 0
		int j=0;
		
		//Runs the program while i is less than the array list size
		for(int i =0; i<stockFileData.size(); i++) {
			
			//Sets the entryBool and the exitBool to the 
			//the booleans from the entryStrategy and the 
			//exitStrategy methods respectively
			entryBool= EntryStrategy(stockFileData, i);
			exitBool = ExitStrategy(stockFileData, i);
			
			//If entryBool is true, j is incremented
			if(entryBool) {
				j++;
			}
			//If no other condition is satisfied, j is set to 0
			else {
				j=0;
			}
			
			//If j is equal to 5
			if(j==5) {
				//Set currentValueOfTotal to the closing price times 10000
				SetCurrentValueOfTotal(10000*stockFileData.get(i).getClosingPrice());
				//Sets heldStocks to 10000
				SetHeldStocks(10000);
				//Sets the purchaseSellPrice to the closing price
				SetPurchaseSellPrice(stockFileData.get(i).getClosingPrice());
				//Sets the purchaseCost to the currentValueofTotal
				SetPurchaseCost(getCurrentValueOfTotal());
				//Sets the holdingStatus to "HOLD"
				setHoldingStatus("HOLD");
				//Sets j equal to 0
				j=0;
			}//Closes if on line 358
			
			//If exitBool to true
			else if(exitBool) {
				//Sets percentageOfRevenue to the closing price - the original purchase price / by the original purchase price
				SetPercentageOfRevenue((stockFileData.get(i).getClosingPrice()-GetPurchaseSellPrice())/GetPurchaseSellPrice());
				//Sets the actual revenue to the closing price to the original purchase price
				SetActualRevenue(10000*(stockFileData.get(i).getClosingPrice()-GetPurchaseSellPrice())+this.GetActualRevenue());
				//Sets the holding status to "NONE"
				setHoldingStatus("NONE");
				//Sets the purchaseSellPrice to the closing price
				SetPurchaseSellPrice(stockFileData.get(i).getClosingPrice());
				//Sets purchase cost to 0
				SetPurchaseCost(0);
				//Sets held stocks to 0
				SetHeldStocks(0);
			}//Closes else if on line 374
			
			//if i is greater than 0 and the holding status is equal
			//to "HOLD", this sets revenue to closing price - the purchase price
			//and sets the percentage of the gain or loss to closing price - the purchase price
			//divided by the purchase price
			else if(i>0 && getHoldingStatus().equals("HOLD")) {
				SetRevenue(10000*(stockFileData.get(i).getClosingPrice()-GetPurchaseSellPrice())+this.GetActualRevenue());
				SetPercentageOfRevenue((stockFileData.get(i).getClosingPrice()-GetPurchaseSellPrice())/GetPurchaseSellPrice());
				
			}//Closes else if on line 393
			//Prints the line of the current stock information to the output 
			//csv file
			printResults(stockFileData ,i, f);
		}//Closes the for loop on line 340
	
	}//Closes Run method
}//Closes AlgorithmTrader Class
