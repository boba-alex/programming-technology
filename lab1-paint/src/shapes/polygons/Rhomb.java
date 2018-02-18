package shapes.polygons;

import java.awt.*;
import java.util.ArrayList;

public class Rhomb extends Parallelogram {

    public Rhomb()
    {

    }

    public Rhomb(Point theCenter, Point cornerPoint, int frameWidth, Color frameColor, Color fillColor)
    {
        super(theCenter,cornerPoint,frameWidth,frameColor,fillColor);
    }

    @Override
    protected ArrayList<Point> getParallelogramPoints(Point cornerPoint)
    {
        Point theCenter = getLocation();
        ArrayList<Point> points = new ArrayList<>(4);
        points.add(new Point(cornerPoint.x, theCenter.y));
        points.add(new Point(theCenter.x, 2*theCenter.y-cornerPoint.y));
        points.add(new Point(2*theCenter.x-cornerPoint.x, theCenter.y));
        points.add(new Point(theCenter.x, cornerPoint.y));
        return points;
    }
}