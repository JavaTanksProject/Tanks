package Listeners;
import Controleur.*;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.event.KeyEvent;

/**
 * Created by Etienne on 23/05/2015.
 */
    public class PlayerTankPhaseThread extends Thread{
        public void run() {
            int running_player=1;

//            long start = System.currentTimeMillis();
            // boucle tant que la durée de vie du thread est < à 5 secondes
            while( true) {
                // traitement
                if(StdDraw.isKeyPressed(KeyEvent.VK_D)&& Game.active_tank.tankboady.vx<0.001){//on accélere à droite avec d (mais que si on a pas déjà une vitesse de 0.05
                    Game.active_tank.tankboady.vx+=0.0002;
                    if (Game.active_tank.side==1){
                        Game.active_tank.aim_angle=-Game.active_tank.aim_angle;
                        Game.active_tank.side=0;
                    }


                }
                if(StdDraw.isKeyPressed(KeyEvent.VK_Q)&& Game.active_tank.tankboady.vx>-0.001){//pareil à gauche
                    Game.active_tank.tankboady.vx-=0.0002;
                    if (Game.active_tank.side==0){
                        Game.active_tank.aim_angle=-Game.active_tank.aim_angle;
                        Game.active_tank.side=1;
                    }

                }
                if(StdDraw.isKeyPressed(KeyEvent.VK_Z)){
                    if(Game.active_tank.aim_angle<(3.1415/2.0) && Game.active_tank.side==0){
                    Game.active_tank.aim_angle+=0.002;}
                    else if(Game.active_tank.aim_angle>(-3.1415/2.0) && Game.active_tank.side==1){
                        Game.active_tank.aim_angle-=0.002;
                    }
                }
                if(StdDraw.isKeyPressed(KeyEvent.VK_S) ){
                    if (Game.active_tank.aim_angle>(-3.1415/5.0)&&Game.active_tank.side==0){
                    Game.active_tank.aim_angle-=0.002;}
                    else if (Game.active_tank.aim_angle<(3.1415/5.0)&& Game.active_tank.side==1){
                        Game.active_tank.aim_angle+=0.002;
                    }
                }
                if(StdDraw.isKeyPressed(KeyEvent.VK_UP)&& Game.active_tank.cannon_power<(0.1)){
                    Game.active_tank.cannon_power+=0.0001;

                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)&& Game.active_tank.cannon_power>0.){
                    Game.active_tank.cannon_power-=0.0001;
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_L)&& Game.active_tank.pv<100){
                    Game.active_tank.pv+=1;
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (StdDraw.isKeyPressed(KeyEvent.VK_K)&& Game.active_tank.pv>0){
                    Game.active_tank.pv-=1;
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }






                if (running_player==1){Game.tank1=Game.active_tank;} //
                else Game.tank2=Game.active_tank;








                if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
                            double alpha=Game.active_tank.tankcannon.angle;
                            Game.ammunitions.add(
                                    new Frag(Game.active_tank.tankcannon.x,
                                    Game.active_tank.tankcannon.y,
                                    Math.cos(alpha)*Game.active_tank.cannon_power/5.0,
                                    Math.sin(alpha)*Game.active_tank.cannon_power/5.0
                                    ));

                            if (running_player==1){
                                running_player=2;
                                Game.active_tank=Game.tank2;
                            }                       //on passe au tour de l'autre joueur
                            else {
                                running_player = 1;
                                Game.active_tank=Game.tank1;
                            }


                            try {
                                Thread.sleep(2000);
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

