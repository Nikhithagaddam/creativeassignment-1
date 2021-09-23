package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;

import javax.swing.JFrame;

import model.Egg;
import view.EggGameSimulator;
import view.MenuScreen;

public class EggGameEventListener implements ActionListener,MouseListener{

    private EggGameSimulator simulator;
    private Color color = Color.YELLOW;
    private int eggsCount = 0;

    public EggGameEventListener(EggGameSimulator simulator){
        this.simulator = simulator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object source = e.getSource();

        if(source == simulator.getExitButton()){
            System.out.println("Exit Button Clicked");
            JFrame window = simulator.getWindow();
            window.getContentPane().removeAll();
            var menu = new MenuScreen(window);
            menu.init();
            window.pack();
            window.revalidate();
        }else if(source == simulator.getClearButton()){
            System.out.println("Clear Button Clicked");
            simulator.getCanvas().getEggList().clear();
            eggsCount=0;
            simulator.getCountLabel().setText("Number of Eggs Created "+eggsCount);
            simulator.getCanvas().repaint();
        }else if(source == simulator.getWhiteButton()){
            System.out.println("White Button Clicked");
            color = Color.WHITE;
        }else if(source == simulator.getOrangeButton()){
            System.out.println("Orange Button Clicked");
            color = Color.ORANGE;
        }else if(source == simulator.getYellowButton()){
            System.out.println("Yellow Button Clicked");
            color = Color.YELLOW;
        }
        
    }
  
    @Override
    public void mouseClicked(MouseEvent e) {
        Egg egg = new Egg(e.getX(),e.getY(),color);
        simulator.getCanvas().getEggList().add(egg);
        simulator.getCanvas().repaint();       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ++eggsCount;
        simulator.getCountLabel().setText("Number of Eggs Created "+eggsCount);
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
