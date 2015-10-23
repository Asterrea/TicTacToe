import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Board extends JPanel {
    private JButton label4;
    private JButton label1;
    private JButton label7;
    private JButton label2;
    private JButton lbael5;
    private JButton label8;
    private JButton label3;
    private JButton label6;
    private JButton label9;
    private JLabel labelTurn;
    private JTextField inputPlayer;
    private JButton buttonRestart;
    private JLabel labelWinner;

    public Board() {
        //construct components
        label4 = new JButton ("");
        label1 = new JButton ("");
        label7 = new JButton ("");
        label2 = new JButton ("");
        lbael5 = new JButton ("");
        label8 = new JButton ("");
        label3 = new JButton ("");
        label6 = new JButton ("");
        label9 = new JButton ("");
        labelTurn = new JLabel ("Turn:");
        inputPlayer = new JTextField (1);
        buttonRestart = new JButton ("Play Again");
        labelWinner = new JLabel ("Player Wins!");

        //set components properties
        inputPlayer.setEnabled (false);

        //adjust size and set layout
        setPreferredSize (new Dimension (773, 477));
        setLayout (null);

        //add components
        add (label4);
        add (label1);
        add (label7);
        add (label2);
        add (lbael5);
        add (label8);
        add (label3);
        add (label6);
        add (label9);
        add (labelTurn);
        add (inputPlayer);
        add (buttonRestart);
        add (labelWinner);

        //set component bounds (only needed by Absolute Positioning)
        label4.setBounds (0, 160, 150, 160);
        label1.setBounds (0, 0, 150, 160);
        label7.setBounds (0, 320, 150, 160);
        label2.setBounds (150, 0, 155, 160);
        lbael5.setBounds (150, 160, 155, 160);
        label8.setBounds (150, 320, 155, 160);
        label3.setBounds (305, 0, 155, 160);
        label6.setBounds (305, 160, 155, 160);
        label9.setBounds (305, 320, 155, 160);
        labelTurn.setBounds (475, 20, 35, 25);
        inputPlayer.setBounds (510, 20, 235, 25);
        buttonRestart.setBounds (570, 245, 100, 25);
        labelWinner.setBounds (580, 205, 80, 25);
        
        labelWinner.setVisible(false);
        buttonRestart.setVisible(false);
    }


    public static void main (String[] args) {
        JFrame frame = new JFrame ("Board");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Board());
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible (true);
    }
}
