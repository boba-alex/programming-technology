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
    public void move(Point point)
    {
        Point start=segments.get(0).getLocation(), second;
        int deltaX=point.x-start.x, deltaY=point.y-start.y;
        for(Segment s : segments)
        {
            start=s.getLocation();
            second=s.getSecondPoint();
            s.setLocation(new Point(start.x+deltaX,start.y+deltaY));
            s.setSecondPoint(new Point(second.x + deltaX, second.y +deltaY));
        }
    }

    public ArrayList<Segment> getSegments() {
        return segments;
    }

    public void setSegments(ArrayList<Segment> newVal) {
        segments = newVal;
    }

}