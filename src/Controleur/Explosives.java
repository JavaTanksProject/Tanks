package Controleur;
import edu.princeton.cs.introcs.StdDraw;

import java.util.ArrayList;

/**
 * Created by Etienne on 11/05/2015.
 */
public class Explosives extends PhysObj{
    public int state;// etat 0 pour explosé, 1 pour pas encore explosé et les autres etats pour l'explosion
    public double radius;//le rayon de l'explosion
    public int damage;//les degats infligés

    public Explosives(double x, double y, double vx, double vy, String picturepath){super( x, y, vx, vy, picturepath);this.state=1;this.radius=0.1; damage=1;}


    public void moveAndDisplayAndExplode(){


        if (state==1){
        this.move();
        this.display();}
        else if(state>1){double scale=state*0.005;
            StdDraw.setPenColor(ColorLibrary.sky);
                if (scale<2.0*radius) {
                    StdDraw.filledCircle(x, y, scale*0.5);
                    StdDraw.picture(x, y, "explosion.png", scale, scale, vx);
                    state++;}//on fait grossir l'explosion set avec un angle vx (donc random)
                else if (scale<10.0*radius){
                    StdDraw.filledCircle(x, y, radius);
                    StdDraw.picture(x, y, "explosion.png", 2.0 * radius, 2.0 * radius, vx);
                    state++;}
                    else state=0; //l'explosion perdure
                }
        if (state==0){
            StdDraw.setPenColor(ColorLibrary.sky);
            StdDraw.filledCircle(x,y,radius);}

    }


    public void display (){
        StdDraw.picture(x, y, picturepath, 0.01, 0.01);}
    public void collisGestion(){
        Ground terrain= Game.terrain;
        Integer ncol = (int) Math.floor(terrain.ground_values.length*x/2);
        ArrayList<Double> actualcolumn =terrain.ground_values[ncol].ground_column;
        int levelmax=actualcolumn.size()-1;
        double hmax=actualcolumn.get(levelmax);
        if (y<hmax){
            double norm=Math.sqrt(vx*vx+vy+vy);
            for (int i=0;i<=levelmax;i++)
            {if(y<actualcolumn.get(i)&& Math.floor(i/2)==i/2)
            {vx=0;vy=0;state=2;}                //on passe à l'etat d'explosion au lieu de rebondir
            else if(y<actualcolumn.get(i)&& Math.floor(i/2)==i/2&&y<actualcolumn.get(i+1))
            {vx=0;vy=0;state=2;}

            }
        }
    }

}
