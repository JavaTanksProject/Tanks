package Controleur;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Created by Etienne on 25/05/2015.
 */
public class TankHead extends PhysObj{

        public int side;//0 à droite 1 à gauche



        public TankHead(int player) {
            if (player == 1) {this.side=0;}
            else if (player==2){this.side=0;}//à terme faudra changer le sens d'apparition pour player 2

            this.picturepath="head_tank_"+player+".png";
        }
        public void move(double aim_angle,TankBoady tank_boady){
            double boady_angle=tank_boady.angle;
            this.angle=boady_angle+aim_angle*0.1;//parce que la tete gere 0.1% de l'inclinaison
            this.x=tank_boady.x-(Math.sin(boady_angle))*0.0747;
            this.y=tank_boady.y+0.05+(0.0747)*(Math.cos(boady_angle));//on part du millieu du tank + le rayon changé moins 0.0003 bout pour gerer le décalage tete/corps


        }
        public void display(){
            StdDraw.picture(this.x, this.y, this.picturepath, 0.055, 0.055, this.angle * 57.29);

        }
        public void wind(){}//le vent n'agit pes sur le tank

}
