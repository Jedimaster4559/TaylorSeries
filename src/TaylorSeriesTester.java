
public class TaylorSeriesTester {

	public static void main(String[] args) {
		TaylorSeries taylor = new TaylorSeries();
		taylor.geometricSeriesApproximation(.5);
		System.out.println(taylor.getApproximation());

	}

}
