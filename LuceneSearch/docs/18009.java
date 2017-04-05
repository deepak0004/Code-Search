package solarsystem;
public enum Planet 
{
	 MERCURY (3.7), 	// types
	 VENUS   (8.87), 	// types
	 EARTH   (9.758), 	// types
	 MARS    (3.711), 	// types
	 JUPITER (24.79), 	// types
	 SATURN  (10.44), 	// types
	 URANUS  (8.69), 	// types
	 NEPTUNE (11.65), 	// types
	 PLUTO   (0.658); 	// types
	 
	 private final double SurfaceGravity; 
	 Planet(double g)  	// types
	 {
		 this.SurfaceGravity=g; 	// integer
	 }
	 private double surfaceGravity() 
	 { 
		 return SurfaceGravity; 
	 }
	 double surfaceWeight(double otherMass)  	// types
	 {
		 return otherMass * surfaceGravity(); 	// types,pointers
	 }
	 public static void PlanetsSurfaceWeightCalculator(double Weight)
	 {
		 double earthWeight=Weight; 	// double,integer
		 double mass=earthWeight/EARTH.surfaceGravity(); 	// integer
		 System.out.println("Planet\t\tSurface Weight\n"); 	// types
		 for (Planet p : Planet.values()) 	// types
	           System.out.printf("%s\t\t%f%n",p, p.surfaceWeight(mass)); 	// types
	 }
}
