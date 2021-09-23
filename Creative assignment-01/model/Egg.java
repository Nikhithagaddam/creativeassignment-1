package model;

import java.awt.Color;

public class Egg {
   
    private int X;

    private int Y;

    private Color color;

    public Egg(int X, int Y, Color color){
        this.X = X;
        this.Y= Y;
        this.color =color;
    }

    public int getX(){
        return X;
    }

    public int getY(){
        return Y;
    }

    public Color getColor(){
        return color;
    }

}
