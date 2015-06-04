/**
 * Created by Etienne on 11/05/2015.
 */
package Controleur;

import edu.princeton.cs.introcs.StdDraw;

public class TankBoady extends PhysObj{
        public static double rebounce_coeff=0.2;
        public  static double gravity=0.0001;
        public int side;//0 à droite 1 à gauche



        public TankBoady(int player) {
            if (player == 1) {
                this.x = 0.1;
                this.side=0;
                this.picturepath="boady_tank_"+player+"_right.png";}

            else if (player==2){
                this.x=1.9;
                this.side=0;
                this.picturepath="boady_tank_"+player+"_left.png";}//à terme faudra changer le sens d'apparition pour player 2

                this.y = 1;
                this.vx=0.;
                this.vy=0.;
                this.angle=0.;


        }
    public double getRebounce_coeff(){
        return rebounce_coeff;
    }
    public double getGravity(){
        return gravity;
    }
    public void wind(){}
    public void display (){
        StdDraw.picture(x, y + 0.05, picturepath, 0.15, 0.1, angle * 57.29);}//on convertie en degré nos radians
    public void not_the_edge(){
        if (this.x<0.02) {
            vx = 0;
            x = 0.02;
        }
        if (this.x>0.999*Game.lenght){
            vx=0;
            x=0.995*Game.lenght;
        }

    }
    public void setSide(int side,int player){
        this.side=side;
        if( side==0){this.picturepath="boady_tank_"+player+"_right.png";}
        else{this.picturepath="boady_tank_"+player+"_left.png";}
    }






}

