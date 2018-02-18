package gui;

import shapes.abstract_shapes.RectangularFigure;
import shapes.abstract_shapes.Shape;
import shapes.lines.Line;
import shapes.lines.PolygonalLine;
import shapes.lines.Ray;
import shapes.lines.Segment;
import shapes.polygons.Parallelogram;
import shapes.polygons.Polygon;
import shapes.polygons.RegularPolygon;
import shapes.polygons.Rhomb;
import shapes.rectangulars.Circle;
import shapes.rectangulars.Ellipse;
import shapes.rectangulars.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by User on 17.02.2018.
 */
enum DrawAction {
    MOVE, RECTANGLE,CIRCLE, ELLIPSE, REGULAR_POLYGON, SEGMENT, RAY, LINE,
    POLYGON, UPDATE_POLYGON, PARALLELOGRAM, RHOMB, POLYGONAL_LINE, UPDATE_POLYGONAL_LINE
}

public class MainApp extends JFrame{

    private JPanel rootPanel;
    private JPanel drawPanel;
    private JButton buttonSegment;
    private JButton buttonRay;
    private JButton buttonMove;
    private JButton buttonEllipse;
    private JButton buttonCircle;
    private JButton buttonLine;
    private JButton buttonPolygon;
    private JButton buttonParalelogram;
    private JButton buttonRhomb;
    private JButton buttonRectangle;
    private JButton buttonRPolygon;
    private JButton buttonPolygonalLine;

    private DrawAction drawAction = DrawAction.MOVE;
    private int numAngles;
    private int frameWidth = 5;
    private Color frameColor = new Color(0, 0, 0);
    private Color fillColor = new Color(255, 255, 255);

    private ArrayList<Shape> shapes = new ArrayList<>();

    private boolean isDragged = true;

    public MainApp(){
        super("MyPaint");
        setContentPane(rootPanel);
        setUpGUI();
        setSize(1600, 800);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainApp();
    }

