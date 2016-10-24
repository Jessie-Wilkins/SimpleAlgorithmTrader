import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class AlgorithmTrader {
	
	public ArrayList<Stock> ReadInputData(String fName) {
		Scanner fCount = new Scanner(fName);
		Scanner fRead = new Scanner(fName);
		String dummyString;
		int i=0;
		ArrayList<Stock> a = new ArrayList<Stock>(100);
		int count = 0;
		
		while(fCount.hasNext()) {
			dummyString = fCount.nextLine();
			count++;
		}
		
		String [] array = new String[count];
		
		while(fRead.hasNext()) {
			array[i] = fRead.nextLine();
			i++;
		}
		for(i=0; i<array.length; i++) {
			String [] stockRecords = array[i].split("[,]");
			
			Stock s = new Stock();			
			a.add(s);
			
			a.get(i).setTimeStamp(stockRecords[0]);
			a.get(i).setOpeningPrice(Double.parseDouble(stockRecords[1]));
			a.get(i).setHighestPrice(Double.parseDouble(stockRecords[2]));
			a.get(i).setLowestPrice(Double.parseDouble(stockRecords[3]));
			a.get(i).setClosingPrice(Double.parseDouble(stockRecords[4]));
		}
		fCount.close();
		fRead.close();
		
		return a;
	}
	
	public boolean EntryStrategy(ArrayList<Stock> s, int num) {
		boolean b = false;

		for(int i = num; i<num+5; i++) {
			
			if(s.get(i+1).getClosingPrice() > s.get(i).getClosingPrice() && s.get(i).getHeldStocks() == 0){
				b = true;	
			}
			else {
				b = false;
			}
		}
		return b;
	
	}
	
	public boolean ExitStrategy(ArrayList<Stock> s, int num) {
		boolean b;
		
		if(s.get(num+1).getClosingPrice()-s.get(num).getClosingPrice() > .12*s.get(num).getClosingPrice() && s.get(num).getHeldStocks() != 0){
			b = true;
		}
		else{
			b = false;
		}
		return b;
	}
	
	public void Run(String fName, PrintWriter f) {
		
		ArrayList<Stock> stockFileData = new ArrayList<Stock>();
		
		stockFileData = ReadInputData(fName);
		
		boolean entryBool;
		boolean exitBool;
		
		stockFileData.get(0).printHeaders(f);
		
		for(int i =0; i<stockFileData.size(); i=i+5) {
			entryBool= EntryStrategy(stockFileData, i);
			exitBool = ExitStrategy(stockFileData, i);
			
			if(entryBool) {
				stockFileData.get(i).SetCurrentValueOfTotal(10000*stockFileData.get(i).getClosingPrice());
				stockFileData.get(i).SetHeldStocks(10000);
				stockFileData.get(i).SetPurchaseSellPrice(stockFileData.get(i).getClosingPrice());
				stockFileData.get(i).SetPurchaseCost(stockFileData.get(i).getCurrentValueOfTotal());
				stockFileData.get(i).setHoldingStatus("HOLD");
			}
			
			
			if(exitBool) {
				stockFileData.get(i).SetActualRevenue(stockFileData.get(i).getCurrentValueOfTotal() - stockFileData.get(i).getClosingPrice());
				stockFileData.get(i).setHoldingStatus("NONE");
				stockFileData.get(i).SetPurchaseSellPrice(stockFileData.get(i).getClosingPrice());
				stockFileData.get(i).SetHeldStocks(0);
			}
			
			if(stockFileData.get(i).getHoldingStatus().equals("HOLD")) {
				stockFileData.get(i).SetRevenue(stockFileData.get(i).getCurrentValueOfTotal() - stockFileData.get(i).getClosingPrice());
			}
			stockFileData.get(i).printResults();

			
		}
		
	
	}
}
