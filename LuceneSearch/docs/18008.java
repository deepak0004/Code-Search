public enum Planet 
{
	
    	MERCURY (3.303e+23, 2.4397e6), 	// types
    	VENUS   (4.869e+24, 6.0518e6), 	// types
    	EARTH   (5.976e+24, 6.37814e6), 	// types
    	MARS    (6.421e+23, 3.3972e6), 	// types
    	JUPITER (1.9e+27,   7.1492e7), 	// types
    	SATURN  (5.688e+26, 6.0268e7), 	// types
    	URANUS  (8.686e+25, 2.5559e7), 	// types
    	NEPTUNE (1.024e+26, 2.4746e7); 	// types
	private final double m,r;
    	//private final double r;
	public static final double G = 6.67300E-11;
    	Planet(double m, double r)  	// types
	{
        	this.m = m; 	// integer
        	this.r = r; 	// integer
    	}
	private double r() 
	{
 		return r; 
	}
    	private double m() 
	{ 
		return m; 
	}
    	
	double sG()  	// types
	{
        	return G * m / (r * r);
    	}
    	double sW(double oMass)  	// types
	{
        	return oMass * sG(); 	// types,pointers
    	}
    	public static void main(String[] args) 
	{
        	while(args.length != 1)  	// types,integer
		{
            		System.err.println("After typing 'java Planet',Please provide space and then weight on earth"); 	// types
            		System.exit(-1); 	// types
        	}
        	double earthW = Double.parseDouble(args[0]); 	// types,double,integer
        	double m = earthW/EARTH.sG(); 	// integer
        	for (Planet p : Planet.values()) 	// types
           	System.out.printf("Your weight on %s will be  %f%n",p, p.sW(m)); 	// types
    	}
}
