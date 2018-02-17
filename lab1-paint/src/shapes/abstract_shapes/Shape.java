package shapes.abstract_shapes;

import java.awt.*;

/**
 * @author User
 * @version 1.0
 * @created 17-���-2018 16:39:22
 */
public abstract class Shape {

	private Color borderColor;
	private Point theCenter;

	public Shape(){

	}

	public void finalize() throws Throwable {

	}

	public abstract void draw();

	public Color getBorderColor(){
		return borderColor;
	}

	public Point getLocation(){
		return theCenter;
	}

	/**
	 * 
	 * @param point
	 */
	public void move(Point point){

	}

	/**
	 * 
	 * @param newVal
	 */
	public void setBorderColor(Color newVal){
		borderColor = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setLocation(Point newVal){
		theCenter = newVal;
	}

}