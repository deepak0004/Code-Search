package ap2014.asgnmnt1.question6;

import java.util.Scanner;

public class Question6 {
{

    public static void main(String[] args) {
    
System.out.println("Enter your mass(Kg)"); 	// types
Scanner scan;
    scan = new Scanner(System.in); 	// types,arguments,integer,while
    double weight;
    weight = scan.nextDouble(); 	// types,integer
for (Planets planet : Planets.values()) 	// types
{
System.out.println("Weight on planet "+ planet.toString() +" = "+ (planet.gravity*weight)+" Newton"); 	// types,string,array,loop,pointers
}
}
 
    /**
     *
     */
    public enum Planets 
{
Mercury(0.38),  	// types
Venus(0.91),  	// types
Earth(0.98),  	// types
Mars(0.38), 	// types
Jupiter(2.54),  	// types
Saturn(1.07),  	// types
Uranus(0.9), 	// types
Neptune(1.15), 	// types
Pluto(0.08); 	// types

    private double gravity;

    private Planets(double value) 
    {
            this.setGravity(value); 	// types
    }

public double getGravity() 
{
return gravity;
}
 
        /**
         *
         * @param gravity 	// variables
         */
        public void setGravity(double gravity) 
{
this.gravity = gravity; 	// integer
}   };   	// types,functions,while,list

    /**
     *
     * @param args 	// variables
     */
    @SuppressWarnings("resource") 	// types
