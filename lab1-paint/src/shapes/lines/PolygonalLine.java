package shapes.lines;

import shapes.abstract_shapes.Shape1D;

import java.awt.*;
import java.util.ArrayList;


public class PolygonalLine extends Shape1D {

    private ArrayList<Segment> segments;

    public PolygonalLine() {

    }

    public PolygonalLine(ArrayList<Segment> segments, Color borderColor, int borderWidth) {
        super(segments.get(0).getLocation(), borderColor, borderWidth);
        this.segments = segments;
    }

    @Override
    public void draw(Graphics2D g) {
        for(Segment s : segments){
            s.draw(g);
        }
    }

    @Override
    public boolean contains(Point p) {
        for(Segment s : segments){
            if(s.contains(p)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void move(Point point) {
        for(Segment s : segments){
            s.move(point);
        }
    }

    public ArrayList<Segment> getSegments() {
        return segments;
    }

    public void setSegments(ArrayList<Segment> newVal) {
        segments = newVal;
    }

}