
public enum Planet {
    MERCURY (3.303e+23, 2.4397e6), 	// types
    VENUS   (4.869e+24, 6.0518e6), 	// types
    EARTH   (5.976e+24, 6.37814e6), 	// types
    MARS    (6.421e+23, 3.3972e6), 	// types
    JUPITER (1.9e+27,   7.1492e7), 	// types
    SATURN  (5.688e+26, 6.0268e7), 	// types
    URANUS  (8.686e+25, 2.5559e7), 	// types
    NEPTUNE (1.024e+26, 2.4746e7); 	// types

    private final double mass;   // in kilograms
    private final double radius; // in meters
    Planet(double mass, double radius) { 	// types
        this.mass = mass; 	// integer
        this.radius = radius; 	// integer
    }
    

    // universal gravitational constant  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    double surfaceGravity() { 	// types
        return G * mass / (radius * radius);
    }
    double surfaceWeight(double otherMass) { 	// types
        return otherMass * surfaceGravity(); 	// types,pointers
    }
    public static void main(String[] args) {
        
        
        double earthWeight = Double.parseDouble(args[0]); 	// types,double,integer
        double mass = earthWeight/EARTH.surfaceGravity(); 	// integer
        for (Planet p : Planet.values()) 	// types
           System.out.printf("Your weight on %s is %f%n", 	// types
                             p, p.surfaceWeight(mass)); 	// types
    }
}
