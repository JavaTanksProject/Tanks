package Controleur;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Created by Etienne on 25/05/2015.
 */
public class TankHead extends PhysObj{

        public int side;//0 à droite 1 à gauche



        public TankHead(int player) {
            if (player == 1) {this.side=0;
                this.picturepath="head_tank_"+player+"_right.png";
            }
            else if (player==2){this.side=1;
                this.picturepath="head_tank_"+player+"_left.png";}


        }
        public void move(double aim_angle,TankBoady tank_boady){
            double boady_angle=tank_boady.angle;
            if (side==0){this.angle=boady_angle+aim_angle*0.2;}//parce que la tete gere 20% de l'inclinaison
            else if (side ==1){this.angle=3.1415+boady_angle+aim_angle*0.2;}
            this.x=tank_boady.x-(Math.sin(boady_angle))*0.0747;
            this.y=tank_boady.y+0.05+(0.0747)*(Math.cos(boady_angle));//on part du millieu du active_tank + le rayon changé moins 0.0003 bout pour gerer le décalage tete/corps


        }
        public void display(){
            if (side==0){
            StdDraw.picture(this.x, this.y, this.picturepath, 0.055, 0.055, this.angle * 57.29);}
            else if (side==1){StdDraw.picture(this.x, this.y, this.picturepath, 0.055, 0.055, this.angle * 57.29);}

        }
        public void wind(){}//le vent n'agit pes sur le active_tank
        public void setSide(int side,int player){
            this.side=side;
            if( side==0){this.picturepath="head_tank_"+player+"_right.png";}
            else{this.picturepath="head_tank_"+player+"_left.png";}
        }
}
