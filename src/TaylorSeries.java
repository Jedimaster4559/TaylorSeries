/**
 * This class implements a new Taylor Series to calculate accurate values for mathematical
 * equations.
 * @author Nathan Solomon
 * @version 1.0 -- Last Updated 5/29/2017
 * 
 *
 */
public class TaylorSeries {
	
	private double accuracy;
	private double center;
	private double lastApproximation;
	private double approximation;
	private int steps;
	
	/**
	 * This constructs a McLauren Series (Taylor Series with a center of 0) with an accuracy
	 * of 4 decimal places.
	 */
	public TaylorSeries(){
		this.center = 0;
		this.accuracy = .0001;
		this.steps = 0;
	}
	
	/**
	 * This constructs a McLauren Series (Taylor Series with a center of 0) with a given accuracy 
	 * as a double. 
	 * @param accuracy
	 */
	public TaylorSeries(double accuracy){
		this.center = 0;
		this.accuracy = accuracy;
		this.steps = 0;
	}
	
	/**
	 * This constructs a Taylor Series with a given center and number of decimal places we want all 
	 * calculations to be accurate to. This will not run if accuracy is less than 0. Please input accuracy
	 * as a double value if you want a different accuracy level.
	 * @param center The center of the Taylor Series. Must be greater than 0.
	 * @param accuracy The chosen accuracy of the Taylor Series given as a number of decimal places.
	 */
	public TaylorSeries(double center, int accuracy) throws Exception{
		this.center = center;
		this.steps = 0;
		
		//Following Algorithm converts int accuracy to a double accuracy.
		if(accuracy > 0){
			this.accuracy = .1;
			for(int i = 0; i < accuracy-1; i++){
				this.accuracy = this.accuracy * .1;
			}
		}
		else if(accuracy < 0){
			this.accuracy = 10;
			for(int i = 0; i < accuracy-1; i++){
				this.accuracy = this.accuracy * 10;
			}
		}
		else{
			this.accuracy = 1;
		}
		
		
	}
	
	/**
	 * This constructs a Taylor Series with a given center and accuracy (as a decimal).
	 * @param center The center of the Taylor Series.
	 * @param accuracy The chosen accuracy of the Taylor Series given as a decimal.
	 */
	public TaylorSeries(double center, double accuracy){
		this.center = center;
		this.accuracy = accuracy;
		this.steps = 0;
	}
	
	/**
	 * This method tests to see if we have reached the right level of accuracy
	 * @return
	 */
	public boolean isAccurate(){
		/*
		if(this.accuracy > 0 && 
				(this.approximation-this.lastApproximation) < this.accuracy &&
				(this.approximation-this.lastApproximation) > -this.accuracy){
			return true;
		}
		else{
			return false;
		}
		*/
		
		double difference = (this.approximation-this.lastApproximation)/this.accuracy;
		if(difference > 1 || difference < -1){
			return false;
		}
		else{
			return true;
		}
	}
	
	/**
	 * This method will return an approximation of 1/(1-x).
	 * @param x The value of x in 1/(1-x)
	 */
	public void geometricSeriesApproximation(double x){
		//set the initial condition
		if(this.steps == 0){
			this.steps = 1;
			this.lastApproximation = 1;
		}
		else{
			this.lastApproximation = this.approximation;
		}
		
		//create the next addition
		double nextApproximation = x;
		
		//find the next addition
		//for(int i = 0; i < this.steps - 1; i++){
		//	nextApproximation = nextApproximation*x;
		//}
		
		//find the next addition
		nextApproximation = power(nextApproximation, (this.steps-1));
		
		//add next addition
		this.approximation = this.lastApproximation + nextApproximation;
		this.steps++;
		
		//test accuracy and either return or continue with other method
		if(!isAccurate()){
			geometricSeriesApproximation(x);
		}
		else{
			return;
		}
		
	}
	
	/**
	 * This method raises a number to a power and returns the result as a double.
	 * @param base The number to be raised to a power.
	 * @param power The number of times to multiply the base by itself
	 * @return The base multiplied by itself power times
	 */
	public static double power(double base, int power){
		if(power == 0){
			return 1;
		}
		double answer = base;
		for(int i = 0; i < power-1; i++){
			answer = answer * base;
		}
		return answer;
	}
	
	/**
	 * Calculates the factorial of an integer. Increments from 1, multiplying by each integer until it
	 * reaches the input number
	 * @param factorial The number we want to find the factorial of
	 * @return The factorial of the number.
	 */
	public static int factorial(int factorial){
		int answer = 1;
		for(int i = 1; i <= factorial; i++){
			answer = answer * i;
		}
		return answer;
	}
	
	/**
	 * Getter method for steps
	 * @return The number of steps to reach desired accuracy
	 */
	public int getStep(){
		return this.steps;
	}
	
	/**
	 * Getter method for accuracy
	 * @return The Accuracy level (as a decimal)
	 */
	public double getAccuracy(){
		return this.accuracy;
	}
	
	/**
	 * Getter method for the center of Taylor Series
	 * @return The center of the Taylor Series
	 */
	public double getCenter(){
		return this.center;
	}
	
	/**
	 * Getter method for the approximation of the value
	 * @return
	 */
	public double getApproximation(){
		return this.approximation;
	}
	
	/**
	 * This method will reset the Taylor Polynomial. It sets all approximations
	 * to 0 and the step counter to 0.
	 */
	public void reset(){
		this.steps = 0;
		this.approximation = 0;
		this.lastApproximation = 0;
	}
	
}
