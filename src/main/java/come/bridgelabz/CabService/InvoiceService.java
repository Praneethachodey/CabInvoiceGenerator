package come.bridgelabz.CabService;

public class InvoiceService {

	private static final int MIN_COST_MIN = 1;
	private static final double MIN_COST_PER_KM = 10;
	private static final double MINIMUM_FARE = 5;

	/**
	 * 
	 * @param dist
	 * @param time
	 * @return fare calculated using distance and time
	 */
	public double getFare(double dist, int time) {
		double fare = (dist * MIN_COST_PER_KM) + (time * MIN_COST_MIN);
		if (fare < MINIMUM_FARE) {
			fare = MINIMUM_FARE;
		}
		return fare;
	}

	/**
	 * 
	 * @param rides
	 * @return fare calculated for multiple rides
	 */
	public double getFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare = totalFare + getFare(ride.getDist(), ride.getTime());
		}
		
		return totalFare;
	}
	
	public EnhancedInvoice getEnhancedInvoice(Ride[] rides) {
		if(rides.length==0) return null;
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare = totalFare + getFare(ride.getDist(), ride.getTime());
		}
		EnhancedInvoice summary = new EnhancedInvoice(rides.length,totalFare, totalFare/rides.length);
		return summary;
	}

}