    private void setUpGUI() {
        buttonSegment.addActionListener(e -> drawAction = DrawAction.SEGMENT);
        buttonEllipse.addActionListener(e->drawAction=DrawAction.ELLIPSE);
        buttonCircle.addActionListener(e->drawAction=DrawAction.CIRCLE);
        buttonRay.addActionListener(e -> drawAction = DrawAction.RAY);
        buttonLine.addActionListener(e -> drawAction = DrawAction.LINE);
        buttonPolygon.addActionListener(e->drawAction=DrawAction.POLYGON);
        buttonParalelogram.addActionListener(e->drawAction=DrawAction.PARALLELOGRAM);
        buttonRhomb.addActionListener(e->drawAction=DrawAction.RHOMB);
        buttonRectangle.addActionListener(e->drawAction=DrawAction.RECTANGLE);
        buttonPolygonalLine.addActionListener(e->drawAction=DrawAction.POLYGONAL_LINE);
        buttonRPolygon.addActionListener(e->
        {
            drawAction=DrawAction.REGULAR_POLYGON;
            numAngles=0;
            while(numAngles<3)
            {
                numAngles= Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Set number of angles, greater then 2"));
                if(numAngles<3)
                    JOptionPane.showConfirmDialog(null,"Error! Incorrect number of angles");
            }
        });
        buttonMove.addActionListener(e -> drawAction = DrawAction.MOVE);

        drawPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    switch (drawAction) {
                        case MOVE:
                            ListIterator<Shape> listIterator = shapes.listIterator(shapes.size());
                            while(listIterator.hasPrevious()){
                                int prevIndex = listIterator.previousIndex();
                                if(listIterator.previous().contains(e.getPoint())){
                                    isDragged = true;
                                    shapes.add(shapes.remove(prevIndex));
                                    break;
                                }
                            }
                            break;
                        case SEGMENT:
                            shapes.add(new Segment(e.getPoint(), e.getPoint(), frameColor, frameWidth));
                            break;
                        case ELLIPSE:
                            shapes.add(new Ellipse(e.getPoint(),e.getPoint(),frameWidth,frameColor,fillColor));
                            break;
                        case CIRCLE:
                            shapes.add(new Circle(e.getPoint(),e.getPoint(),frameWidth,frameColor,fillColor));
                            break;
                        case RAY:
                            shapes.add(new Ray(e.getPoint(), e.getPoint(), frameColor, frameWidth));
                            break;
                        case LINE:
                            shapes.add(new Line(e.getPoint(), e.getPoint(), frameColor, frameWidth));
                            break;
                        case POLYGON:
                            ArrayList<Point> points =new  ArrayList<>();
                            points.add(e.getPoint());
                            points.add(e.getPoint());
                            shapes.add(new Polygon(e.getPoint(),points,frameWidth,frameColor,fillColor));
                            drawAction=DrawAction.UPDATE_POLYGON;
                            break;
                        case UPDATE_POLYGON:
                            Shape currentShape = shapes.get(shapes.size() - 1);
                            Polygon polygon=(Polygon)currentShape;
                            ArrayList<Point> newPoints=polygon.getPoints();
                            newPoints.add(e.getPoint());
                            polygon.setPoints(newPoints);
                            break;
                        case PARALLELOGRAM:
                            shapes.add(new Parallelogram(e.getPoint(), e.getPoint(), frameWidth, frameColor, fillColor));
                            break;
                        case RHOMB:
                            shapes.add(new Rhomb(e.getPoint(),e.getPoint(),frameWidth,frameColor,fillColor));
                            break;
                        case RECTANGLE:
                            shapes.add(new Rectangle(e.getPoint(),e.getPoint(),frameWidth,frameColor,fillColor));
                            break;
                        case REGULAR_POLYGON:
                            shapes.add(new RegularPolygon(e.getPoint(),e.getPoint(),numAngles,frameWidth,frameColor,fillColor));
                            break;
                        case POLYGONAL_LINE:
                            Segment segment = new Segment(e.getPoint(), e.getPoint(), frameColor, frameWidth);
                            ArrayList<Segment> segments = new ArrayList<>();
                            segments.add(segment);
                            shapes.add(new PolygonalLine(segments, frameColor, frameWidth));
                            break;
                        case UPDATE_POLYGONAL_LINE:
                            currentShape = shapes.get(shapes.size() - 1);
                            PolygonalLine polygonalLine = (PolygonalLine) currentShape;
                            segments = polygonalLine.getSegments();
                            Point lastPoint = segments.get(segments.size() - 1).getSecondPoint();
                            segment = new Segment(lastPoint, e.getPoint(),frameColor,frameWidth);
                            segments.add(segment);
                            //polygonalLine.setSegments(segments);
                            break;
                    }
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (drawAction == DrawAction.MOVE){
                    isDragged = false;
                }

            }
        });

        drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e) && shapes.size() > 0) {
                    Shape currentShape = shapes.get(shapes.size() - 1);
                    switch (drawAction) {
                        case MOVE:
                            if(isDragged)
                                currentShape.move(e.getPoint());
                            break;
                        case SEGMENT:
                        case RAY:
                        case LINE:
                            Segment segment = (Segment) currentShape;
                            segment.setSecondPoint(e.getPoint());
                            break;
                        case RECTANGLE:
                        case ELLIPSE:
                        case CIRCLE:
                            RectangularFigure figure=(RectangularFigure) currentShape;
                            figure.setCornerPoint(e.getPoint());
                            break;
                        case UPDATE_POLYGON:
                            ((Polygon) currentShape).setLastPoint(e.getPoint());
                            break;
                        case RHOMB:
                        case PARALLELOGRAM:
                            Parallelogram parallelogram=(Parallelogram) currentShape;
                            parallelogram.setCornerPoint(e.getPoint());
                            break;
                        case REGULAR_POLYGON:
                            RegularPolygon polygon = (RegularPolygon) currentShape;
                            polygon.setPointOnCircle(e.getPoint());
                            break;
                        case UPDATE_POLYGONAL_LINE:
                            currentShape = shapes.get(shapes.size() - 1);
                            PolygonalLine polygonalLine = (PolygonalLine) currentShape;
                            ArrayList<Segment> segments = polygonalLine.getSegments();
                            segments.get(segments.size() - 1).setSecondPoint(e.getPoint());
                            break;
                    }
                    repaint();
                }
            }
        });
    }
    private void createUIComponents() {
        drawPanel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                for(Shape s : shapes)
                {
                    s.draw(g2d);
                }
            }
        };
    }
}
