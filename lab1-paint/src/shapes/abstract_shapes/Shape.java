package shapes.abstract_shapes;

import java.awt.*;

public abstract class Shape {

    private Point theCenter;
    private Color borderColor = new Color(0, 0, 0);
    private int borderWidth = 1;

    public Shape() {

    }

    public Shape(Point theCenter) {
        this.theCenter = theCenter;
    }

    public Shape(Point theCenter, Color borderColor, int borderWidth) {
        this.theCenter = theCenter;
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;
    }

    public abstract void draw(Graphics2D g);

    //help for drag and drop
    public abstract  boolean contains(Point p);

    public Point getLocation() {
        return theCenter;
    }

    public void setLocation(Point newVal) {
        this.theCenter = newVal;
    }


    public void move(Point point) {
        theCenter.setLocation(point);

    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color newVal) {
        this.borderColor = newVal;
    }

    public int getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
    }
}