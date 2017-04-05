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
		if(planetname.equals(Planets.mercury))
			System.out.println(planetname+" "+w*0.378+" kg");
		else if(planetname.equals(Planets.venus))
			System.out.println(planetname+" "+ w*0.907+" kg");
		else if(planetname.equals(Planets.earth))
			System.out.println(planetname+" "+w+" kg");				
		else if(planetname.equals(Planets.mars))
			System.out.println(planetname+" "+ w*0.377+" kg");	
		else if(planetname.equals(Planets.jupiter))
			System.out.println(planetname+" "+ w*2.364+" kg");		
		else if(planetname.equals(Planets.saturn))
			System.out.println(planetname+" "+ w*1.064+" kg");	
		else if(planetname.equals(Planets.uranus))
			System.out.println(planetname+" "+ w*1.064+" kg");	
		else if(planetname.equals(Planets.neptune))
			System.out.println(planetname+" "+ w*1.125+" kg");	
	}
	
	public static void main(String args[])
	{
		
		double w = Double.parseDouble(args[0]);
		
		Question6 P1 = new Question6(Planets.mercury);
		P1.wght(w);
		
		Question6 P2 = new Question6(Planets.venus);
		P2.wght(w);
		
		Question6 P3 = new Question6(Planets.earth);
		P3.wght(w);
		
		Question6 P4 = new Question6(Planets.mars);
		P4.wght(w);
		
		Question6 P5 = new Question6(Planets.jupiter);
		P5.wght(w);
		
		Question6 P6 = new Question6(Planets.saturn);
		P6.wght(w);
		
		Question6 P7 = new Question6(Planets.uranus);
		P7.wght(w);
		
		Question6 P8 = new Question6(Planets.neptune);
		P8.wght(w);
		
	}
}
