package shapes.abstract_shapes;

import java.awt.*;


public abstract class Shape2D extends Shape {

    private Color fillColor = new Color(255,255,255);

    public Shape2D(){

    }

    public Shape2D(Point theCenter) {
        super(theCenter);
    }

    public Shape2D(Point theCenter, int frameWidth, Color frameColor, Color fillColor)
    {
        super(theCenter,frameColor,frameWidth);
        setFillColor(fillColor);
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color newVal) {
        fillColor = newVal;
    }

}