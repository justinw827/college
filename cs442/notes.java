public class Mocha extends CondimentDecorator {

	private Beverage bev;
	private double cost;

	public Mocha(Beverage bIn) {
		bev = bIn;
		cost = 10;
	}

	public double getCost() {
		return cost + super.getCost();
	}
}

public class Driver {
	public static void main (String[] args) {
		Beverage bev = new DarkRoast();
		Beverage bev1 = new Mocha(bev);
		Beverage bev2 = new Mocha(bev1);
		Beverage bev3 = new Whip(bev2);

		double totalCost = bev3.getCost();
	}
}




public class VideoWindow extends Window {

	public VideoWindow(WindowXImpl wIn) {
		WindowXImpl l = new DebianLinuxImpl();
		Window v = new VideoWindow(l);
		v.display();

	}

}