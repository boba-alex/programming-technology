package shapes.ellipses;

import shapes.abstract_shapes.Shape2D;

/**
 * @author User
 * @version 1.0
 * @created 17-���-2018 16:39:21
 */
public class Ellipse extends Shape2D {

	private int cornerPoint;

	public Ellipse(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void draw(){

	}

	public int getCornerPoint(){
		return cornerPoint;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setCornerPoint(int newVal){
		cornerPoint = newVal;
	}

}