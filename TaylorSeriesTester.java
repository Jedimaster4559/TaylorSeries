import java.util.List;
import java.util.ArrayList;
public class TaylorSeriesTester {
	
	private static List<String> passed = new ArrayList<String>();
	private static List<String> failed = new ArrayList<String>();

	public static void main(String[] args) {
		geometricTest();
		System.out.println();
		
		printResults();
		
		

	}
	
	public static void geometricTest(){
		TaylorSeries taylor = new TaylorSeries();
		taylor.geometricSeriesApproximation(.5);			//tests .5 to determine if approximation is accurate
		if(taylor.getApproximation() != 1.99993896484375){	//result of approximation
			System.out.println("Geometric Failed");
			failed.add("Geometric Failed");
		}
		else{
			System.out.println("Geometric Passed");
			passed.add("Geometric Passed");
		}
	}
	
	public static void printResults(){
		System.out.println("Tests that Passed");
		System.out.println("-----------------");
		for(String x:passed){
			System.out.println(x);
		}
		System.out.println("-----------------");
		System.out.println("Total Passed: " + passed.size());
		System.out.println();
		
		System.out.println("Tests that Failed");
		System.out.println("-----------------");
		for(String x:failed){
			System.out.println(x);
		}
		System.out.println("-----------------");
		System.out.println("Total Failed: " + failed.size());
		
	}

}
