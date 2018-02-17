package shapes.abstract_shapes;


import java.awt.*;

public abstract class Shape1D extends Shape {

    public Shape1D() {

    }

    public Shape1D(Point theCenter) {
        super(theCenter);
    }

    public Shape1D(Point theCenter, Color borderColor, int borderWidth) {
        super(theCenter, borderColor, borderWidth);
    }
}