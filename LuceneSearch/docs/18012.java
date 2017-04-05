public enum Planet {
	Earth (1.0), 	// types
	Mercury (6.8), 	// types
	Venus (1.85), 	// types
	Mars (4.85), 	// types
	Jupiter (3.85), 	// types
	Saturn (8.85), 	// types
	Uranus (6.5), 	// types
	Neptune (2.5), 	// types
	Pluto (5.6); 	// types

    public double ratio_wrt_earth;

    Planet(double ratio_wrt_earth) { 	// types
        this.ratio_wrt_earth = ratio_wrt_earth; 	// integer
    }
}
