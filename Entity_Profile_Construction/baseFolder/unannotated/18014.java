package ap2014.assignment1.question6;

public enum Planets {
	MERCURY (3.303e+23,2.4397e6),
    VENUS   (4.869e+24,6.0518e6),
    EARTH   (5.976e+24,6.37814e6),
    MARS    (6.421e+23,3.3972e6),
    JUPITER (1.9e+27,7.1492e7),
    SATURN  (5.688e+26,6.0268e7),
    URANUS  (8.686e+25,2.5559e7),
    NEPTUNE (1.024e+26,2.4746e7);

    double mass;   
    double radius; 
    Planets(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    public static final double gConstant = 6.67300E-11;

    public double weigthOnPlanet(double personMass){
    	return  personMass*gConstant*mass/(radius*radius);
    }
    double surfaceGravity() {
        return gConstant * mass / (radius * radius);
    }
    
    public static double netMass(double weight) {
        return weight*EARTH.radius*EARTH.radius/(gConstant*EARTH.mass);
    }
}
