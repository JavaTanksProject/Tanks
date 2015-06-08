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
        this.loaded_ammunition=new Explosives(0,0,0,0);
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

    this.show_stats();

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
    public void show_stats(){
        if (player==1){
            if(cannon_power>0.0001 && Game.active_tank.player==player){
                StdDraw.setPenColor(ColorLibrary.grey);
                StdDraw.filledRectangle(0.1, 0.9, cannon_power, 0.005);
                StdDraw.text(0.1, 0.911,"Cannon power");

            }
            if (pv>0){
                StdDraw.setPenColor(ColorLibrary.green_to_red(pv));
                StdDraw.filledRectangle(pv*0.001,Game.height*0.95,pv*0.001,0.005);}
            if (Game.active_tank.player==player){
                StdDraw.picture(0.1,0.98*Game.height,this.loaded_ammunition.picturepath,0.045,0.045);
                StdDraw.setPenColor(ColorLibrary.grey);
                StdDraw.text(0.15,0.98*Game.height," "+Main.player1.personal_goods[this.loaded_ammunition.id]);
            }
            if (pv<1){StdDraw.picture(1.0, 0.5, "player2wins.png");
                Main.level_of_computer++;
            StdDraw.show(2000);
                Main.gameover=true;
            }
        }


        if (player==2){
            if(cannon_power>0.0001 && Game.active_tank.player==player){StdDraw.setPenColor(ColorLibrary.grey);
                StdDraw.filledRectangle(0.95*Game.lenght, 0.9, cannon_power, 0.005);
                StdDraw.text(0.95*Game.lenght, 0.911,"Cannon power");}
            if (pv>0){
                StdDraw.setPenColor(ColorLibrary.green_to_red(pv));
                StdDraw.filledRectangle(Game.lenght-pv*0.001,Game.height*0.95,pv*0.001,0.005);}
            if (Game.active_tank.player==player) {
                StdDraw.picture(0.95 * Game.lenght, 0.98 * Game.height, this.loaded_ammunition.picturepath, 0.045, 0.045);
                StdDraw.setPenColor(ColorLibrary.grey);
                StdDraw.text(0.95 * Game.lenght+0.04,0.98*Game.height," "+Main.player2.personal_goods[this.loaded_ammunition.id]);

            }
            if (pv<1){StdDraw.picture(1.0, 0.5, "player1wins.png");
                Main.level_of_computer++;
                StdDraw.show(2000);
                Main.gameover=true;}

        }

    }

}
