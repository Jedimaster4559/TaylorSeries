import java.util.List;
import java.util.ArrayList;
import java.math.*;
public class TaylorSeriesTester {
	
	private static List<String> passed = new ArrayList<String>();
	private static List<String> failed = new ArrayList<String>();

	public static void main(String[] args) {
		geometricTest();
		System.out.println();
		eTest();
		System.out.println();
		factorialTest();
		System.out.println();
		printResults();
		
		

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
	
	public static void eTest(){
		TaylorSeries taylor = new TaylorSeries();
		taylor.eSeriesApproximation(.5);
		if(taylor.getApproximationDouble() != 1.6487212707){
			System.out.println("E Test 1 Failed");
			failed.add("E Test 1 Failed");
		}
		else
		{
			System.out.println("E Test 1 Passed");
			passed.add("E Test 1 Passed");
		}
	}
	
	public static void factorialTest(){
		int zero = TaylorSeries.factorial(0);
		int one = TaylorSeries.factorial(1);
		int two = TaylorSeries.factorial(2);
		int three = TaylorSeries.factorial(3);
		int four = TaylorSeries.factorial(4);
		
		System.out.println("0! = " + zero);					//0! test
		if(zero != 1){
			System.out.println("Factorial Test 1 Failed");
			failed.add("Factorial Test 1 Failed");
		}
		else{
			System.out.println("Factorial Test 1 Passed");
			passed.add("Factorial Test 1 Passed");
		}
		
		System.out.println("1! = " + one);					//1! test
		if(one != 1){
			System.out.println("Factorial Test 2 Failed");
			failed.add("Factorial Test 2 Failed");
		}
		else{
			System.out.println("Factorial Test 2 Passed");
			passed.add("Factorial Test 2 Passed");
		}
		
		System.out.println("2! = " + two);					//2! test
		if(two != 2){
			System.out.println("Factorial Test 3 Failed");
			failed.add("Factorial Test 3 Failed");
		}
		else{
			System.out.println("Factorial Test 3 Passed");
			passed.add("Factorial Test 3 Passed");
		}
		
		System.out.println("3! = " + three);				//3! test
		if(three != 6){
			System.out.println("Factorial Test 4 Failed");
			failed.add("Factorial Test 4 Failed");
		}
		else{
			System.out.println("Factorial Test 4 Passed");
			passed.add("Factorial Test 4 Passed");
		}
		
		System.out.println("4! = " + four);					//4! test
		if(four != 24){
			System.out.println("Factorial Test 5 Failed");
			failed.add("Factorial Test 5 Failed");
		}
		else{
			System.out.println("Factorial Test 5 Passed");
			passed.add("Factorial Test 5 Passed");
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
