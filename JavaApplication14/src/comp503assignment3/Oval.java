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

        int minX = Math.min(controlPoint.x, startPoint.x);
        int minY = Math.min(controlPoint.y, startPoint.y);
        int width = Math.abs(controlPoint.x - startPoint.x);
        int height = Math.abs(controlPoint.y - startPoint.y);

        if (filled) {
            g.setColor(Color.black);
            g.drawOval(minX, minY, width, height);
            g.setColor(this.getColour());
            g.fillOval(minX, minY, width, height);
        } else {
            g.setColor(Color.black);
            g.drawOval(minX, minY, width, height);
        }

    }

}
