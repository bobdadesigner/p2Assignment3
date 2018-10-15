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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author xuchang
 */
public class ShapeSketcher extends JPanel implements MouseMotionListener, MouseListener {

    private DrawingPanel drawPanel;
    private int PANEL_WIDTH = 500;
    private int PANEL_HEIGHT = 700;
    private Shape shape;
    private ShapechoicePanel shapechoicePanel;
    private FunctionPanel functionPanel;
    private ArrayList<Shape> shapeList;
    private Point startPoint = null;
    private Point HorizVerPoint = null;
    private String shapeName = "line";
    private boolean filled = false;
    private Color color;

    public ShapeSketcher() {
        super(new BorderLayout());

        this.setBackground(Color.black);
        shapechoicePanel = new ShapechoicePanel();
        functionPanel = new FunctionPanel();
        shapeList = new ArrayList<Shape>();
        addMouseMotionListener(this);
        addMouseListener(this);
        addButtonListeners();

        drawPanel = new DrawingPanel();

        add(drawPanel, BorderLayout.NORTH);
        add(shapechoicePanel, BorderLayout.CENTER);
        add(functionPanel, BorderLayout.SOUTH);
        filled = functionPanel.filledCheck.isSelected();

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        shape.setControlPoint(e.getPoint());
        HorizVerPoint.x = e.getX();
        HorizVerPoint.y = e.getY();

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
        startPoint = new Point(e.getPoint());
        HorizVerPoint = new Point(e.getPoint());
        if (shapeName == "oval") {
            Oval oval = new Oval(startPoint);
            oval.setFilled(filled);
            shape = oval;
            shape.setColour(color);
            shapeList.add(shape);
        } else if (shapeName == "line") {
            Line line = new Line(startPoint);
            shape = line;
            shapeList.add(shape);
        } else if (shapeName == "circle") {
            Circle circle = new Circle(startPoint);
            circle.setFilled(filled);
            shape = circle;
            shape.setColour(color);
            shapeList.add(shape);
        } else if (shapeName == "rectangle") {
            Rectangle rectangle = new Rectangle(startPoint);
            rectangle.setFilled(filled);
            shape = rectangle;
            shape.setColour(color);
            shapeList.add(shape);
        } else if (shapeName == "square") {
            Square square = new Square(startPoint);
            square.setFilled(filled);
            shape = square;
            shape.setColour(color);
            shapeList.add(shape);
        }

        repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        shape.setControlPoint(e.getPoint());

        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public ArrayList<Shape> getShapeList() {
        return shapeList;
    }

    private void addButtonListeners() {
        shapechoicePanel.addLineButtonActionListener(l -> shapeName = "line");
        shapechoicePanel.addOvalButtonActionListener(l -> shapeName = "oval");
        shapechoicePanel.addCircleButtonActionListener(l -> shapeName = "circle");
        shapechoicePanel.addRectangleButtonActionListener(l -> shapeName = "rectangle");
        shapechoicePanel.addSquareButtonActionListener(l -> shapeName = "square");
        shapechoicePanel.addColourButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent l) {
                color = JColorChooser.showDialog(shapechoicePanel, "PICK A COLOUR", Color.BLACK);
                functionPanel.filledCheck.setSelected(true);
                filled = functionPanel.filledCheck.isSelected();

            }
        });

        functionPanel.addExitButtonActionListener(l -> System.exit(0));
        functionPanel.addSaveButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent l) {
                JFileChooser chooser = new JFileChooser(new File("."));
                int status = chooser.showSaveDialog(null);
                if (status == JFileChooser.APPROVE_OPTION) {
                    try {
                        saveShapeToFile(shapeList, chooser.getSelectedFile());
                    } catch (IOException ex) {
                        System.out.println("save io exception");
                        Logger.getLogger(ShapeSketcher.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        functionPanel.addOpenButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent l) {
                JFileChooser chooser = new JFileChooser(new File("."));
                chooser.showOpenDialog(null);
                try {
                    shapeList = loadShapeFromFile(chooser.getSelectedFile());
                } catch (IOException ex) {
                    System.out.println("load io exception");
                    JOptionPane.showMessageDialog(chooser, "not able to read file, please select a valid file");

                } catch (ClassNotFoundException ex) {
                    System.out.println("class not found exception");
                    Logger.getLogger(ShapeSketcher.class.getName()).log(Level.SEVERE, null, ex);
                }
                repaint();
            }
        });

        functionPanel.addundoButtonActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent l) {
                try {
                    if (shapeList != null) {
                        shapeList.remove(shapeList.size() - 1);
                        repaint();
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(functionPanel, "no more shape");
                }
            }
        });
        functionPanel.addClearButtonActionListener((ActionEvent l) -> {
            shapeList.clear();
            repaint();
        });
        functionPanel.addFilledCheckActionListener((ActionEvent l) -> {
            filled = functionPanel.filledCheck.isSelected();
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
            try {
                for (int i = 0; i < shapeList.size(); i++) {
                    shapeList.get(i).draw(g);
                }

                if (startPoint.x == HorizVerPoint.x && startPoint != null) {
                    g.drawString("V", HorizVerPoint.x, HorizVerPoint.y);
                } else if (startPoint.y == HorizVerPoint.y && startPoint != null) {
                    g.drawString("H", HorizVerPoint.x, HorizVerPoint.y);
                }

            } catch (NullPointerException e) {

            }
        }
    }

    public void saveShapeToFile(ArrayList<Shape> shapeLi, File f) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeInt(shapeLi.size());
        for (Shape c : shapeLi) {
            oos.writeObject(c);
        }
        oos.flush();
        oos.close();
    }
//

    public ArrayList<Shape> loadShapeFromFile(File f) throws IOException, ClassNotFoundException {
        ArrayList<Shape> list = new ArrayList<>();
        Shape ba = null;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
        int size = ois.readInt();
        for (int i = 0; i < size; i++) {
            ba = (Shape) ois.readObject();
            list.add(ba);
        }
        ois.close();
        return list;
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
