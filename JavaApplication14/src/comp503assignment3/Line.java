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
public class Line extends Shape {

//    private Shape line;
    /**
     * @param args the command line arguments
     */
    public Line(Point startPoint) {
        super(startPoint);

    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(startPoint.x, startPoint.y, controlPoint.x, controlPoint.y);

    }

}
