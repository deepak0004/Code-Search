package q6;

public enum Planets {
	Earth(1), Venus(.907), Mercury(0.378), Mars(0.377), Jupiter(2.364), Saturn(
			1.064), Uranus(0.889), Neptune(1.125), Pluto(0.067);
	double value;

	private Planets(double value) {
		this.value = value;
	}

}
