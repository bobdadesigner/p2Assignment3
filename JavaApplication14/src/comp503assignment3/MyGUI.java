/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp503assignment3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author sehall
 */
public class MyGUI extends JPanel{
    public final int PANEL_WIDTH = 300;
    public final int PANEL_HEIGHT = 300;
    private JLabel label,label2;
    private JButton changeBGColour;
    private JButton changeTextColour;

    public MyGUI() {
        super();   //invoke super class Jpanel constructor
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        //set JPanel size
	label = new JLabel("HELLO THERE WORLD!");
	changeBGColour = new JButton("ChangeBackgroundColor");
        changeTextColour = new JButton("ChangeTextColor");
        changeBGColour.addActionListener(new ButtonListener());
        changeTextColour.addActionListener(new ButtonListener());
	add(label); //can do this ass Jpanel has an add method that adds any Jcomponent (Jlabel is-a JComponent
        add(changeBGColour);
        add(changeTextColour);
    }
    private class ButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            Color c = JColorChooser.showDialog(MyGUI.this, "PICK A COLOUR", Color.BLACK);
            if(source == changeTextColour)
            {
                label.setForeground(c);
            }
            if(source == changeBGColour)
            {
                setBackground(c);
            }
        }
        
    }
    public static void main(String[] args) {
        MyGUI myPanel = new MyGUI();
        JFrame frame = new JFrame("ColourChanger"); //create frame to hold our JPanel subclass	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(myPanel);  //add instance of MyGUI to the frame
        frame.pack(); //resize frame to fit our Jpanel
        //Position frame on center of screen 
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth = d.width;
        frame.setLocation(new Point((screenWidth / 2) - (frame.getWidth() / 2), (screenHeight / 2) - (frame.getHeight() / 2)));
	//show the frame	
        frame.setVisible(true);
    }
}
