package shapes.lines;

import shapes.abstract_shapes.Shape1D;

import java.util.ArrayList;

/**
 * @author admin
 * @version 1.0
 * @created 17-���-2018 16:39:22
 */
public class PolygonalLine extends Shape1D {

	private ArrayList<Segment> segments;
	public Segment m_Segment;

	public PolygonalLine(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void draw(){

	}

	public ArrayList<Segment>  getSegments(){
		return segments;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setSegments(ArrayList<Segment> newVal){
		segments = newVal;
	}

}