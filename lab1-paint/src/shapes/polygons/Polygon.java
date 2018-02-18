package shapes.polygons;

import shapes.abstract_shapes.Shape2D;

import java.awt.*;
import java.util.ArrayList;

public class Polygon extends Shape2D
{

    private int numberOfPoint;
    private int[] xPoints,yPoints;

    public Polygon()
    {}

    public Polygon(Point theCenter, int frameWidth, Color frameColor, Color fillColor)
    {
        super(theCenter,  frameWidth, frameColor, fillColor);
    }

    public Polygon(Point theCenter, ArrayList<Point> points, int frameWidth,Color frameColor, Color fillColor)
    {
        super(theCenter,frameWidth,frameColor,fillColor);
        setPoints(points);
        setLocation(computeTheCenter());
    }

    @Override
    public boolean contains(Point point)
    {
        ArrayList<Point> p=getPoints();
        int x=point.x,y=point.y;
        int i1, i2, n, S, S1, S2, S3;
        boolean flag=false;
        for (n=0; n<numberOfPoint; n++)
        {
            flag = false;
            i1 = n < numberOfPoint-1 ? n + 1 : 0;
            while(true)
            {
                i2 = i1 + 1;
                if (i2 >= numberOfPoint)
                    i2 = 0;
                if (i2 == (n < numberOfPoint-1 ? n + 1 : 0))
                    break;
                S = Math.abs(p.get(i1).x*(p.get(i2).y - p.get(n).y)+p.get(i2).x*(p.get(n).y - p.get(i1).y)+
                        p.get(n).x*(p.get(i1).y - p.get(i2).y));
                S1 = Math.abs(p.get(i1).x*(p.get(i2).y - y)+p.get(i2).x*(y- p.get(i1).y)+x*(p.get(i1).y - p.get(i2).y));
                S2 = Math.abs(p.get(n).x*(p.get(i2).y - y)+p.get(i2).x*(y- p.get(n).y)+x*(p.get(n).y - p.get(i2).y));
                S3 = Math.abs(p.get(i1).x*(p.get(n).y - y)+p.get(n).x*(y- p.get(i1).y)+x*(p.get(i1).y - p.get(n).y));
                if (S == S1 + S2 + S3)
                {
                    flag = true;
                    break;
                }
                i1 = i1 + 1;
                if (i1 >= numberOfPoint)
                    i1 = 0;
            }
            if (!flag)
                break;
        }
        return flag;
    }

    @Override
    public void draw(Graphics2D g)
    {
        g.setStroke(new BasicStroke(getBorderWidth()));
        g.setColor(getFillColor());
        g.fillPolygon(xPoints,yPoints,numberOfPoint);
        g.setColor(getBorderColor());
        g.drawPolygon(xPoints,yPoints,numberOfPoint);
    }

    public int getNumberOfPoints()
    {
        return numberOfPoint;
    }

    public void setNumberOfPoints(int newVal) {
        numberOfPoint = newVal;
    }

    public ArrayList<Point> getPoints()
    {
        ArrayList<Point> points=new ArrayList<>();
        for(int i=0;i<numberOfPoint;i++)
        {
            Point temp=new Point(xPoints[i],yPoints[i]);
            points.add(temp);
        }
        return points;
    }

    public void setPoints(ArrayList<Point> newVal)
    {
        numberOfPoint=newVal.size();
        xPoints=new int[numberOfPoint];
        yPoints=new int[numberOfPoint];
        for (int i=0;i<numberOfPoint;i++)
        {
           Point temp=newVal.get(i);
           xPoints[i]=temp.x;
           yPoints[i]=temp.y;
        }
    }

    @Override
    public void move(Point pt)
    {
        setLocation(computeTheCenter());
        Point theCenter = getLocation( );
        int deltaX = pt.x - theCenter.x;
        int deltaY = pt.y - theCenter.y;
        for (int i = 0; i < numberOfPoint; i++) {
            xPoints[i] += deltaX;
            yPoints[i] += deltaY;
        }
        super.move(pt);
    }

    protected Point computeTheCenter()
    {
        int x=0,y=0;
        for(int i=0;i<numberOfPoint;i++)
        {
            x+=xPoints[i];
            y+=yPoints[i];
        }
        return new Point(x/numberOfPoint,y/numberOfPoint);
    }

    public void setLastPoint(Point pt){
        xPoints[numberOfPoint-1] = pt.x;
        yPoints[numberOfPoint-1] = pt.y;
        setLocation(computeTheCenter());
    }
}