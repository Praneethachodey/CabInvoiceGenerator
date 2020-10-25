package come.bridgelabz.CabService;

import org.junit.Assert;
import org.junit.Test;

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
		Ride[] rides = { new Ride(2.0, 5), new Ride(0.1, 1) };
		double fare =invoiceservice.getFare(rides);
		Assert.assertEquals(30, fare,0.0);
		
	}
}
