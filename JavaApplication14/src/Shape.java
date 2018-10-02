


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
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
public abstract class Shape extends JPanel{
    
    protected Point startPoint;
    protected Point controlPoint;
    private Color colour;
    
    public Shape() {
       this.startPoint = new Point(0,0);
        
    }
    
    public Shape(Point startPoint) {
        this.startPoint = startPoint;
        
    }
    
    public Color getColour() {
        return colour;
    }
    
    public void setColour(Color colour) {
        this.colour = colour;
    }
    
    public void setControlPoint(Point controlPoint) {
        this.controlPoint = controlPoint;
    }
    
    public abstract void draw(Graphics g);
    
    public String toString() {
        
       
        return " startPoint " + startPoint.toString() + " controlPoint " + controlPoint.toString() + " colour " + colour.toString();
    }   
    
    public static void main(String[] args){
        Point p = new Point(10,30);
        Shape a = new Shape() {
            @Override
            public void draw(Graphics g) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        a.setColour(Color.blue);
        a.setControlPoint(p);
        
        
        System.out.println(a.toString());
        System.out.println();
        
        
        
    }
}
