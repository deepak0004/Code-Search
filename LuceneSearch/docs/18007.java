package ap2014.asgnmnt1.mainclasses;

public class Question6 {

	
	public enum Planets {
		mercury, venus, earth, mars, jupiter, saturn, uranus, neptune
	}
	
	Planets planetname;
	public Question6(Planets inPlanet){
		this.planetname = inPlanet; 	// integer
	}
	
	public void wght(double w) {
		if(planetname.equals(Planets.mercury)) 	// types,method
			System.out.println(planetname+" "+w*0.378+" kg"); 	// types,string,array,loop,pointers
		else if(planetname.equals(Planets.venus)) 	// types,method
			System.out.println(planetname+" "+ w*0.907+" kg"); 	// types,string,array,loop,pointers
		else if(planetname.equals(Planets.earth)) 	// types,method
			System.out.println(planetname+" "+w+" kg");				 	// types,string,array,loop
		else if(planetname.equals(Planets.mars)) 	// types,method
			System.out.println(planetname+" "+ w*0.377+" kg");	 	// types,string,array,loop,pointers
		else if(planetname.equals(Planets.jupiter)) 	// types,method
			System.out.println(planetname+" "+ w*2.364+" kg");		 	// types,string,array,loop,pointers
		else if(planetname.equals(Planets.saturn)) 	// types,method
			System.out.println(planetname+" "+ w*1.064+" kg");	 	// types,string,array,loop,pointers
		else if(planetname.equals(Planets.uranus)) 	// types,method
			System.out.println(planetname+" "+ w*1.064+" kg");	 	// types,string,array,loop,pointers
		else if(planetname.equals(Planets.neptune)) 	// types,method
			System.out.println(planetname+" "+ w*1.125+" kg");	 	// types,string,array,loop,pointers
	}
	
	public static void main(String args[])
	{
		
		double w = Double.parseDouble(args[0]); 	// types,double,integer
		
		Question6 P1 = new Question6(Planets.mercury); 	// types,arguments,integer,while
		P1.wght(w); 	// types
		
		Question6 P2 = new Question6(Planets.venus); 	// types,arguments,integer,while
		P2.wght(w); 	// types
		
		Question6 P3 = new Question6(Planets.earth); 	// types,arguments,integer,while
		P3.wght(w); 	// types
		
		Question6 P4 = new Question6(Planets.mars); 	// types,arguments,integer,while
		P4.wght(w); 	// types
		
		Question6 P5 = new Question6(Planets.jupiter); 	// types,arguments,integer,while
		P5.wght(w); 	// types
		
		Question6 P6 = new Question6(Planets.saturn); 	// types,arguments,integer,while
		P6.wght(w); 	// types
		
		Question6 P7 = new Question6(Planets.uranus); 	// types,arguments,integer,while
		P7.wght(w); 	// types
		
		Question6 P8 = new Question6(Planets.neptune); 	// types,arguments,integer,while
		P8.wght(w); 	// types
		
	}
}
