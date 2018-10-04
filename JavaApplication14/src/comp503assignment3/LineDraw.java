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
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author xuchang
 */
public class LineDraw extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
    
    private DrawingPanel drawPanel;
    private int PANEL_WIDTH = 500;
    private int PANEL_HEIGHT = 500;
    
    private Line line;
    
    private ArrayList<Line> lineList;
    
    Point startPoint, endPoint;
    
    public LineDraw() {
        super(new BorderLayout());
        
        addMouseMotionListener(this);
        addMouseListener(this);
        
        lineList = new ArrayList<Line>();
        
        drawPanel = new DrawingPanel();
        add(drawPanel, BorderLayout.CENTER);
        
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        line.setControlPoint(e.getPoint());
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
        line = new Line(startPoint);
        drawPanel.repaint();
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {

        endPoint = new Point(e.getPoint());
        repaint();
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    private class DrawingPanel extends JPanel {
        
        public DrawingPanel() {
            setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
            setBackground(Color.WHITE);
            
        }
        
        @Override
        public void paintComponent(Graphics g) {
            
            super.paintComponent(g);
            
            if (line != null) {
                line.draw(g);
                lineList.add(line);
            }
            for (int i = 0; i < lineList.size(); i++) {
                lineList.get(i).draw(g);
            }
            
        }
    }
    
    public static void main(String[] args) {
        
        LineDraw fe = new LineDraw();
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
