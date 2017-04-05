public enum Planet 
{
	
    	MERCURY (3.303e+23, 2.4397e6),
    	VENUS   (4.869e+24, 6.0518e6),
    	EARTH   (5.976e+24, 6.37814e6),
    	MARS    (6.421e+23, 3.3972e6),
    	JUPITER (1.9e+27,   7.1492e7),
    	SATURN  (5.688e+26, 6.0268e7),
    	URANUS  (8.686e+25, 2.5559e7),
    	NEPTUNE (1.024e+26, 2.4746e7);
	private final double m,r;
    	//private final double r;
	public static final double G = 6.67300E-11;
    	Planet(double m, double r) 
	{
        	this.m = m;
        	this.r = r;
    	}
	private double r() 
	{
 		return r; 
	}
    	private double m() 
	{ 
		return m; 
	}
    	
	double sG() 
	{
        	return G * m / (r * r);
    	}
    	double sW(double oMass) 
	{
        	return oMass * sG(); 	// method
    	}
    	public static void main(String[] args) 
	{
        	while(args.length != 1) 
		{
            		System.err.println("After typing 'java Planet',Please provide space and then weight on earth");
            		System.exit(-1);
        	}
        	double earthW = Double.parseDouble(args[0]); 	// variables,function,structure
        	double m = earthW/EARTH.sG();
        	for (Planet p : Planet.values()) 	// arguments
           	System.out.printf("Your weight on %s will be  %f%n",p, p.sW(m)); 	// arguments
    	}
}
