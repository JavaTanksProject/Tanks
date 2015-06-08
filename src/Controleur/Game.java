package Controleur;

import Listeners.*;
import Listeners.Menu;
import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.util.ArrayList;


public class Game {
    //    dimensions du terrain
    public static double lenght=2.0;
    public static double height=1.0;

    public static SetOfClouds nuages;
    public static Ground terrain = new Ground();
    public static int wind=(int)(Math.random()*50)-25;
    //    public static PhysObj banane;
    public static Tank active_tank;
    public static ArrayList<Explosives> ammunitions=new ArrayList<Explosives>();
    public static Tank tank1=Main.player1.tank;
    public static Tank tank2=Main.player2.tank;

    public static void show_the_wind(){
        StdDraw.setPenColor(Color.white);
        StdDraw.text(lenght*0.5,height*0.95,"vent: "+wind);
    }
    public static void deal_with_ammunitions(){
        for(int i=0;i<ammunitions.size();i++){
            ammunitions.get(i).moveAndDisplayAndExplode();
        }
    }


    public static void main(String[] args) {

        System.out.println(Main.player1.personal_goods[1]);



//        StdDraw.setCanvasSize(500,250);//pour aller vite
        StdDraw.setCanvasSize(1350,675);//vraie image jolie
        //on crée le terrain
        StdDraw.setPenColor(ColorLibrary.sky);
        StdDraw.clear(StdDraw.getPenColor());//font bleu ciel
        StdDraw.setXscale(0, lenght);
        StdDraw.setYscale(0, height);

//        ammunitions.add(new Explosives(1.0,1.0,0.0,0.0,"ammunstandard.png"));
//        banane= new PhysObj(1.0,1.0,0.0,0.0,"banane.png");
        nuages  =new SetOfClouds(10,5);
        active_tank =tank1;




        PlayerTankPhaseThread thread = new PlayerTankPhaseThread();
        thread.start();
        Menu menu=new Menu();
        menu.start();
        while (Main.time_of_menu){
            StdDraw.show(100);
        }
        menu.interrupt();
        menu.stop();

        GameThread game_thread= new GameThread();
        game_thread.start();

//        while (true){
//            StdDraw.picture(1.0, 0.5, "currentground.png");
//
//            nuages.moveAndDisplay();
//            Game.deal_with_ammunitions();
//            tank1.moveAndDisplay();
//            tank2.moveAndDisplay();
//            show_the_wind();
//            StdDraw.show(1);
//        }
//
    }

}