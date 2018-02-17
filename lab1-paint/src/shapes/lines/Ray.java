package shapes.lines;


import java.awt.*;

public class Ray extends Segment {

    public Ray() {

    }

    public Ray(Point theCenter, Point secondPoint, Color borderColor, int borderWidth) {
        super(theCenter, secondPoint, borderColor, borderWidth);
    }

    @Override
    public void setSecondPoint(Point secondPoint) {
        if(secondPoint.x>0 && secondPoint.x<Toolkit.getDefaultToolkit().getScreenSize().getWidth() &&
                secondPoint.y>0 && secondPoint.y<Toolkit.getDefaultToolkit().getScreenSize().getHeight())
            secondPoint = getInfinitePoint(secondPoint);
        super.setSecondPoint(secondPoint);
    }

    private Point getInfinitePoint(Point secondPoint) {
        Point theCenter = getLocation();
        Point result = new Point();
        double deltaX = secondPoint.x - theCenter.x;
        double deltaY = secondPoint.y - theCenter.y;
        if (deltaX==0 && deltaY==0)
            return secondPoint;
        if (Math.abs(deltaX) < Math.abs(deltaY)) {
            double height;
            if (deltaY < 0)
                height = -1;
            else
                height = Toolkit.getDefaultToolkit().getScreenSize().getHeight() + 1;
            result.setLocation(deltaX / deltaY * (height - theCenter.y) + theCenter.x, height);
        } else {
            double width;
            if (deltaX < 0)
                width = -1;
            else
                width = Toolkit.getDefaultToolkit().getScreenSize().getWidth() + 1;
            result.setLocation(width, deltaY / deltaX * (width - theCenter.x) + theCenter.y);
        }
        return result;
    }
}