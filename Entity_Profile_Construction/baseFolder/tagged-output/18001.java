package question6;

public enum PlaneT{
	
	MERCURY	(3.7),
	VENUS	(8.872),
	EARTH	(9.78),
	MARS	(3.7),
	JUPITER	(24.79),
	SATURN	(10.44),
	URANUS	(8.87),
	NEPTUNE	(11.15);

	private final double surfaceGravity;
	
	PlaneT (double surfaceGravity){
		this.surfaceGravity = surfaceGravity;
	}

	public double getSG() {
		return surfaceGravity;
	}

	
}
