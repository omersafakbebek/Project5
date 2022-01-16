import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class project5main {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(new File(args[0]));
		PrintStream out= new PrintStream(new File(args[1]));
		ArrayList<Offer> offers= new ArrayList<>();
		String types[]= in.nextLine().split(" ");
		String timesA[]= in.nextLine().split(" ");
		String timesB[]= in.nextLine().split(" ");
		String profits[]=in.nextLine().split(" ");
		String arrivalTimes[]= in.nextLine().split(" ");
		
		for(int i=0;i<types.length;i++) {
			String type= types[i];
			int start=Integer.valueOf(arrivalTimes[i]);
			int time;
			int profit=Integer.valueOf(profits[i]);
			
			if(type.equals("s")) {
				time = Integer.valueOf(timesA[i]);		
				
			}else {
				time = Integer.valueOf(timesB[i]);
			}
			Offer newOffer= new Offer(start,start+time,profit);
			offers.add(newOffer);
		}Collections.sort(offers);		
		offers.get(0).maxProfit=offers.get(0).profit;
		for(int i=1; i<types.length;i++) {			
			int j=i-1;
			while(j>=0&& offers.get(j).end>offers.get(i).start) {
				j=j-1;
			}					
			if(j==-1) {
				offers.get(i).maxProfit=offers.get(i).profit;
				if(offers.get(i-1).maxProfit>offers.get(i).maxProfit) {
					offers.get(i).maxProfit=offers.get(i-1).maxProfit;
				}
			}else {
				offers.get(i).maxProfit=offers.get(i).profit+offers.get(j).maxProfit;
				if(offers.get(i-1).maxProfit>offers.get(i).maxProfit) {
					offers.get(i).maxProfit=offers.get(i-1).maxProfit;
				}
			}
		}out.print(offers.get(offers.size()-1).maxProfit);
	}
}
