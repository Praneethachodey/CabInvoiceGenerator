package come.bridgelabz.CabService;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import come.bridgelabz.CabService.Ride.rideType;

public class InvoiceServiceTest {

	@Test
	public void givenDistAndTime_ShouldReturnFare() {
		InvoiceService invoiceservice = new InvoiceService();
		double dist = 2.0;
		int time = 5;
		double fare = invoiceservice.getFare(dist, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistAndTime_ShouldReturnMinFare() {
		InvoiceService invoiceservice = new InvoiceService();
		double dist = 0.1;
		int time = 1;
		double fare = invoiceservice.getFare(dist, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_ShouldReturnTotalFare() {
		InvoiceService invoiceservice = new InvoiceService();
		Ride[] rides = { new Ride(2.0, 5, rideType.REGULAR), new Ride(0.1, 1, rideType.REGULAR) };
		double fare = invoiceservice.getFare(rides);
		Assert.assertEquals(30, fare, 0.0);

	}

	@Test
	public void givenMultipleRides_ShouldReturnEnhancedInvoice() {
		InvoiceService invoiceservice = new InvoiceService();
		Ride[] rides = { new Ride(2.0, 5, rideType.REGULAR), new Ride(0.1, 1, rideType.REGULAR) };
		EnhancedInvoice summary = invoiceservice.getEnhancedInvoice(rides);
		Assert.assertEquals(30, summary.totalFare, 0.0);
		Assert.assertEquals(2, summary.totalNoOfRides);
		Assert.assertEquals(15, summary.avgFare, 0.0);
	}

	@Test
	public void givenUserId_ShouldReturnEnhancedInvoice() {
		InvoiceService invoiceservice = new InvoiceService();
		Ride[] rides ={ new Ride(2.0, 5,rideType.REGULAR), new Ride(0.1, 1,rideType.REGULAR) };
		RideRepository.add("praneetha", new ArrayList<Ride>(Arrays.asList(rides)));
		EnhancedInvoice summary = invoiceservice.getRideFromUserId("praneetha");
		Assert.assertEquals(30, summary.totalFare, 0.0);
		Assert.assertEquals(2, summary.totalNoOfRides);
		Assert.assertEquals(15, summary.avgFare, 0.0);
	}
	
	@Test
	public void givenUserIdandPremium_ShouldReturnEnhancedInvoice() {
		InvoiceService invoiceservice = new InvoiceService();
		Ride[] rides = { new Ride(2.0, 5, rideType.REGULAR), new Ride(0.1, 1, rideType.PREMIUM) };
		RideRepository.add("pranee", new ArrayList<Ride>(Arrays.asList(rides)));
		EnhancedInvoice summary = invoiceservice.getRideFromUserId("pranee");
		Assert.assertEquals(45, summary.totalFare, 0.0);
		Assert.assertEquals(2, summary.totalNoOfRides);
		Assert.assertEquals(22.5, summary.avgFare, 0.0);
	}
}
