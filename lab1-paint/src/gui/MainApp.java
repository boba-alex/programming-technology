package gui;

import shapes.abstract_shapes.*;
import shapes.abstract_shapes.Shape;
import shapes.lines.Segment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

/**
 * Created by User on 17.02.2018.
 */
enum DrawAction {
    MOVE, RECTANGLE, ELLIPSE, REGULAR_POLYGON, SEGMENT, RAY, LINE,
    POLYGON, UPDATE_POLYGON, PARALLELOGRAM, RHOMB
}

public class MainApp extends JFrame{

    private JPanel rootPanel;
    private JPanel drawPanel;
    private JButton buttonSegment;
    private JButton buttonRay;
    private JButton buttonMove;
    private DrawAction drawAction = DrawAction.MOVE;
    private int frameWidth = 1;
    private Color frameColor = new Color(0, 0, 0);
    private Color fillColor = new Color(255, 255, 255);

    private ArrayList<Shape> shapes = new ArrayList<>();

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

        drawPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    switch (drawAction) {
                        case SEGMENT:
                            shapes.add(new Segment(e.getPoint(), e.getPoint(), frameColor, frameWidth));
                            break;
                    }
                    repaint();
                }
            }
        });

        drawPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e) && shapes.size() > 0) {
                    Shape currentShape = shapes.get(shapes.size() - 1);
                    switch (drawAction) {
                        case SEGMENT:
                            Segment segment = (Segment) currentShape;
                            segment.setSecondPoint(e.getPoint());
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
