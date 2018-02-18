package shapes.abstract_shapes;

import shapes.abstract_shapes.Shape2D;

import java.awt.*;

public abstract class RectangularFigure extends Shape2D
{
    private Point cornerPoint;

    public RectangularFigure(Point theCenter, Point cornerPoint, int frameWidth, Color frameColor, Color fillColor)
    {
        super(theCenter, frameWidth, frameColor, fillColor);
        this.cornerPoint=cornerPoint;
    }

    protected Point getCornerPoint()
    {
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

    protected int getWidth()
    {
        return 2*(getLocation().x-cornerPoint.x);
    }
    protected int getHeight()
    {
        return 2*(getLocation().y-cornerPoint.y);
    }

    public void move(Point newPoint) {
        Point theCenter = getLocation();
        getCornerPoint().translate(newPoint.x - theCenter.x, newPoint.y - theCenter.y);
        super.move(newPoint);
    }
}
