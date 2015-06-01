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
    public double        aim_angle;
    public double        cannon_power;
    public int           side;//0 à droite 1 à gauche





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

    tankcannon.move(aim_angle,tankhead);
    tankcannon.display();

    tankhead.move(aim_angle,tankboady);
    tankhead.display();
    if(cannon_power>0.0001){
    StdDraw.setPenColor(ColorLibrary.grey);
    StdDraw.filledRectangle(0.11, 0.9, cannon_power, 0.005);
    StdDraw.text(0.11, 0.911,"Cannon power");}



    }


}
