package comp503assignment3;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xuchang
 */
public abstract class Shape {

    protected Point startPoint;
    protected Point controlPoint;
    private Color colour;

    public Shape() {
        this.startPoint = new Point(0, 0);
        this.controlPoint = new Point(0, 0);

    }

    public Shape(Point startPoint) {
        this.startPoint = startPoint;
        this.controlPoint = startPoint;
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

}
