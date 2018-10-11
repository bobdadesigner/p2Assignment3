/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp503assignment3;

import java.awt.Graphics;

/**
 *
 * @author xuchang
 */
public class CoordinateXY {

    private int x;
    private int y;
    private String info;

    public CoordinateXY(String info, int x, int y){
        this.x = x;
        this.y = y;
        this.info = info;
        
    }

    public void draw(Graphics g) {

        g.drawString(info, x, y);
    }
}
