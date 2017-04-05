package ap2014.asgnmnt1.question6;

import java.util.Scanner;

public class Question6 {
{

    public static void main(String[] args) {
    
System.out.println("Enter your mass(Kg)");
Scanner scan;
    scan = new Scanner(System.in); 	// variables,list
    double weight;
    weight = scan.nextDouble(); 	// variables
for (Planets planet : Planets.values()) 	// arguments
{
System.out.println("Weight on planet "+ planet.toString() +" = "+ (planet.gravity*weight)+" Newton"); 	// string,array,double,loop,parameter,function,arguments,while,structure
}
}
 
    /**
     *
     */
    public enum Planets 
{
Mercury(0.38), 
Venus(0.91), 
Earth(0.98), 
Mars(0.38),
Jupiter(2.54), 
Saturn(1.07), 
Uranus(0.9),
Neptune(1.15),
Pluto(0.08);

    private double gravity;

    private Planets(double value) 
    {
            this.setGravity(value);
    }

public double getGravity() 
{
return gravity;
}
 
        /**
         *
         * @param gravity
         */
        public void setGravity(double gravity) 
{
this.gravity = gravity;
}   };  

    /**
     *
     * @param args
     */
    @SuppressWarnings("resource")
