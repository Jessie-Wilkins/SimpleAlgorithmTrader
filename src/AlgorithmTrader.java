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
			
			if(s.get(i+1).getClosingPrice() > s.get(i).getClosingPrice()){
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
		
		if(s.get(num+1).getClosingPrice()-s.get(num).getClosingPrice() > .12*s.get(num).getClosingPrice()){
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
		
		for(int i =0; i<stockFileData.size(); i=i+5) {
			entryBool= EntryStrategy(stockFileData, i);
			exitBool = ExitStrategy(stockFileData, i);
			double heldStock;
			double revenue;
			
			if(entryBool) {
				heldStock = 10000*stockFileData.get(i+4).getClosingPrice();
			}
			
			if(exitBool) {
				revenue = 10000*stockFileData.get(i+4).getClosingPrice();
			}
			
		}
		
	
	}
}
