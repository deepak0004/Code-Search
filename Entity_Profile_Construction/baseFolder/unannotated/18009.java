package solarsystem;
public enum Planet 
{
	 MERCURY (3.7),
	 VENUS   (8.87),
	 EARTH   (9.758),
	 MARS    (3.711),
	 JUPITER (24.79),
	 SATURN  (10.44),
	 URANUS  (8.69),
	 NEPTUNE (11.65),
	 PLUTO   (0.658);
	 
	 private final double SurfaceGravity; 
	 Planet(double g) 
	 {
		 this.SurfaceGravity=g;
	 }
	 private double surfaceGravity() 
	 { 
		 return SurfaceGravity; 
	 }
	 double surfaceWeight(double otherMass) 
	 {
		 return otherMass * surfaceGravity();
	 }
	 public static void PlanetsSurfaceWeightCalculator(double Weight)
	 {
		 double earthWeight=Weight;
		 double mass=earthWeight/EARTH.surfaceGravity();
		 System.out.println("Planet\t\tSurface Weight\n");
		 for (Planet p : Planet.values())
	           System.out.printf("%s\t\t%f%n",p, p.surfaceWeight(mass));
	 }
}
