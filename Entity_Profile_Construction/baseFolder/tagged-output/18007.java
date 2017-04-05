package ap2014.asgnmnt1.mainclasses;

public class Question6 {

	
	public enum Planets {
		mercury, venus, earth, mars, jupiter, saturn, uranus, neptune
	}
	
	Planets planetname;
	public Question6(Planets inPlanet){
		this.planetname = inPlanet;
	}
	
	public void wght(double w) {
		if(planetname.equals(Planets.mercury)) 	// arguments
			System.out.println(planetname+" "+w*0.378+" kg"); 	// string,array,double,loop,parameter,while
		else if(planetname.equals(Planets.venus)) 	// arguments
			System.out.println(planetname+" "+ w*0.907+" kg"); 	// string,array,double,loop,parameter,while
		else if(planetname.equals(Planets.earth)) 	// arguments
			System.out.println(planetname+" "+w+" kg");				 	// string,array,double,loop,parameter,while
		else if(planetname.equals(Planets.mars)) 	// arguments
			System.out.println(planetname+" "+ w*0.377+" kg");	 	// string,array,double,loop,parameter,while
		else if(planetname.equals(Planets.jupiter)) 	// arguments
			System.out.println(planetname+" "+ w*2.364+" kg");		 	// string,array,double,loop,parameter,while
		else if(planetname.equals(Planets.saturn)) 	// arguments
			System.out.println(planetname+" "+ w*1.064+" kg");	 	// string,array,double,loop,parameter,while
		else if(planetname.equals(Planets.uranus)) 	// arguments
			System.out.println(planetname+" "+ w*1.064+" kg");	 	// string,array,double,loop,parameter,while
		else if(planetname.equals(Planets.neptune)) 	// arguments
			System.out.println(planetname+" "+ w*1.125+" kg");	 	// string,array,double,loop,parameter,while
	}
	
	public static void main(String args[])
	{
		
		double w = Double.parseDouble(args[0]); 	// variables,function,structure
		
		Question6 P1 = new Question6(Planets.mercury); 	// variables,list
		P1.wght(w);
		
		Question6 P2 = new Question6(Planets.venus); 	// variables,list
		P2.wght(w);
		
		Question6 P3 = new Question6(Planets.earth); 	// variables,list
		P3.wght(w);
		
		Question6 P4 = new Question6(Planets.mars); 	// variables,list
		P4.wght(w);
		
		Question6 P5 = new Question6(Planets.jupiter); 	// variables,list
		P5.wght(w);
		
		Question6 P6 = new Question6(Planets.saturn); 	// variables,list
		P6.wght(w);
		
		Question6 P7 = new Question6(Planets.uranus); 	// variables,list
		P7.wght(w);
		
		Question6 P8 = new Question6(Planets.neptune); 	// variables,list
		P8.wght(w);
		
	}
}
