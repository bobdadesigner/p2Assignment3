
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xuchang
 */
public class Line extends Shape {

    private Shape line;
    
    /**
     * @param args the command line arguments
     */
    public Line(Point p) {
        super(p);

//        setPreferredSize(new Dimension(500, 400));
//        setBackground(Color.WHITE);
        
    }

    @Override
    public void draw(Graphics g) {
//        super.paintComponent(g);

        g.setColor(this.getColour());

//        line.draw(g);
// g.drawLine(25, 25, 120, 120);
            
            g.drawLine(line.startPoint.x, line.startPoint.y, line.controlPoint.x, line.controlPoint.y);
//        g.drawLine(this.startPoint.x, this.startPoint.y, this.controlPoint.x, this.controlPoint.y);
    }

    public static void main(String[] args) {

        Line a = new Line(new Point());


        JFrame frame = new JFrame("Following Eyes"); //create frame to hold our JPanel subclass	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(a);  //add instance of MyGUI to the frame
        frame.pack(); //resize frame to fit our Jpanel
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//        frame.setPreferredSize(new Dimension(1000,1000));
        frame.setLocation(new Point((d.width / 2) - (frame.getWidth() / 2), (d.height / 2) - (frame.getHeight() / 2)));
        //show the frame	
        frame.setVisible(true);
    }

}
