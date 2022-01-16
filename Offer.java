
public class Offer implements Comparable<Offer>{
	int start;
	int end;
	int profit;
	int maxProfit=0;
	
	Offer(int start,int end,int profit){
		this.start=start;
		this.end=end;
		this.profit=profit;		
	}

	@Override
	public int compareTo(Offer o) {
		// TODO Auto-generated method stub
		return this.end-o.end;
	}
}
