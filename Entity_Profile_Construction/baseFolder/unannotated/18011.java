package planet.java;

public enum Planets {
	Mercury(0.37), Venus(0.9), Earth(1), Mars(0.37), Jupiter(2.36), Saturn(0.91), Uranus(0.88), Neptune(1.12);
	
	private double value;
	private Planets(double n){
		value=n;
	}
	
	public double getStatus(){
		return value;
	}
}