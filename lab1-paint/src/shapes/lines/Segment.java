package shapes.lines;

import shapes.abstract_shapes.Shape1D;

import java.awt.*;

/**
 * @author User
 * @version 1.0
 * @created 17-���-2018 16:39:22
 */
public class Segment extends Shape1D {

	private Point secondPoint;

	public Segment(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void draw(){

	}

	public Point getSecondPoint(){
		return secondPoint;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSecondPoint(Point newVal){
		secondPoint = newVal;
	}

}