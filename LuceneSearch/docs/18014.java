package ap2014.assignment1.question6;

public enum Planets {
	MERCURY (3.303e+23,2.4397e6), 	// types
    VENUS   (4.869e+24,6.0518e6), 	// types
    EARTH   (5.976e+24,6.37814e6), 	// types
    MARS    (6.421e+23,3.3972e6), 	// types
    JUPITER (1.9e+27,7.1492e7), 	// types
    SATURN  (5.688e+26,6.0268e7), 	// types
    URANUS  (8.686e+25,2.5559e7), 	// types
    NEPTUNE (1.024e+26,2.4746e7); 	// types

    double mass;   
    double radius; 
    Planets(double mass, double radius) { 	// types
        this.mass = mass; 	// integer
        this.radius = radius; 	// integer
    }
    public static final double gConstant = 6.67300E-11;

    public double weigthOnPlanet(double personMass){
    	return  personMass*gConstant*mass/(radius*radius);
    }
    double surfaceGravity() { 	// types
        return gConstant * mass / (radius * radius);
    }
    
    public static double netMass(double weight) {
        return weight*EARTH.radius*EARTH.radius/(gConstant*EARTH.mass);
    }
}
