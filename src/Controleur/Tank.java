package Controleur;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

/**
 * Created by Etienne on 25/05/2015.
 */
public class Tank {
    public TankBoady     tankboady;
    public TankHead      tankhead;
    public TankCannon    tankcannon;
    public int           player;
    public int           pv;
    public double        aim_angle;//en radian
    public double        cannon_power;
    public int           side;//0 à droite 1 à gauche
    public Explosives    loaded_ammunition;




    public Tank(int player){
        this.player=player;
        this.tankboady=new TankBoady(player);
        this.tankhead=new TankHead(player);
        this.tankcannon=new TankCannon(player);
        this.pv=100;
        aim_angle=0.;
        if (player==1){
                    this.side=0;}
        else{
                    this.side=1;}

    }
public void  moveAndDisplay (){

    tankboady.setSide(side,player);
    tankboady.moveAndDisplay();
    tankboady.not_the_edge();


    tankcannon.setSide(side,player);
    tankcannon.move(aim_angle,tankhead);
    tankcannon.display();


    tankhead.setSide(side,player);
    tankhead.move(aim_angle,tankboady);
    tankhead.display();

    //les stats


        if (player==1){
            if(cannon_power>0.0001 && Game.active_tank.player==player){
                StdDraw.setPenColor(ColorLibrary.grey);
                StdDraw.filledRectangle(0.11, 0.9, cannon_power, 0.005);
                StdDraw.text(0.11, 0.911,"Cannon power");}

            StdDraw.setPenColor(ColorLibrary.green_to_red(pv));
            StdDraw.filledRectangle(pv*0.001,Game.height*0.95,pv*0.001,0.005);
            }


        if (player==2){
            if(cannon_power>0.0001 && Game.active_tank.player==player){StdDraw.setPenColor(ColorLibrary.grey);
                StdDraw.filledRectangle(1.89, 0.9, cannon_power, 0.005);
                StdDraw.text(1.89, 0.911,"Cannon power");}

            StdDraw.setPenColor(ColorLibrary.green_to_red(pv));
            StdDraw.filledRectangle(Game.lenght-pv*0.001,Game.height*0.95,pv*0.001,0.005);

        }

        }

    public void tanks_expl(int damage, double radius,double x,double y){
            double d = Math.sqrt((x-this.tankboady.x)*(x-this.tankboady.x)+(y-this.tankboady.y)*(y-this.tankboady.y));

            if ( d < radius){
                if(d <= 0.1*radius){
                    this.pv -= damage/radius/10;  //egale a lancien tank.pv -damage
                }
                else
                    this.pv -= damage;

            }
    }

}
