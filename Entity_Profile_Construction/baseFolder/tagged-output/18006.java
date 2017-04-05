package q6;
import java.util.*;

enum Planet 
{
	MERCURY(0.38), VENUS(0.91), EARTH(1.00), MARS(0.38), JUPITER(2.54), SATURN(1.08), URANUS(.91), NEPTUNE(1.19); 	// function,arguments
	
	double relation;
	
	Planet(double x) //enum constructor
	{
		this.relation = x;
	}
	

	
}; //datatype Planet with attribute

public class planets 
{
	public static void main(String[] args) 
	{
		
		double weight = Double.parseDouble(args[0]); 	// variables,function,structure
		
		for(Planet p : Planet.values()) 	// arguments
		{
				double weightNew = weight*(p.relation); 	// variables
				
				System.out.println("Your weight on "+p+" is "+weightNew+" kilograms."); //provided the input is also in kgs. 	// string,array,double,loop,parameter,while
		}
		
	}

}

//Planet planetName; //every class planets has an attribute planetName

	/*public planets(Planet planetName) //constructor for every class planets
	{
		this.planetName = planetName;
	}*/
	
	/*public double convert(double wt) //converts weight respectively
	{
		double wtnew = 0;
		
		switch(planetName)
		{
		case MERCURY: wtnew = wt*0.38; break;
		case VENUS: wtnew = wt*0.91; break;
		case EARTH: wtnew =  wt; break;
		case MARS: wtnew =  wt*0.38; break;
		case JUPITER: wtnew =  wt*2.54; break;
		case SATURN: wtnew = wt*1.08; break;
		case URANUS: wtnew = wt*0.91; break;
		case NEPTUNE: wtnew = wt*1.19; break;
		}
		
		return wtnew;
	}*/
