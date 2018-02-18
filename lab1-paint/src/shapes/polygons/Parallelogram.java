package shapes.polygons;


import java.awt.*;
import java.util.ArrayList;

public class Parallelogram extends Polygon {

    public Parallelogram(){}

    public Parallelogram(Point theCenter, Point cornerPoint, int frameWidth, Color frameColor, Color fillColor)
    {
        super(theCenter,frameWidth,frameColor,fillColor);
        setPoints(getParallelogramPoints(cornerPoint));
    }

    protected ArrayList<Point> getParallelogramPoints(Point cornerPoint)
    {
        Point theCenter = getLocation();
        ArrayList<Point> points = new ArrayList<>(4);
        Point upperLeft = new Point(2*theCenter.x-cornerPoint.x, 2*theCenter.y-cornerPoint.y);
        Point upperRight = new Point(cornerPoint.x+cornerPoint.y-upperLeft.y,upperLeft.y);
        Point bottomLeft = new Point(2*theCenter.x-upperRight.x, 2*theCenter.y-upperRight.y);
        points.add(cornerPoint);
        points.add(upperRight);
        points.add(upperLeft);
        points.add(bottomLeft);
        return points;
    }

    public void setCornerPoint(Point cornerPoint)
    {
        setPoints(getParallelogramPoints(cornerPoint));
    }



}