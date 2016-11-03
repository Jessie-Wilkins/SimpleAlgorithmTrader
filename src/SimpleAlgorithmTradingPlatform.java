/* ========================================================================== */

/*	PROGRAM Simple Algorithm Trader
    AUTHOR: Yuri Khechoyan & Jessie Wilkins
    COURSE NUMBER: CIS 210
    COURSE SECTION NUMBER: 01
    INSTRUCTOR NAME: Dr. Tian
    PROJECT NUMBER: 8
    DUE DATE: 11/3/2016

    
SUMMARY

	This program is designed to work similar to the previous program
	(ListOfStocks). This new program is designed to only input file
	that will be accepted is with a .csv extension.
	
	Program will store this stock data into an Array List.
	Finally, program will be used to Buy and Sell the stock
	based on certain formulas or "Strategies". 
	
		ENTRY POSITION STRATEGY: if a stock’s share price increases
		5 times consecutively, then you buy 10,000 shares based on 
   		the current price.
   		
   		EXIT POSITION STRATEGY: if your current position is gaining 
   		0.12% profit or losing 0.12%, then you sell all the shares 
   		you are holding base on the current price.
   		
   		"SPECIAL" EXIT STRATEGY: if you are still holding a stock 
   		at the last minute of a trading day, you MUST sell all of the
    	shares you own.*** 
    	
    	*** - Because the risk of losing money is too big during 
    		  the after hour trading period
	 	
INPUT
	
	Input file contains minute-by-minute activity of 1 stock (MSFT)
	for an entire working day - 9:30 AM - 4 PM (9:30 - 16:00) 
	
	Input for this program is restricted to a .csv file. If the file name that
		user enters does not have an extension or if the extension is incorrect, 
		program will give user an error and will terminate.
	
	If user enters a valid file name with the .csv extension, program will 
		simulate trading stock. The program will figure out what to do with the
		stock (buy/sell) based on several formulas:
	
	ENTRY POSITION STRATEGY: if a stock’s share price increases 5 times 
		consecutively, then you buy 10,000 shares based on the current price.
   		
   	EXIT POSITION STRATEGY: if your current position is gaining 0.12% profit or
   		losing 0.12%, then you sell all the shares you are holding 
   		based on the current price.
   		
   	"SPECIAL" EXIT STRATEGY: if you are still holding a stock at the last minute
   	 of a trading day, you MUST sell all of the shares you own.*** 
    	
    	*** - Because the risk of losing money is too big during 
    		  the after hour trading period
	
	Once simulation of trading stock is complete, program will move
	on to the Output
		
OUTPUT

	Output from program will be shown on console & written to an Excel file
	Output will be split into 9 columns:
	
	1. Time Stamp
	2. Current Price
	3. Shares
	4. P/L Percent (Profit/Loss Percentage)
	5. Profit/Loss
	6. Realized Profit/Loss
	7. Hold/None (If we have stocks or not)
	8. Purchase/Sell Price
	9. Purchase Cost

ASSUMPTIONS
- None

*/

//**********************
//*	START OF PROGRAM   *	
//**********************

import java.io.*;			//Imports all of the I/O classes so the output file classes may be used
import java.util.Scanner;	//Imports the Scanner Utility Object

public class SimpleAlgorithmTradingPlatform {

	public static void main(String[] args) throws IOException {
		//Declares the scanner input object for the input file name
		Scanner input = new Scanner(System.in);
		//Sets the string variable to the user input file name
		String fName = input.nextLine();
		//Declares and initializes to the output file the PrintWriter object.
		//Used to print to the given file.
		PrintWriter f = new PrintWriter("TradingSummary.csv");
		//Deletes the content before printing this sessions content
		f.flush();
		//Declares a new AlgorithmTrader object to be used to execute
		//the method run()
		AlgorithmTrader trader = new AlgorithmTrader();
		//Executes the program
		trader.Run(fName, f);
		//Closes the file object and the input object
		f.close();
		input.close();
	}

}
