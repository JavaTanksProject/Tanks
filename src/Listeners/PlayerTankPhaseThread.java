package Listeners;
import Controleur.*;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdDraw3D;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Etienne on 23/05/2015.
 */
    public class PlayerTankPhaseThread extends Thread{
        public void run() {
//            long start = System.currentTimeMillis();
            // boucle tant que la durée de vie du thread est < à 5 secondes
            while( true) {
                // traitement
                if(StdDraw.isKeyPressed(KeyEvent.VK_D)&& Game.tank.tankboady.vx<0.001){//on accélere à droite avec d (mais que si on a pas déjà une vitesse de 0.05
                    Game.tank.tankboady.vx+=0.0002;
                    if (Game.tank.side==1){
                        Game.tank.aim_angle=3.1415-Game.tank.aim_angle;
                        Game.tank.side=0;
                    }


                }
                if(StdDraw.isKeyPressed(KeyEvent.VK_Q)&& Game.tank.tankboady.vx>-0.001){//pareil à gauche
                    Game.tank.tankboady.vx-=0.0002;
                    if (Game.tank.side==0){
                        Game.tank.aim_angle=3.1415-Game.tank.aim_angle;
                        Game.tank.side=1;
                    }

                }
                if(StdDraw.isKeyPressed(KeyEvent.VK_Z)){
                    if(Game.tank.aim_angle<(3.1415/2.0) && Game.tank.side==0){
                    Game.tank.aim_angle+=0.002;}
                    else if(Game.tank.aim_angle>(3.1415/2.0) && Game.tank.side==1){
                        Game.tank.aim_angle-=0.002;

                    }
                }
                if(StdDraw.isKeyPressed(KeyEvent.VK_S) ){
                    if (Game.tank.aim_angle>(-3.1415/5.0)&&Game.tank.side==0){
                    Game.tank.aim_angle-=0.002;}
                    else if (Game.tank.aim_angle<(6.0*3.1415/5.0) && Game.tank.side==1){
                        Game.tank.aim_angle+=0.002;
                    }
                }
                if(StdDraw.isKeyPressed(KeyEvent.VK_UP)&& Game.tank.cannon_power<(0.1)){
                    Game.tank.cannon_power+=0.0001;

                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)&& Game.tank.cannon_power>0.){
                    Game.tank.cannon_power-=0.0001;
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
                            double alpha=Game.tank.tankcannon.angle;
                            Game.ammunitions.add(
                                    new Explosives(Game.tank.tankcannon.x,
                                    Game.tank.tankcannon.y,
                                    Math.cos(alpha)*Game.tank.cannon_power/5.0,
                                    Math.sin(alpha)*Game.tank.cannon_power/5.0,
                                    "ammunstandard.png"));
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                }


                try {
                    // pause
                    Thread.sleep(1);
                }
                catch (InterruptedException ex) {}
            }
        }
    }

