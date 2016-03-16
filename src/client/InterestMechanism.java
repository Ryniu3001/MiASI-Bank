package client;

public class InterestMechanism {

	private double percentage;
	private int period;
	//mechanizm odsetkowy
	
	/**
	 * @param percentage oprocentowanie
	 * @param period czestotliwosc naliczania odsetek w miesi¹cach
	 */
	public InterestMechanism(double percentage, int period){
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
