package come.bridgelabz.CabService;

import java.util.List;

import come.bridgelabz.CabService.Ride.rideType;

public class InvoiceService {

	private static final int MIN_COST_MIN = 1;
	private static final double MIN_COST_PER_KM = 10;
	private static final int PREMIUM_MIN_COST_MIN = 2;
	private static final double PREMIUM_MIN_COST_PER_KM = 15;
	private static final double MINIMUM_FARE = 5;
	private static final double PREMIUM_MINIMUM_FARE = 20;

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

	public double getPremiumFare(double dist, int time) {
		double fare = (dist * PREMIUM_MIN_COST_PER_KM) + (time * PREMIUM_MIN_COST_MIN);
		if (fare < PREMIUM_MINIMUM_FARE) {
			fare = PREMIUM_MINIMUM_FARE;
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

	/**
	 * 
	 * @param rides
	 * @return enhanced invoice
	 */

	public EnhancedInvoice getEnhancedInvoice(Ride[] rides) {
		if (rides.length == 0)
			return null;
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += ride.getType() == rideType.REGULAR ? getFare(ride.getDist(), ride.getTime())
					: getPremiumFare(ride.getDist(), ride.getTime());
		}
		EnhancedInvoice summary = new EnhancedInvoice(rides.length, totalFare, totalFare / rides.length);
		return summary;
	}

	/**
	 * 
	 * @param userId
	 * @return enhanced invoice by using userid
	 */

	public EnhancedInvoice getRideFromUserId(String userId) {
		List<Ride> rides = RideRepository.getRides(userId);
		if (rides == null)
			return null;
		return getEnhancedInvoice(rides.toArray(new Ride[rides.size()]));
	}

}
