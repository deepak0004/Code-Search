//author sahilbabbar 2013082
package Question6;
enum Planets {
   mercury(0.38),venus(0.91), mars(0.38),earth(1),jupiter(2.14), saturn(0.91), uranus(0.86), neptune(1.1), pluto(0.08);
   private double weight;
   Planets(double p) {
      weight = p;
   }
   double getWeight() {
	   return weight;
   } 
}