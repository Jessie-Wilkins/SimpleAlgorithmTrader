import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class AlgorithmTrader {
	private double currentValueOfTotal;
	private double purchaseSellPrice;
	private double purchaseCost;
	private double percentageOfRevenue;
	private double actualRevenue;
	private double revenue;
	private int heldStocks;
	private String holdingStatus;
	
	
	public AlgorithmTrader() {
		currentValueOfTotal=0;
		purchaseSellPrice = 0;
		purchaseCost = 0;
		percentageOfRevenue = 0;
		actualRevenue = 0;
		revenue = 0;
		heldStocks = 0;
		holdingStatus = "NONE";
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
	
	public void SetHeldStocks(int n) {
		heldStocks = n;
	}
	
	public void setHoldingStatus(String hs) {
		holdingStatus = hs;
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
	
	public int getHeldStocks() {
		return heldStocks;
	}
	
	public String getHoldingStatus() {
		return holdingStatus;
	}
	
	public void printResults(ArrayList<Stock> s, int i, PrintWriter f) {
		//Print results to screen for user to see the Stock Prices Fluctuation
		f.printf("%s,%f,%d,%f,%f,%f,%s,%f,%f\r\n", s.get(i).getTimeStamp(), s.get(i).getClosingPrice(), this.getHeldStocks(), this.GetPercentageOfRevenue(), this.getRevenue(), this.GetActualRevenue(), this.getHoldingStatus(), this.GetPurchaseSellPrice(), this.GetPurchaseCost());
	}
	
	public ArrayList<Stock> ReadInputData(String fName) throws IOException {
		File fileForCounting = new File(fName);
		File fileForReading = new File(fName);
		
		Scanner fCount = new Scanner(fileForCounting);
		Scanner fRead = new Scanner(fileForReading);
		String dummyString;
		int i=0;
		ArrayList<Stock> a = new ArrayList<Stock>(100);
		int count = 0;
		
		while(fCount.hasNextLine()) {
			dummyString = fCount.nextLine();
			count++;
		}
		
		String [] array = new String[count];
		
		while(i<count) {
			array[i] = fRead.nextLine();
			i++;
		}
		for(i=1; i<array.length; i++) {
			String [] stockRecords = array[i].split("[,]");
			
			Stock s = new Stock();			
			a.add(s);
			
			a.get(i-1).setTimeStamp(stockRecords[0]);
			a.get(i-1).setClosingPrice(Double.parseDouble(stockRecords[1]));
			a.get(i-1).setHighestPrice(Double.parseDouble(stockRecords[2]));
			a.get(i-1).setLowestPrice(Double.parseDouble(stockRecords[3]));
			a.get(i-1).setOpeningPrice(Double.parseDouble(stockRecords[4]));
			a.get(i-1).setVolumeOfStocks(Integer.parseInt(stockRecords[5]));
		}
		fCount.close();
		fRead.close();
		
		return a;
	}
	
	public boolean EntryStrategy(ArrayList<Stock> s, int num) {
		boolean b = false;
			
		if(num<s.size()-1){
			if(s.get(num+1).getClosingPrice() > s.get(num).getClosingPrice() && getHeldStocks() == 0){
				b =true;
			}
	
			else {
				b = false;
			}
		}
		return b;
	
	}
	
	public boolean ExitStrategy(ArrayList<Stock> s, int num) {
		boolean b = false;
		
		if(num<s.size()-1) {
			if(((s.get(num).getClosingPrice() - this.GetPurchaseSellPrice())/this.GetPurchaseSellPrice() >=.0012
					|| ((s.get(num).getClosingPrice()-this.GetPurchaseSellPrice())/this.GetPurchaseSellPrice()) <= -.0012 
					|| num==s.size()-2)
					&& getHeldStocks() == 10000 ){
				b = true;	
			}
			else{
				b = false;
			}
		}
		return b;
	}
	
	public void Run(String fName, PrintWriter f) throws IOException{
		
		ArrayList<Stock> stockFileData = new ArrayList<Stock>();
		
		stockFileData = ReadInputData(fName);
		
		boolean entryBool;
		boolean exitBool;
		
		stockFileData.get(0).printHeaders(f);
		
		int j=0;
		
		for(int i =0; i<stockFileData.size(); i++) {
			
			entryBool= EntryStrategy(stockFileData, i);
			exitBool = ExitStrategy(stockFileData, i);
			
			if(entryBool) {
				j++;
			}
			else {
				j=0;
			}
			
			if(j==5) {
				SetCurrentValueOfTotal(10000*stockFileData.get(i).getClosingPrice());
				SetHeldStocks(10000);
				SetPurchaseSellPrice(stockFileData.get(i).getClosingPrice());
				SetPurchaseCost(getCurrentValueOfTotal());
				setHoldingStatus("HOLD");
				j=0;
			}
			
			
			else if(exitBool) {
				SetPercentageOfRevenue((stockFileData.get(i).getClosingPrice()-GetPurchaseSellPrice())/GetPurchaseSellPrice());
				SetActualRevenue(10000*(stockFileData.get(i).getClosingPrice()-GetPurchaseSellPrice()));
				setHoldingStatus("NONE");
				SetPurchaseSellPrice(stockFileData.get(i).getClosingPrice());
				SetPurchaseCost(0);
				SetHeldStocks(0);
			}
			
			else if(i>0 && getHoldingStatus().equals("HOLD")) {
				SetRevenue(10000*(stockFileData.get(i).getClosingPrice()-GetPurchaseSellPrice()));
				SetPercentageOfRevenue((stockFileData.get(i).getClosingPrice()-GetPurchaseSellPrice())/GetPurchaseSellPrice());
				
			}
			//
			System.out.println(i);
			printResults(stockFileData ,i, f);

		}
		//stockFileData.get(stockFileData.size()).printResults();
		
	
	}
}
