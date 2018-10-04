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
public class Oval extends Shape implements EnclosesRegion {

    private boolean filled;

    public Oval(Point startPoint) {
        super(startPoint);

    }

    @Override
    public void setFilled(boolean filled) {

        this.filled = filled;

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColour());

        if (filled) {
            g.fillOval(startPoint.x / 2, startPoint.y / 2, controlPoint.x, controlPoint.y);
        } else {
            g.drawOval(startPoint.x / 2, startPoint.y / 2, controlPoint.x, controlPoint.y);
        }

    }

}
