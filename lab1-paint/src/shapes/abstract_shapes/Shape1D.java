package shapes.abstract_shapes;

/**
 * @author admin
 * @version 1.0
 * @created 17-���-2018 16:39:22
 */
public abstract class Shape1D extends Shape {

	public Shape1D(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public abstract void draw();

}