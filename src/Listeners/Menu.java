package Listeners;

import Controleur.Game;
import Controleur.Main;
import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

/**
 * Created by Etienne on 07/06/2015.
 */
public class Menu extends Thread{
    public void run() {
        StdDraw.setCanvasSize(1350, 675);
        StdDraw.setXscale(0, Game.lenght);
        StdDraw.setYscale(0, Game.height);
        StdDraw.clear(Color.WHITE);
        StdDraw.picture(1.0, 0.5, "Tank logo.png",1.0,1.0);
        StdDraw.show(2000);

        while (true){
            if (StdDraw.mouseX()>0.06 && StdDraw.mouseX()<0.84 && StdDraw.mouseY()>0.03 && StdDraw.mouseY()<0.85 && StdDraw.mousePressed())
            {
                Main.against_computer=true;
                Main.time_of_menu =false;

            }
            if (StdDraw.mouseX()>1.18 && StdDraw.mouseX()<1.92 && StdDraw.mouseY()>0.18 && StdDraw.mouseY()<0.28 && StdDraw.mousePressed())
            {
                Main.against_computer=false;
                Main.time_of_menu =false;

            }


        StdDraw.picture(1.0, 0.5, "menu.png");

        StdDraw.show(1);


            try {
                // pause
                Thread.sleep(1);
            }
            catch (InterruptedException ex) {}
    }

}

}
