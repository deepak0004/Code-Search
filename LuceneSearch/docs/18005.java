public enum Planet 
{
    MERCURY (3.303e+23, 2.4397e6),/* THIS DATA HAS BEEN TAKEN FROM THE INTERNET*/ 	// types
    VENUS   (4.869e+24, 6.0518e6), 	// types
    EARTH   (5.976e+24, 6.37814e6), 	// types
    MARS    (6.421e+23, 3.3972e6), 	// types
    JUPITER (1.9e+27,   7.1492e7), 	// types
    SATURN  (5.688e+26, 6.0268e7), 	// types
    URANUS  (8.686e+25, 2.5559e7), 	// types
    NEPTUNE (1.024e+26, 2.4746e7); 	// types
    private double mass;  
    private double radius;
    public static double G = 6.67300E-11;/*TILL HERE*/
    Planet(double m, double r)  	// types
    {
        this.mass = m; 	// integer
        this.radius = r; 	// integer
    }
    private double mass() 
    {
    	return mass;
    }
    private double radius() 
    {
    	return radius;
    }
    double GRAVITY_ON_SURFACE()  	// types
    {
        return (G *mass/(radius*radius)); 	// types
    }
    double surfaceWeight(double earthMass) 	// types
    {
    	return earthMass * GRAVITY_ON_SURFACE(); 	// types,pointers
    }
    public static void main(String[] args)
    {
        double earthWeight = Double.parseDouble(args[0]); 	// types,double,integer
        double m = earthWeight/EARTH.GRAVITY_ON_SURFACE(); 	// integer
        for (Planet p : Planet.values()) 	// types
           System.out.printf("Your weight on %s is %f%n",p, p.surfaceWeight(m)); 	// types
    }
}
