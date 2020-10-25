package come.bridgelabz.CabService;

import java.util.*;

public class RideRepository {

	static Map<String, List<Ride>> rideRepository = new HashMap<>();

	public static void add(String userId, List<Ride> rides) {
		if (rideRepository.containsKey(userId))
			for (Ride ride : rides)
				rideRepository.get(userId).add(ride);
		else
			rideRepository.put(userId, rides);
	}

	public static List<Ride> getRides(String userId) {
		if (!rideRepository.containsKey(userId))
			return null;
		else
			return rideRepository.get(userId);
	}
}
