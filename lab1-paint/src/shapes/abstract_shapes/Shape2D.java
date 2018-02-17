package shapes.abstract_shapes;

import java.awt.*;

/**
 * @author User
 * @version 1.0
 * @created 17-���-2018 16:39:22
 */
public abstract class Shape2D extends Shape {

	private Color fillingColor;

	public Shape2D(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public abstract void draw();

	public Color getFillingColor(){
		return fillingColor;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setFillingColor(Color newVal){
		fillingColor = newVal;
	}

}