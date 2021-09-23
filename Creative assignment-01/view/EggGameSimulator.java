package view;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import controller.EggGameEventListener;

import java.awt.GridLayout;


public class EggGameSimulator {

    private JFrame window;
    private EggGameCanvas canvas;
    private JRadioButton whiteButton = new JRadioButton("WHITE");
    private JRadioButton yellowButton = new JRadioButton("YELLOW");
    private JRadioButton orangeButton = new JRadioButton("ORANGE");
    private JButton clearButton = new JButton("CLEAR");
    private JButton exitButton = new JButton("EXIT");
    private JLabel countLabel = new JLabel();
    
    public EggGameSimulator(JFrame window){
        this.window = window;
        window.setTitle("Happy Mrs Chicken Egg Game");
    }

    public void init(){
        Container cp = window.getContentPane();
        JPanel bottomPanel = new JPanel();
        cp.add(BorderLayout.SOUTH,bottomPanel);
        bottomPanel.setLayout(new GridLayout(2,1));

        //radio button
        JPanel radioPanel = new JPanel();
        radioPanel.add(whiteButton);
        radioPanel.add(orangeButton);
        radioPanel.add(yellowButton);
        bottomPanel.add(radioPanel);
        ButtonGroup radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(whiteButton);
        radioButtonGroup.add(orangeButton);
        radioButtonGroup.add(yellowButton);
        TitledBorder title = BorderFactory.createTitledBorder("Color");
        radioPanel.setBorder(title);

        //buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(clearButton);
        buttonPanel.add(exitButton);
        bottomPanel.add(buttonPanel);

        //canvas
        canvas = new EggGameCanvas(this);
        cp.add(BorderLayout.CENTER,canvas);

        //label
        cp.add(BorderLayout.NORTH,countLabel);
        
        //Action Listeners
        EggGameEventListener eventListener = new EggGameEventListener(this);
        clearButton.addActionListener(eventListener);
        exitButton.addActionListener(eventListener);
        whiteButton.addActionListener(eventListener);
        orangeButton.addActionListener(eventListener);
        yellowButton.addActionListener(eventListener);
        canvas.addMouseListener(eventListener);


    }

    public JButton getExitButton(){
        return exitButton;
    }

    public JButton getClearButton(){
        return clearButton;
    }

    public JRadioButton getOrangeButton(){
        return orangeButton;
    }

    public JRadioButton getWhiteButton(){
        return whiteButton;
    }

    public JRadioButton getYellowButton(){
        return yellowButton;
    }

    public JFrame getWindow(){
        return window;
    }

    public EggGameCanvas getCanvas(){
        return canvas;
    }

    public JLabel getCountLabel(){
        return countLabel;
    }
    
}