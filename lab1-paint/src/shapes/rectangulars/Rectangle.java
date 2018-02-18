package shapes.rectangulars;

import shapes.abstract_shapes.RectangularFigure;

import java.awt.*;

public class Rectangle extends RectangularFigure
{

    public Rectangle(Point theCenter, Point cornerPoint, int frameWidth, Color frameColor, Color fillColor)
    {
        super(theCenter,cornerPoint,frameWidth,frameColor,fillColor);
    }

    @Override
    public void draw(Graphics2D g)
    {
        Point cornerPoint=getCornerPoint();
        int width=getWidth(), height=getHeight();
        g.setStroke(new BasicStroke(getBorderWidth()));
        g.setColor(getFillColor());
        g.fillRect(cornerPoint.x,cornerPoint.y,width,height);
        g.setColor(getBorderColor());
        g.drawRect(cornerPoint.x,cornerPoint.y,width,height);
    }

    @Override
    public boolean contains(Point pt)
    {
        Point cornerPoint = getCornerPoint();
        int width = getWidth();
        int height = getHeight();
        return pt.x >= cornerPoint.x && pt.x <= cornerPoint.x + width &&
                pt.y >= cornerPoint.y && pt.y <= cornerPoint.y + height;
    }
}
