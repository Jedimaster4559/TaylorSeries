import java.util.List;
import java.util.ArrayList;
import java.math.*;
public class TaylorSeriesTester {
	
	private static List<String> passed = new ArrayList<String>();
	private static List<String> failed = new ArrayList<String>();

	public static void main(String[] args) {
		geometricTest();
		System.out.println();
		
		printResults();
		factorialTest();
		

	}
	
	public static void geometricTest(){
		TaylorSeries taylor = new TaylorSeries();
		taylor.geometricSeriesApproximation(.5);			//tests .5 to determine if approximation is accurate
		if(taylor.getApproximationDouble() != 1.99993896484375){	//result of approximation
			System.out.println("Geometric Test 1 Failed");
			failed.add("Geometric Test 1 Failed");
		}
		else if (taylor.getApproximationBigDecimal().equals(BigDecimal.valueOf(1.9999389484375))){
			System.out.println("Geometric Test 2 Failed");
			failed.add("Gemetric Test 2 Failed");
		}
		else{
			System.out.println("All Geometric Passed");
			passed.add("All Geometric Passed");
		}
	}
	
	public static void factorialTest(){
		System.out.println("Factorial Tests");
		System.out.println("1! = " + TaylorSeries.factorial(1));	
		System.out.println("2! = " + TaylorSeries.factorial(2));
		System.out.println("3! = " + TaylorSeries.factorial(3));
		System.out.println("4! = " + TaylorSeries.factorial(4));
		System.out.println("5! = " + TaylorSeries.factorial(5));
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
