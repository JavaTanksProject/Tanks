package Controleur;

import Listeners.PlayerTankPhaseThread;
import edu.princeton.cs.introcs.StdDraw;

import java.util.ArrayList;

/**
 * Created by Etienne on 07/06/2015.
 */
public class GameThread extends Thread{
    public void run() {


        while (true){
//            Ground nouveau_terrain=new Ground();
            Game.terrain = new Ground();
            Game.wind=(int)(Math.random()*50)-25;

            ArrayList<Explosives> ammunitions=new ArrayList<Explosives>();






//
            //on crée le terrain
            StdDraw.setPenColor(ColorLibrary.sky);
            StdDraw.clear(StdDraw.getPenColor());//font bleu ciel
            Game.terrain.display();
            StdDraw.show(100);
            StdDraw.save("currentground" + Main.level_of_computer+".png");
            StdDraw.show(100);
//        ammunitions.add(new Explosives(1.0,1.0,0.0,0.0,"ammunstandard.png"));
//        banane= new PhysObj(1.0,1.0,0.0,0.0,"banane.png");
            Game.nuages  =new SetOfClouds(10,5);
            Game.active_tank =Game.tank1;





            while (!Main.gameover){
                StdDraw.picture(1.0, 0.5, "currentground"+ Main.level_of_computer+".png");

                Game.nuages.moveAndDisplay();
                Game.deal_with_ammunitions();
                Game.tank1.moveAndDisplay();
//                System.out.println("on affiche tank 1");

                Game.tank2.moveAndDisplay();
//                System.out.println("on affiche tank 2");
                Game.show_the_wind();
                StdDraw.show(1);

            }
            //si game ocer, on sort de la boucle

            Main.gameover=false;

            Game.tank1.pv=100;
            Game.tank2.pv=100;
            Game.tank1.tankboady.y=Game.height;
            Game.tank2.tankboady.y=Game.height;
            Game.tank1.tankboady.x=Game.lenght*0.1;
            Game.tank2.tankboady.x=Game.lenght*0.9;

            Main.player2.tank=Game.tank2;
            Main.player1.tank=Game.tank1;
            Game.ammunitions.clear();

        }}

}
