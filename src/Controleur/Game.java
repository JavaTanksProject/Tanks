package Controleur;

import Listeners.*;
import edu.princeton.cs.introcs.StdDraw;
import Controleur.*;

import java.awt.*;
import java.util.ArrayList;


public class Game {
    public static SetOfClouds nuages;
    public static Ground terrain = new Ground();
    public static int wind=1;
//    public static PhysObj banane;
    public static Tank tank;
    public static ArrayList<Explosives> ammunitions=new ArrayList<Explosives>();

    public static void deal_with_ammunitions(){
        for(int i=0;i<ammunitions.size();i++){
            ammunitions.get(i).moveAndDisplayAndExplode();
        }
    }
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
//        ammunitions.add(new Explosives(1.0,1.0,0.0,0.0,"ammunstandard.png"));
//        banane= new PhysObj(1.0,1.0,0.0,0.0,"banane.png");
        nuages  =new SetOfClouds(10,5);
        tank=new Tank(1);




        PlayerTankPhaseThread thread = new PlayerTankPhaseThread();
        thread.start();

        while (true){
            StdDraw.picture(1.0, 0.5, "currentground.png");
            nuages.moveAndDisplay();
            Game.deal_with_ammunitions();
//            banane.moveAndDisplay();
            tank.moveAndDisplay();

            StdDraw.show(1);
        }




        }





    }
