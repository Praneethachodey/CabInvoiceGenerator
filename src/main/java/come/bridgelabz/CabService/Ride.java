package come.bridgelabz.CabService;

public class Ride {
	private double dist;
	private int time;

	enum rideType {
		PREMIUM, REGULAR
	};

	private rideType type;

	public double getDist() {
		return dist;
	}

	public rideType getType() {
		return type;
	}

	public void setType(rideType type) {
		this.type = type;
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

	Ride(double dist, int time, rideType type) {
		this.dist = dist;
		this.time = time;
		this.type = type;

	}

}
