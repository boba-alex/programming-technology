package shapes.abstract_shapes;

import java.awt.*;


public abstract class Shape2D extends Shape {

    private Color fillingColor;

    public Shape2D() {

    }


    public abstract void draw();

    public Color getFillingColor() {
        return fillingColor;
    }


    public void setFillingColor(Color newVal) {
        fillingColor = newVal;
    }

}