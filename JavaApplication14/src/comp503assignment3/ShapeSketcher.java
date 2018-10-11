package comp503assignment3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author xuchang
 */
public class ShapeSketcher extends JPanel implements MouseMotionListener, MouseListener {

    private DrawingPanel drawPanel;
    private int PANEL_WIDTH = 500;
    private int PANEL_HEIGHT = 500;

//    private Line line;
//    private Oval oval;
//    private Circle circle;
//    private Rectangle rectangle;
//    private Square square;
    private Shape shape;

    private ShapechoicePanel shapechoicePanel;
    private FunctionPanel functionPanel;

    private ArrayList<Shape> shapeList;

    private Point startPoint, endPoint;
    private String shapeName = "";
    private boolean filled = false;

    private CoordinateXY xy;

    private Color color;

    public ShapeSketcher() {
        super(new BorderLayout());

        this.setBackground(Color.black);
        shapechoicePanel = new ShapechoicePanel();
        functionPanel = new FunctionPanel();

        shapeList = new ArrayList<Shape>();
//        shapeList.add(line);

        addMouseMotionListener(this);
        addMouseListener(this);

        addButtonListeners();
        drawPanel = new DrawingPanel();
        add(drawPanel, BorderLayout.NORTH);
        add(shapechoicePanel, BorderLayout.CENTER);
        add(functionPanel, BorderLayout.SOUTH);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        shape.setControlPoint(e.getPoint());

//        oval.setControlPoint(e.getPoint());
//        line.setControlPoint(e.getPoint());
//        circle.setControlPoint(e.getPoint());
//        rectangle.setControlPoint(e.getPoint());
//        square.setControlPoint(e.getPoint());
//        if (e.getX() == this.startPoint.getX()) {
//            xy = new CoordinateXY("x", e.getX(), e.getX());
//
//        }
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
//        shape = new Shape(e.getPoint()) {
//            @Override
//            public void draw(Graphics g) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        };

        startPoint = new Point(e.getPoint());
//        oval = new Oval(startPoint);
//        line = new Line(startPoint);
//        circle = new Circle(startPoint);
//        rectangle = new Rectangle(startPoint);
//        square = new Square(startPoint);
        repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        endPoint = new Point(e.getPoint());
        shape.setControlPoint(endPoint);

//        oval.setControlPoint(endPoint);
//        line.setControlPoint(endPoint);
//        circle.setControlPoint(endPoint);
//        rectangle.setControlPoint(endPoint);
//        square.setControlPoint(endPoint);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void addButtonListeners() {
        shapechoicePanel.addLineButtonActionListener(l -> shapeName = "line");
        shapechoicePanel.addOvalButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent l) {
                shape = new Oval(startPoint);
                
                System.out.println(shape.startPoint);
                System.out.println(shape.controlPoint);
            }
        });
        shapechoicePanel.addCircleButtonActionListener(l -> shapeName = "circle");
        shapechoicePanel.addRectangleButtonActionListener(l -> shapeName = "rectangle");
        shapechoicePanel.addSquareButtonActionListener(l -> shapeName = "square");

        shapechoicePanel.addColourButtonActionListener(l -> color = JColorChooser.showDialog(shapechoicePanel, "PICK A COLOUR", Color.BLACK));

        functionPanel.addExitButtonActionListener(l -> System.exit(0));
//        functionPanel.addSaveButtonActionListener(l ->);
//        functionPanel.addOpenButtonActionListener(l ->);
//        functionPanel.addundoButtonActionListener(l ->);
        functionPanel.addClearButtonActionListener((ActionEvent l) -> {

            shapeList.clear();
            repaint();
        });

        functionPanel.addFilledCheckActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent l) {
                filled = functionPanel.filledCheck.isSelected();
            }
        });
    }

    private class DrawingPanel extends JPanel {

        public DrawingPanel() {
            setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
            setBackground(Color.WHITE);

        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

//            if (shapeName.equals("line")) {
//                if (line != null) {
////                    line.draw(g);
//                    shapeList.add(line);
//
//                }
//
//                if (shapeName.equals("oval")) {



            if (shape != null) {
//                if (filled) {
//                    shape.setColour(color);
//                }
                shape.draw(g);
                shapeList.add(shape);
            }
//                    } else if (shapeName.equals("circle")) {
//                        if (circle != null) {
//                            circle.setFilled(filled);
//                            circle.setColour(color);
////                    circle.draw(g);
//                            shapeList.add(circle);
//
//                        }
//
//                    } else if (shapeName.equals("rectangle")) {
//                        if (rectangle != null) {
//                            rectangle.setFilled(filled);
//                            rectangle.setColour(color);
////                    rectangle.draw(g);
//                            shapeList.add(rectangle);
//
//                        }
//
//                    } else if (shapeName.equals("square")) {
//                        if (square != null) {
//                            square.setFilled(filled);
//                            square.setColour(color);
////                    square.draw(g);
//                            shapeList.add(square);
//
//                        }
//                    }
                    for (int i = 0; i < shapeList.size(); i++) {
                        shapeList.get(i).draw(g);
                    }
//                }
//            }
        }
    }

    public static void main(String[] args) {

        ShapeSketcher fe = new ShapeSketcher();
        JFrame frame = new JFrame("Shape Shifter"); //create frame to hold our JPanel subclass	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(fe);  //add instance of MyGUI to the frame
        frame.pack(); //resize frame to fit our Jpanel

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(new Point((d.width / 2) - (frame.getWidth() / 2), (d.height / 2) - (frame.getHeight() / 2)));
        //show the frame	
        frame.setVisible(true);

    }

}
