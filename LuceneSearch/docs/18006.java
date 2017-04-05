package q6;
import java.util.*;

enum Planet 
{
	MERCURY(0.38), VENUS(0.91), EARTH(1.00), MARS(0.38), JUPITER(2.54), SATURN(1.08), URANUS(.91), NEPTUNE(1.19); 	// types
	
	double relation;
	
	Planet(double x) //enum constructor 	// types
	{
		this.relation = x; 	// integer
	}
	

	
}; //datatype Planet with attribute 	// types,functions,while,list

public class planets 
{
	public static void main(String[] args) 
	{
		
		double weight = Double.parseDouble(args[0]); 	// types,double,integer
		
		for(Planet p : Planet.values()) 	// types
		{
				double weightNew = weight*(p.relation); 	// types,double,integer,pointers
				
				System.out.println("Your weight on "+p+" is "+weightNew+" kilograms."); //provided the input is also in kgs. 	// types,string,array,loop
		}
		
	}

}

//Planet planetName; //every class planets has an attribute planetName

	/*public planets(Planet planetName) //constructor for every class planets
	{
		this.planetName = planetName; 	// integer
	}*/ 	// types,functions,while,list
	
	/*public double convert(double wt) //converts weight respectively
	{
		double wtnew = 0; 	// double,integer
		
		switch(planetName) 	// types
		{
		case MERCURY: wtnew = wt*0.38; break; 	// integer,pointers
		case VENUS: wtnew = wt*0.91; break; 	// integer,pointers
		case EARTH: wtnew =  wt; break; 	// integer
		case MARS: wtnew =  wt*0.38; break; 	// integer,pointers
		case JUPITER: wtnew =  wt*2.54; break; 	// integer,pointers
		case SATURN: wtnew = wt*1.08; break; 	// integer,pointers
		case URANUS: wtnew = wt*0.91; break; 	// integer,pointers
		case NEPTUNE: wtnew = wt*1.19; break; 	// integer,pointers
		}
		
		return wtnew;
	}*/ 	// types,functions,while,list
