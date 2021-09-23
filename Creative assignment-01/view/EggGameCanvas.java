package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Egg;

public class EggGameCanvas extends JPanel{

    private ArrayList<Egg> eggList = new ArrayList<>();

    public EggGameCanvas(EggGameSimulator panel){
        setPreferredSize(new Dimension(500,500));
        setBackground(Color.BLUE);
    }

    @Override
    public void paintComponent(Graphics gh){
        super.paintComponent(gh);

        for(Egg egg: eggList){
            gh.setColor(egg.getColor());  
            gh.fillOval(egg.getX(),egg.getY(),30,50);
        }
    }

    public ArrayList<Egg> getEggList(){
        return eggList;
    }


}
