package shapes.lines;

import shapes.abstract_shapes.Shape1D;

import java.awt.*;

public class Segment extends Shape1D {

    private Point secondPoint;

    public Segment() {

    }

    public Segment(Point theCenter, Point secondPoint, Color borderColor, int borderWidth) {
        super(theCenter, borderColor, borderWidth);
        this.secondPoint = secondPoint;
    }

    @Override
    public void draw(Graphics2D g) {
        Point firstPoint = getLocation();
        g.setStroke(new BasicStroke(getBorderWidth()));
        g.setColor(getBorderColor());
        g.drawLine(firstPoint.x, firstPoint.y, secondPoint.x, secondPoint.y);
    }

    @Override
    public boolean contains(Point p) {
        Point theCenter = getLocation();
        int a = secondPoint.y - theCenter.y;
        int b = theCenter.x - secondPoint.x;
        double d = (a * p.x + b * p.y - a * theCenter.x - b * theCenter.y) / (Math.sqrt( Math.pow(a, 2) + Math.pow(b, 2)));
        return Math.abs(d) < getBorderWidth() / 2;
    }

    @Override
    public void move(Point point) {
        Point theCenter = getLocation();
        setSecondPoint(new Point(secondPoint.x + point.x - theCenter.x, secondPoint.y + point.y - theCenter.y));
        super.move(point);
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point newVal) {
        secondPoint = newVal;
    }

}