package shapes.abstract_shapes;

import java.awt.*;

public abstract class Shape {

    private Color borderColor = new Color(0, 0, 0);
    private Point theCenter;

    public Shape() {

    }

    public abstract void draw();

    public Color getBorderColor() {
        return borderColor;
    }

    public Point getLocation() {
        return theCenter;
    }


    public void move(Point point) {

    }


    public void setBorderColor(Color newVal) {
        borderColor = newVal;
    }

    public void setLocation(Point newVal) {
        theCenter = newVal;
    }

}