package shapes.lines;


import java.awt.*;

public class Line extends Ray {

    public Line() {

    }

    public Line(Point theCenter, Point secondPoint, Color borderColor, int borderWidth) {
        super(theCenter, secondPoint, borderColor, borderWidth);
    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        Point theCenter = getLocation();
        Point secondPoint = getSecondPoint();
        setSecondPoint(new Point);
    }


}
