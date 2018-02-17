package shapes.lines;

import shapes.abstract_shapes.Shape1D;

import java.util.ArrayList;


public class PolygonalLine extends Shape1D {

    private ArrayList<Segment> segments;

    public PolygonalLine() {

    }


    public void draw() {

    }

    public ArrayList<Segment> getSegments() {
        return segments;
    }

    public void setSegments(ArrayList<Segment> newVal) {
        segments = newVal;
    }

}