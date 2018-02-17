package shapes.ellipses;

import shapes.abstract_shapes.Shape2D;

import java.awt.*;


public class Ellipse extends Shape2D {

    private Point cornerPoint;

    public Ellipse()
    {

    }

    public Ellipse(Point theCenter,Point cornerPoint)
    {
        super(theCenter);
        this.cornerPoint=cornerPoint;
    }

    public Ellipse(Point theCenter, Point cornerPoint, int frameWidth, Color frameColor, Color fillColor)
    {
        super(theCenter, frameWidth, frameColor, fillColor);
        this.cornerPoint=cornerPoint;
    }

    @Override
    public void draw(Graphics2D g)
    {
        int width=getWidth(), height=getHeight();
        g.setStroke(new BasicStroke(getBorderWidth()));
        g.setColor(getFillColor());
        g.fillOval(cornerPoint.x,cornerPoint.y,width,height);
        g.setColor(getBorderColor());
        g.drawOval(cornerPoint.x,cornerPoint.y,width,height);
    }

    protected int getWidth()
    {
        return 2*(getLocation().x-cornerPoint.x);
    }
    protected int getHeight()
    {
        return 2*(getLocation().y-cornerPoint.y);
    }

    @Override
    public boolean contains(Point p)
    {
        int width = getWidth();
        int height = getHeight();
        Point theCenter = getLocation();
        double alpha = (double) (p.x - theCenter.x) / width;
        double beta = (double) (p.y - theCenter.y) / height;
        return 4 * (alpha * alpha + beta * beta) < 1;
    }

    public Point getCornerPoint() {
        return cornerPoint;
    }


    public void setCornerPoint(Point newVal)
    {
        cornerPoint = newVal;
        correctCornerPoint(getLocation());
    }

    protected void correctCornerPoint(Point theCenter)
    {
        int deltaX = theCenter.x - cornerPoint.x;
        int deltaY = theCenter.y - cornerPoint.y;
        if (deltaX < 0)
            cornerPoint.translate(2 * deltaX, 0);
        if (deltaY < 0)
            cornerPoint.translate(0, 2 * deltaY);
    }

    public void move(Point newPoint) {
        Point theCenter = getLocation();
        cornerPoint.translate(newPoint.x - theCenter.x, newPoint.y - theCenter.y);
        super.move(newPoint);
    }

}