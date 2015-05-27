package Listeners;
import Controleur.*;

import edu.princeton.cs.introcs.StdDraw;

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
                }
                if(StdDraw.isKeyPressed(KeyEvent.VK_Q)&& Game.tank.tankboady.vx>-0.001){//pareil à gauche
                    Game.tank.tankboady.vx-=0.0002;
                }
                if(StdDraw.isKeyPressed(KeyEvent.VK_Z) && Game.tank.aim_angle<(3.1415/2.0)){
                    Game.tank.aim_angle+=0.01;
                }
                if(StdDraw.isKeyPressed(KeyEvent.VK_S)&& Game.tank.aim_angle>(-3.1415/5.0)){
                    Game.tank.aim_angle-=0.01;
                }
                if(StdDraw.isKeyPressed(KeyEvent.VK_S)&& Game.tank.aim_angle>(-3.1415/5.0)){
                    Game.tank.aim_angle-=0.01;
                }


                try {
                    // pause
                    Thread.sleep(1);
                }
                catch (InterruptedException ex) {}
            }
        }
    }

