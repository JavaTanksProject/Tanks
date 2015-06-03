package Controleur;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Created by Etienne on 06/05/2015.
 */
public class Cloud extends PhysObj {
    public static int wind=Game.wind;

    public Cloud() {

        int a =(int)Math.floor(Math.random()*3);
        picturepath="nuage"+a+".png";
        this.x=(Math.random()*5-2.5);
        this.y=Math.random()*0.2+0.8;
        vx=0;
        vy=0;
        this.wind=wind;
    }

    public void moveAndDisplay () {
        vx=-(wind*0.00004*(1+4*(y-0.8)));   //deplacement en x plus on est haut plus on bouge vite
        if(x>2.5 || x<-2.5){                         // faire tourner les nuages en boucle
         x=-x;
        }
        x=x+vx;
        if (x>-0.1&&x<2.1){//on affiche que si on est dans l'écran
        StdDraw.picture(x, y, picturepath, 0.2, 0.2);}
    }

}

