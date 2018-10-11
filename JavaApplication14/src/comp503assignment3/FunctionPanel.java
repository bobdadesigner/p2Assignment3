/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comp503assignment3;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 *
 * @author xuchang
 */
public class FunctionPanel extends JPanel {

//    private BoxLayout box;
    protected MyButton exitButton, saveButton, openButton, undoButton, clearButton;
    protected JCheckBox filledCheck;

    public FunctionPanel() {

        exitButton = new MyButton("exit");
        saveButton = new MyButton("save");
        openButton = new MyButton("open");
        undoButton = new MyButton("undo");
        clearButton = new MyButton("clear");
        filledCheck = new JCheckBox("Fill Colour");

        this.add(exitButton);
        this.add(saveButton);
        this.add(openButton);
        this.add(undoButton);
        this.add(clearButton);
        this.add(filledCheck);

    }

    public void addExitButtonActionListener(ActionListener l) {
        this.exitButton.addButtActionListener(l);
    }

    public void addSaveButtonActionListener(ActionListener l) {
        this.saveButton.addButtActionListener(l);
    }

    public void addOpenButtonActionListener(ActionListener l) {
        this.openButton.addButtActionListener(l);
    }

    public void addundoButtonActionListener(ActionListener l) {
        this.undoButton.addButtActionListener(l);
    }

    public void addClearButtonActionListener(ActionListener l) {
        this.clearButton.addButtActionListener(l);
    }

    public void addFilledCheckActionListener(ActionListener l) {
        this.filledCheck.addActionListener(l);
    }

}
