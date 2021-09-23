package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MenuScreen {

    private JFrame window;

    public MenuScreen(JFrame window){
        this.window=window;
    }

    public void init(){
        Container cp = window.getContentPane();
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(400,200));
        panel.setLayout(new GridLayout(1,1));
        JButton gameButton = new JButton("Happy Mrs Chicken Egg Game -> click to Enter");
        panel.add(gameButton);
        cp.add(BorderLayout.CENTER,panel);
        gameButton.addActionListener( action -> 
        {

            System.out.println("Enter into Game");
            window.getContentPane().removeAll();
            var game = new EggGameSimulator(window);
            game.init();
            window.pack();
            window.revalidate();


        }
        
        );
    }

}
