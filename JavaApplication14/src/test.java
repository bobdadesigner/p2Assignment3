/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuchang
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class test extends JPanel {
    
    test() {
        super();
        this.addMouseListener(new LineDrawer(this));
    }
    
    class LineDrawer implements MouseMotionListener, MouseListener {
        
        Line line;
        JPanel parent;
        public LineDrawer(JPanel parent) {
            this.parent = parent;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            this.line.setControlPoint(e.getPoint());
            System.out.println(e.getPoint());
            this.line.repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (this.line != null) {
                this.parent.remove(this.line);
            }
            System.out.println(e.getPoint());
            this.line = new Line(e.getPoint());
            this.line.setColour(Color.blue);
            this.parent.add(line);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            this.line.setControlPoint(e.getPoint());
            System.out.println("end point: " + e.getPoint());
            this.line.repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

//  public void paint(Graphics g) {
//    g.drawLine(25, 25, 120, 120);
//  
//  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.getContentPane().add(new test());
    
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(200,200);
    frame.setVisible(true);
  }
}
           
