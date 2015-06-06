package Listeners;
import Controleur.*;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.event.KeyEvent;

/**
 * Created by Etienne on 23/05/2015.
 */
    public class PlayerTankPhaseThread extends Thread{
        public void run() {
        	int canon_lock = 0;
            int running_player=1;

          
//            long start = System.currentTimeMillis();
            // boucle tant que la durée de vie du thread est < à 5 secondes
            while( true) {
            	
            		if(StdDraw.isKeyPressed(KeyEvent.VK_D)&& Game.active_tank.tankboady.vx<0.001){//on accélere à droite avec d (mais que si on a pas déjà une vitesse de 0.05
                    Game.active_tank.tankboady.vx+=0.0002;
                    	if (Game.active_tank.side==1){
                        Game.active_tank.aim_angle=-Game.active_tank.aim_angle;
                        Game.active_tank.side=0;
                    	}
                    canon_lock = 1;
            		}
            			
                  	if(StdDraw.isKeyPressed(KeyEvent.VK_Q)&& Game.active_tank.tankboady.vx>-0.001){//pareil à gauche
                    Game.active_tank.tankboady.vx-=0.0002;
                    	if (Game.active_tank.side==0){
                        Game.active_tank.aim_angle=-Game.active_tank.aim_angle;
                        Game.active_tank.side=1;
                    	}
                canon_lock = 1;
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


                if (StdDraw.isKeyPressed(KeyEvent.VK_1))
                {Game.active_tank.loaded_ammunition=new Explosives(0,0,0,0,"ammunstandard.png");}

                if (StdDraw.isKeyPressed(KeyEvent.VK_2))
                {Game.active_tank.loaded_ammunition=new Frag(0,0,0,0);}

                if (StdDraw.isKeyPressed(KeyEvent.VK_3))
                {Game.active_tank.loaded_ammunition=new VerticalFrag(0,0,0,0);}






                if (running_player==1){Game.tank1=Game.active_tank;} //
                else Game.tank2=Game.active_tank;








                if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)){
                	if(canon_lock == 0){
                		 double alpha=Game.active_tank.tankcannon.angle;
                    Explosives to_be_sent=Game.active_tank.loaded_ammunition;
                        to_be_sent.x=Game.active_tank.tankcannon.x;
                        to_be_sent.y=Game.active_tank.tankcannon.y;
                        to_be_sent.vx=Math.cos(alpha)*Game.active_tank.cannon_power/5.0;
                        to_be_sent.vy=Math.sin(alpha)*Game.active_tank.cannon_power/5.0;
                            Game.ammunitions.add(to_be_sent);//on tire
                        Game.active_tank.loaded_ammunition=new Explosives(0,0,0,0,"ammunstandard.png");//on recharge avec un standard(si non la prochaine munition semble avoir l'adresse de l'ancienne )
                	
                        while (Game.ammunitions.get(Game.ammunitions.size()-1).state==1)try { //tant que le dernier explosif n'a pas explosé, on ne bouge plus
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                	}
                	
                           
                            if (running_player==1){
                                running_player=2;
                                Game.active_tank=Game.tank2;
                            }                       //on passe au tour de l'autre joueur
                            else {
                                running_player = 1;
                                Game.active_tank=Game.tank1;
                            }



                    Game.wind=(int)(Math.random()*50)-25;//on change le vent pour le round d'apres
                }


                try {
                    // pause
                    Thread.sleep(1);
                }
                catch (InterruptedException ex) {}
            }
        }
    }

