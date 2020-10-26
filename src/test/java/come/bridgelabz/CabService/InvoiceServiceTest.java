package come.bridgelabz.CabService;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import come.bridgelabz.CabService.Ride.rideType;

public class InvoiceServiceTest {
 InvoiceService invoiceservice = null;
	
	@Before
	public void initialise() {
		invoiceservice = new InvoiceService();
	}
	@Test
	public void givenDistAndTime_ShouldReturnFare() {
		double dist = 2.0;
		int time = 5;
		double fare = invoiceservice.getFare(dist, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistAndTime_ShouldReturnMinFare() {
		double dist = 0.1;
		int time = 1;
		double fare = invoiceservice.getFare(dist, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnTotalFare() {
		Ride[] rides = { new Ride(2.0, 5, rideType.REGULAR), new Ride(0.1, 1, rideType.REGULAR) };
		double fare = invoiceservice.getFare(rides);
		Assert.assertEquals(30, fare, 0.0);

	}

	@Test
	public void givenMultipleRides_ShouldReturnEnhancedInvoice() {
		Ride[] rides = { new Ride(2.0, 5, rideType.REGULAR), new Ride(0.1, 1, rideType.REGULAR) };
		EnhancedInvoice summary = invoiceservice.getEnhancedInvoice(rides);
		EnhancedInvoice expectedSummary = new EnhancedInvoice(2, 30,15);
		Assert.assertEquals(expectedSummary,summary);
	}

	@Test
	public void givenUserId_ShouldReturnEnhancedInvoice() {
		Ride[] rides ={ new Ride(2.0, 5,rideType.REGULAR), new Ride(0.1, 1,rideType.REGULAR) };
		RideRepository.add("praneetha", new ArrayList<Ride>(Arrays.asList(rides)));
		EnhancedInvoice summary = invoiceservice.getRideFromUserId("praneetha");
		EnhancedInvoice expectedSummary = new EnhancedInvoice(2, 30,15);
		Assert.assertEquals(expectedSummary,summary);
	}
	
	@Test
	public void givenUserIdandPremium_ShouldReturnEnhancedInvoice() {
		Ride[] rides = { new Ride(2.0, 5, rideType.REGULAR), new Ride(0.1, 1, rideType.PREMIUM) };
		RideRepository.add("pranee", new ArrayList<Ride>(Arrays.asList(rides)));
		EnhancedInvoice summary = invoiceservice.getRideFromUserId("pranee");
		EnhancedInvoice expectedSummary = new EnhancedInvoice(2, 45,22.5);
		Assert.assertEquals(expectedSummary,summary);
	}
}
