package shapes.polygons;

import shapes.abstract_shapes.Shape2D;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author User
 * @version 1.0
 * @created 17-���-2018 16:39:21
 */
public class Polygon extends Shape2D {

	private int numberOfPoint;
	private ArrayList<Point> points;

	public Polygon(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void draw(){

	}

	public int getNumberOfPoints(){
		return numberOfPoint;
	}

	public ArrayList<Point> getPoints(){
		return points;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNumberOfPoints(int newVal){
		numberOfPoint = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPoints(ArrayList<Point> newVal){
		points = newVal;
	}

}