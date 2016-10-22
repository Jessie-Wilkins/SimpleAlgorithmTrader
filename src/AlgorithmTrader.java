import java.util.ArrayList;
import java.util.Scanner;

public class AlgorithmTrader {
	
	public ArrayList<Stock> ReadInputData(Scanner f, Stock s) {
		
		ArrayList<Stock> a = null;
		return a;
	}
	
	public boolean EntryStrategy(ArrayList<Stock> s, int num) {
		boolean b = false;

		for(int i = num; i<num+5; i++) {
			
			if(s.get(i+1).getCurrentPrice() > s.get(i).getCurrentPrice()){
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
		
		if(s.get(num+1).getCurrentPrice()-s.get(num).getCurrentPrice() > .12*s.get(num).getCurrentPrice()){
			b = true;
		}
		else{
			b = false;
		}
		return b;
	}
	
	public void Run() {
	
	}
}
