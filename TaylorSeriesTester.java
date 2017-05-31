
public class TaylorSeriesTester {

	public static void main(String[] args) {
		TaylorSeries taylor = new TaylorSeries();
		taylor.geometricSeriesApproximation(.25);
		System.out.println(taylor.getApproximation());

	}

}
