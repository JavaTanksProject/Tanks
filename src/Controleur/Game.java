package Controleur;

import Listeners.*;
import edu.princeton.cs.introcs.StdDraw;
import Controleur.*;

import java.awt.*;



public class Game {
    public static SetOfClouds nuages;
    public static Ground terrain = new Ground();
    public static int wind=1;
    public static PhysObj banane;
    public static Tank tank;

    public static void main(String[] args) {



//        StdDraw.setCanvasSize(500,250);//pour aller vite
        StdDraw.setCanvasSize(1350,675);//vraie image jolie
        //on crée le terrain
        StdDraw.setPenColor(ColorLibrary.sky);
        StdDraw.clear(StdDraw.getPenColor());//font bleu ciel
        StdDraw.setXscale(0, 2.0);
        StdDraw.setYscale(0, 1.0);
        terrain.display();
         StdDraw.save("currentground.png");



        banane= new PhysObj(1.0,1.0,0.0,0.0,"banane.png");
        nuages  =new SetOfClouds(10,5);//}
        Explosives bbxpl= new Explosives(1.0,1.0,0.0,0.0,"bbexplosion.png");
        tank=new Tank(1);




        PlayerTankPhaseThread thread = new PlayerTankPhaseThread();
        thread.start();

        while (true){
            StdDraw.picture(1.0, 0.5, "currentground.png");
            nuages.moveAndDisplay();
            bbxpl.moveAndDisplayAndExplode();
            banane.moveAndDisplay();
            tank.moveAndDisplay();

            StdDraw.show(1);
        }


        }





    }
