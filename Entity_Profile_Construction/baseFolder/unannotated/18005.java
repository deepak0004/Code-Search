public enum Planet 
{
    MERCURY (3.303e+23, 2.4397e6),/* THIS DATA HAS BEEN TAKEN FROM THE INTERNET*/
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);
    private double mass;  
    private double radius;
    public static double G = 6.67300E-11;/*TILL HERE*/
    Planet(double m, double r) 
    {
        this.mass = m;
        this.radius = r;
    }
    private double mass() 
    {
    	return mass;
    }
    private double radius() 
    {
    	return radius;
    }
    double GRAVITY_ON_SURFACE() 
    {
        return (G *mass/(radius*radius));
    }
    double surfaceWeight(double earthMass)
    {
    	return earthMass * GRAVITY_ON_SURFACE();
    }
    public static void main(String[] args)
    {
        double earthWeight = Double.parseDouble(args[0]);
        double m = earthWeight/EARTH.GRAVITY_ON_SURFACE();
        for (Planet p : Planet.values())
           System.out.printf("Your weight on %s is %f%n",p, p.surfaceWeight(m));
    }
}