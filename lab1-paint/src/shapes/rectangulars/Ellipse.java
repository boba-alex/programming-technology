package shapes.rectangulars;

import shapes.abstract_shapes.RectangularFigure;

import java.awt.*;


public class Ellipse extends RectangularFigure
{
    public Ellipse(Point theCenter, Point cornerPoint, int frameWidth, Color frameColor, Color fillColor)
    {
        super(theCenter, cornerPoint, frameWidth, frameColor, fillColor);
    }

    @Override
    public void draw(Graphics2D g)
    {
        Point cornerPoint=getCornerPoint();
        int width=getWidth(), height=getHeight();
        g.setStroke(new BasicStroke(getBorderWidth()));
        g.setColor(getFillColor());
        g.fillOval(cornerPoint.x,cornerPoint.y,width,height);
        g.setColor(getBorderColor());
        g.drawOval(cornerPoint.x,cornerPoint.y,width,height);
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

}