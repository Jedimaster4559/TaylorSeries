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
	
	public TaylorSeries(){
		this.center = 0;
		this.accuracy = 4;
	}
	
	/**
	 * This constructs a Taylor Series with a given center and 
	 * @param accuracy
	 */
	public TaylorSeries(double accuracy){
		this.center = 0;
		this.accuracy = accuracy;
	}
	
	/**
	 * This constructs a Taylor Series with a given center and number of decimal places we want all 
	 * calculations to be accurate to. This will not run if accuracy is less than 0. Please input accuracy
	 * as a double value if you want a different accuracy level.
	 * @param center The center of the Taylor Series. Must be greater than 0.
	 * @param accuracy The chosen accuracy of the Taylor Series given as a number of decimal places.
	 * @throws Exception 
	 */
	public TaylorSeries(double center, int accuracy) throws Exception{
		this.center = center;
		
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
		//TODO finish this method.
		
		//throw an exception if accuracy is invalid.
		if(accuracy < 1){
			throw new Exception("Accuracy must be greater than 0 if input as an int value");
		}
		//TODO Check and see if this works correctly. If not, try again as a trycatch.
		
		
	}
	
	/**
	 * This constructs a Taylor Series with a given center and accuracy (as a decimal).
	 * @param center The center of the Taylor Series.
	 * @param accuracy The chosen accuracy of the Taylor Series given as a decimal.
	 */
	public TaylorSeries(double center, double accuracy){
		this.center = center;
		this.accuracy = accuracy;
	}
	
}
