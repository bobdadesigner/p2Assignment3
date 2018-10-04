package comp503assignment3;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xuchang
 */
public class CircleDraw extends OvalDraw {

    private DrawingPanel drawPanel;
    private int PANEL_WIDTH = 500;
    private int PANEL_HEIGHT = 500;

    private Circle circle;

    private ArrayList<Circle> circleList;

    public CircleDraw() {
        super();

        circleList = new ArrayList<Circle>();

        drawPanel = new DrawingPanel();
        add(drawPanel, BorderLayout.CENTER);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        circle.setControlPoint(e.getPoint());
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

        startPoint = new Point(e.getPoint());
        circle = new Circle(startPoint);

    }

    private class DrawingPanel extends JPanel {

        public DrawingPanel() {
            setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
            setBackground(Color.WHITE);

        }

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            if (circle != null) {
                circle.draw(g);
                circleList.add(circle);
            }
            for (int i = 0; i < circleList.size(); i++) {
                circleList.get(i).draw(g);
            }

        }
    }
//
//    private class DrawingPanel extends JPanel {
//            
//    }

    public static void main(String args[]) {

        CircleDraw fe = new CircleDraw();
        JFrame frame = new JFrame("Following Eyes"); //create frame to hold our JPanel subclass	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(fe);  //add instance of MyGUI to the frame
        frame.pack(); //resize frame to fit our Jpanel
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(new Point((d.width / 2) - (frame.getWidth() / 2), (d.height / 2) - (frame.getHeight() / 2)));
        //show the frame	
        frame.setVisible(true);
    }

}
