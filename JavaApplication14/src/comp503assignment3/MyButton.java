/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp503assignment3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author xuchang
 */
public class MyButton extends JPanel {

    private JButton button;

    public MyButton(String buttonName) {

        this.button = new JButton(buttonName);
        this.button.setForeground(Color.white);
        this.button.setFont(new Font("Helvetica", Font.BOLD, 15));
        this.button.setBorderPainted(true);
        this.button.setBorder(new LineBorder(Color.GRAY));
        this.button.setBackground(Color.DARK_GRAY);
        this.button.setOpaque(true);
        this.button.setPreferredSize(new Dimension(90, 30));

        this.button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                button.setBackground(Color.DARK_GRAY);
                button.setForeground(Color.LIGHT_GRAY);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(Color.GRAY);
                button.setForeground(Color.white);
                repaint();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.GRAY);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.DARK_GRAY);
                repaint();
            }

        });

        this.add(button);

    }

    public void addButtActionListener(ActionListener l) {
        this.button.addActionListener(l);
    }
}
