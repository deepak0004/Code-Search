package asgn1ques6;

public enum Ques6 {
	Mercury(0.38), Venus(0.9), Earth(1), Mars(0.38), Jupiter(2.36), Saturn(0.91), Uranus(0.88), Neptune(1.12);
	
	private double val;
	private Ques6(double i){
		val = i;
	}
	
	public double getStatus(){
		return val;
	}
}