public enum Planet {
	Earth (1.0),
	Mercury (6.8),
	Venus (1.85),
	Mars (4.85),
	Jupiter (3.85),
	Saturn (8.85),
	Uranus (6.5),
	Neptune (2.5),
	Pluto (5.6);

    public double ratio_wrt_earth;

    Planet(double ratio_wrt_earth) {
        this.ratio_wrt_earth = ratio_wrt_earth;
    }
}
