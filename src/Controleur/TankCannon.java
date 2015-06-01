package Controleur;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

/**
 * Created by Etienne on 25/05/2015.
 */
public class TankCannon extends PhysObj {


    public int side;//0 à droite 1 à gauche


    public TankCannon(int player) {
        if (player == 1) {
            this.side = 0;
            this.picturepath = "cannon_tank_" + player + "_right.png";
        } else if (player == 2) {
            this.side = 1;
            this.picturepath = "cannon_tank_" + player + "_left.png";
        }


    }

    public void move(double aim_angle, TankHead tank_head) {
        double head_angle = tank_head.angle;
        this.angle = head_angle + aim_angle * 0.6;//parce que le gere 80% de l'inclinaison et que la tete en a a déja pris 20
        this.x = tank_head.x+0.05*(Math.cos(angle));
        this.y = tank_head.y+0.05*(Math.sin(angle));


    }

    public void display() {
//        StdDraw.setPenColor(Color.WHITE);
//        StdDraw.filledCircle(x,y,0.01);
        StdDraw.picture(this.x, this.y, this.picturepath, 0.11, 0.03, this.angle * 57.29);
    }
    public void setSide(int side,int player){
        this.side=side;
        if( side==0){this.picturepath="cannon_tank_"+player+"_right.png";}
        else{this.picturepath="cannon_tank_"+player+"_left.png";}
    }
}
