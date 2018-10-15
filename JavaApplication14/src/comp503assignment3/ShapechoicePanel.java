/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp503assignment3;

import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author xuchang
 */
public class ShapechoicePanel extends JPanel {

    protected MyButton lineButton, ovalButton, circleButton, rectangleButton, squareButton, colourButton;

    public ShapechoicePanel() {
        lineButton = new MyButton("Line");
        ovalButton = new MyButton("Oval");
        circleButton = new MyButton("Circle");
        rectangleButton = new MyButton("Rectangle");
        squareButton = new MyButton("Square");
        colourButton = new MyButton("Colour");
        this.add(lineButton);
        this.add(ovalButton);
        this.add(circleButton);
        this.add(rectangleButton);
        this.add(squareButton);
        this.add(colourButton);
    }

    public void addLineButtonActionListener(ActionListener l) {
        this.lineButton.addButtActionListener(l);
    }

    public void addOvalButtonActionListener(ActionListener l) {
        this.ovalButton.addButtActionListener(l);
    }

    public void addCircleButtonActionListener(ActionListener l) {
        this.circleButton.addButtActionListener(l);
    }

    public void addRectangleButtonActionListener(ActionListener l) {
        this.rectangleButton.addButtActionListener(l);
    }

    public void addSquareButtonActionListener(ActionListener l) {
        this.squareButton.addButtActionListener(l);
    }

    public void addColourButtonActionListener(ActionListener l) {
        this.colourButton.addButtActionListener(l);
    }

}
