package gui;

import shapes.abstract_shapes.Shape;
import shapes.rectangulars.Circle;
import shapes.rectangulars.Ellipse;
import shapes.lines.Line;
import shapes.lines.Ray;
import shapes.lines.Segment;
import shapes.polygons.Parallelogram;
import shapes.polygons.Polygon;
import shapes.polygons.Rhomb;
import shapes.rectangulars.Rectangle;
import shapes.abstract_shapes.RectangularFigure;

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
    POLYGON, UPDATE_POLYGON, PARALLELOGRAM, RHOMB
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
    private DrawAction drawAction = DrawAction.MOVE;
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
