package client;

public class Interest {

	private double percentage;
	private int period;
	
	/**
	 * 
	 * @param percentage oprocentowanie
	 * @param period czestotliwosc naliczania odsetek w miesi¹cach
	 */
	public Interest(double percentage, int period){
		this.percentage = percentage;
		this.period = period;
	}

	public double getPercentage() {
		return percentage;
	}

	public int getPeriod() {
		return period;
	}
}
