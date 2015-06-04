package Controleur;

import Listeners.*;
import edu.princeton.cs.introcs.StdDraw;

import java.util.ArrayList;


public class Game {
//    dimensions du terrain
    public static double lenght=2.0;
    public static double height=1.0;

    public static SetOfClouds nuages;
    public static Ground terrain = new Ground();
<<<<<<< HEAD
    public static int wind=10;
=======
    public static int wind=5;
>>>>>>> d23458494032ff1f57c99586ff39f94d16f0c4c1

//    public static PhysObj banane;
    public static Tank active_tank;
    public static ArrayList<Explosives> ammunitions=new ArrayList<Explosives>();
    public static Tank tank1=new Tank(1);
    public static Tank tank2=new Tank (2);


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
        StdDraw.setXscale(0, lenght);
        StdDraw.setYscale(0, height);
        terrain.display();
         StdDraw.save("currentground.png");
//        ammunitions.add(new Explosives(1.0,1.0,0.0,0.0,"ammunstandard.png"));
//        banane= new PhysObj(1.0,1.0,0.0,0.0,"banane.png");
        nuages  =new SetOfClouds(10,5);
        active_tank =tank1;




        PlayerTankPhaseThread thread = new PlayerTankPhaseThread();
        thread.start();

        while (true){
            StdDraw.picture(1.0, 0.5, "currentground.png");

            nuages.moveAndDisplay();
            Game.deal_with_ammunitions();
//            banane.moveAndDisplay();
            tank1.moveAndDisplay();
            tank2.moveAndDisplay();

            StdDraw.show(1);
        }

        }

    }
