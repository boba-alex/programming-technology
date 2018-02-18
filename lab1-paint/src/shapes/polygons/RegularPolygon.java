package shapes.polygons;


import java.awt.*;
import java.util.ArrayList;


public class RegularPolygon extends Polygon {

    private int numberOfAngles;

    public RegularPolygon(Point theCenter, Point pointOnCircle, int numAngles, int frameWidth, Color frameColor, Color fillColor)
    {
        super(theCenter, frameWidth, frameColor, fillColor);
        this.numberOfAngles = numAngles;
        setPoints(getPolygonPoints(theCenter, pointOnCircle, numAngles));
    }

    private ArrayList<Point> getPolygonPoints(Point theCenter, Point pointOnCircle, int numAngles) {
        ArrayList<Point> points = new ArrayList<>(numAngles + 1);
        double radius = Math.sqrt(Math.pow((pointOnCircle.x) - theCenter.x, 2) + Math.pow(pointOnCircle.y - theCenter.y, 2));
        double z;
        double angle = 360.0 / numAngles;
        if (numAngles % 2 != 0)
            z = 90;
        else
            z = 90 - angle / 2;
        for (int i = 0; i < numAngles; i++)
        {
            points.add(new Point(theCenter.x + (int) (Math.cos(z / 180 * Math.PI) * radius),
                    theCenter.y - (int) (Math.sin(z / 180 * Math.PI) * radius)));
            z = z + angle;
        }
        return points;
    }

    public int getNumberOfAngles() {
        return numberOfAngles;
    }
    public void setNumberOfAngles(int newVal) {
        numberOfAngles = newVal;
    }

    public void setPointOnCircle(Point pointOnCircle)
    {
        setPoints(getPolygonPoints(getLocation(), pointOnCircle, numberOfAngles));
    }
}