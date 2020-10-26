package come.bridgelabz.CabService;

public class EnhancedInvoice {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avgFare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalFare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + totalNoOfRides;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnhancedInvoice other = (EnhancedInvoice) obj;
		if (Double.doubleToLongBits(avgFare) != Double.doubleToLongBits(other.avgFare))
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		if (totalNoOfRides != other.totalNoOfRides)
			return false;
		return true;
	}

	int totalNoOfRides;
	double totalFare;
	double avgFare;

	public EnhancedInvoice(int totalNoOfRides, double totalFare, double avgFare) {
		this.totalNoOfRides = totalNoOfRides;
		this.totalFare = totalFare;
		this.avgFare = avgFare;
	}

}
