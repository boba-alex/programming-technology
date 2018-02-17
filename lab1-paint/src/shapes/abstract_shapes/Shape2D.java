package shapes.abstract_shapes;

import java.awt.*;


public abstract class Shape2D extends Shape {

    private Color fillingColor = new Color(255,255,255);

    public Shape2D() {

    }

    public Shape2D(Point theCenter) {
        super(theCenter);
    }

    public Color getFillingColor() {
        return fillingColor;
    }


    public void setFillingColor(Color newVal) {
        fillingColor = newVal;
    }

}