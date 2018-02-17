package shapes.polygons;

/**
 * @author User
 * @version 1.0
 * @created 17-���-2018 16:39:22
 */
public class ReqularPolygon extends Polygon {

	private int numberOfSides;

	public ReqularPolygon(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void draw(){

	}

	public int getNumberOfSides(){
		return numberOfSides;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNumberOfSides(int newVal){
		numberOfSides = newVal;
	}

}