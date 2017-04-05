package question6;

public enum PlaneT{
	
	MERCURY	(3.7), 	// types
	VENUS	(8.872), 	// types
	EARTH	(9.78), 	// types
	MARS	(3.7), 	// types
	JUPITER	(24.79), 	// types
	SATURN	(10.44), 	// types
	URANUS	(8.87), 	// types
	NEPTUNE	(11.15); 	// types

	private final double surfaceGravity;
	
	PlaneT (double surfaceGravity){ 	// types
		this.surfaceGravity = surfaceGravity; 	// integer
	}

	public double getSG() {
		return surfaceGravity;
	}

	
}
