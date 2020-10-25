package come.bridgelabz.CabService;

public class Ride {
	private double dist;
	private int time;
	
	public double getDist() {
		return dist;
	}

	public void setDist(double dist) {
		this.dist = dist;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	Ride(double dist,int time)
	{
		this.dist=dist;
		this.time=time;
	}

}
