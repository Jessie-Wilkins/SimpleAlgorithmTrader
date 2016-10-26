import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class AlgorithmTrader {
	
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
		for(i=1; i<array.length-1; i++) {
			String [] stockRecords = array[i+1].split("[,]");
			
			Stock s = new Stock();			
			a.add(s);
			
			a.get(i-1).setTimeStamp(stockRecords[0]);
			a.get(i-1).setOpeningPrice(Double.parseDouble(stockRecords[1]));
			a.get(i-1).setHighestPrice(Double.parseDouble(stockRecords[2]));
			a.get(i-1).setLowestPrice(Double.parseDouble(stockRecords[3]));
			a.get(i-1).setClosingPrice(Double.parseDouble(stockRecords[4]));
		}
		fCount.close();
		fRead.close();
		
		return a;
	}
	
	public boolean EntryStrategy(ArrayList<Stock> s, int num) {
		boolean b = false;
		int i = 0;
		int j=0;

		while(i!=4) {
			
			if(s.get(i+1).getClosingPrice() > s.get(i).getClosingPrice() && s.get(i).getHeldStocks() == 0 && i<=s.size()){
				j++;
			}
			i++;
		}
		if(j==4) {
			b =true;
		}
		else {
				b = false;
		}

		return b;
	
	}
	
	public boolean ExitStrategy(ArrayList<Stock> s, int num) {
		boolean b;
		
		if(s.get(num+1).getClosingPrice()-s.get(num).getClosingPrice() >= .0012*s.get(num).getClosingPrice() || s.get(num+1).getClosingPrice()-s.get(num).getClosingPrice() <= -.0012*s.get(num).getClosingPrice() && s.get(num).getHeldStocks() != 0){
			b = true;
		}
		else{
			b = false;
		}
		return b;
}
	
	public void Run(String fName, PrintWriter f) throws IOException{
		
		ArrayList<Stock> stockFileData = new ArrayList<Stock>();
		
		stockFileData = ReadInputData(fName);
		
		boolean entryBool;
		boolean exitBool;
		
		stockFileData.get(0).printHeaders(f);
		
		for(int i =0; i<stockFileData.size()-1; i++) {
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
				stockFileData.get(i).SetActualRevenue(10000*stockFileData.get(i).getClosingPrice()-stockFileData.get(i).getCurrentValueOfTotal());
				stockFileData.get(i).setHoldingStatus("NONE");
				stockFileData.get(i).SetPurchaseSellPrice(stockFileData.get(i).getClosingPrice());
				stockFileData.get(i).SetHeldStocks(0);
			}
			
			if(stockFileData.get(i).getHoldingStatus().equals("HOLD")) {
				stockFileData.get(i).SetRevenue(10000*stockFileData.get(i).getClosingPrice()-stockFileData.get(i).getCurrentValueOfTotal());
			}
			stockFileData.get(i).printResults();

			
		}
		
	
	}
}
