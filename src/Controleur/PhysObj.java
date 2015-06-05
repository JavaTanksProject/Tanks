package Controleur;

import edu.princeton.cs.introcs.StdDraw;

import java.util.ArrayList;

/**
 * Created by Etienne on 06/05/2015.
 */
public /* abstract*/ class PhysObj {//abstract rend impossible l'instanciation d'insecte
    public double x;
    public double y;
    public double vx;
    public double vy;
    public double angle;
//    physic propoerties
    public  static double gravity=0.00002;
    public static double rebounce_coeff=0.8;
    private static double air_friction_coeff =0.000005;
    public String picturepath;


    public PhysObj(double x, double y, double vx, double vy, String picturepath) {
        this.x=x;
        this.y=y;
        this.vx=vx;
        this.vy=vy;
        this.angle=0.0;

        this.picturepath=picturepath;
    }

    public PhysObj() {
    }

    public void moveAndDisplay(){
        this.move();
        this.display();
    }
    public void move () {



        this.wind();   //deplacement en x
//        vy=vy+(-vy*vy)*air_friction_coeff-getGravity();           //deplacement en y
        vy=vy-getGravity();           //deplacement en y sans vent

        if(x<0.01){x+=2;}
        if(x>1.98){x-=2;}
        if(x>0.005 && x<1.98){this.collisGestion();}

        x=x+vx;
        y=y+vy;
    }



    public void wind(){
        int wind= Game.wind;
        this.vx=vx+(-(vx-0.1*wind)*(vx-0.1*wind))*air_friction_coeff;
    }







    public void display (){
//        if(x<0.01){StdDraw.picture(x+2,y+0.05,picturepath,0.1,0.1,angle*57.29);}
//        if(x>1.98){StdDraw.picture(x-2,y+0.05,picturepath,0.1,0.1,angle*57.29);}
        StdDraw.picture(x,y+0.05,picturepath,0.1,0.1,angle*57.29);//on convertie en degré nos radians
    }

    public void collisGestion(){
        double rebounce_coeff=getRebounce_coeff();
        Ground terrain= Game.terrain;
        Integer ncol = (int) Math.floor(terrain.ground_values.length*x/Game.lenght);
        if (ncol<5){ncol=5;}                    //entourloupe pour pas avoir de prob au sol
        ArrayList<Double> actualcolumn =terrain.ground_values[ncol].ground_column;
        int levelmax=actualcolumn.size()-1;
        double hmax=actualcolumn.get(levelmax);
        if (y<hmax){
            double norm=Math.sqrt(vx*vx+vy+vy);
            for (int i=0;i<=levelmax;i++)
            {if(y<actualcolumn.get(i)&& Math.floor(i/2)==i/2)// si on est congru modulo 2 = paire
            {
                double alpha = groundAngle(terrain,2,ncol,i );
                double norme=Math.sqrt(vx*vx+vy*vy);
                double nx=Math.cos(alpha+(3.14/2))*norme; //les coordonées de la normale au point d'impact (multipliée par la norme de la vitessse du Stuff)
                double ny=Math.sin(alpha+(3.14/2))*norme;


                vx=rebounce_coeff*(vx+nx);
                vy=rebounce_coeff*(vy+ny);
                this.angle=groundAngle(terrain,10,ncol,i );//on prend un angle d'image basé sur plus large car l'objet repose sur large de terrain
            }
            else if(y<actualcolumn.get(i)&& Math.floor(i/2)==i/2&&y<actualcolumn.get(i+1))
            {
                double alpha = groundAngle(terrain,2,ncol,i );
                double norme=Math.sqrt(vx * vx + vy * vy);
                double nx=Math.cos(alpha+(3.14/2))*norme; //les coordonées de la normale au point d'impact (multipliée par la norme de la vitessse du Stuff)
                double ny=Math.sin(alpha+(3.14/2))*norme;


                vx=rebounce_coeff*(vx-nx);
                vy=rebounce_coeff*(vy-ny);
                this.angle=groundAngle(terrain,10,ncol,i );
            }

            }
        }
    }


    public double getDeniv(Ground terrain, int column_space, int ncol,int level_in_column){

        double deniv=(Double)terrain.ground_values[(ncol+column_space)%terrain.number].ground_column.get(level_in_column)-(Double)terrain.ground_values[(ncol-column_space)%terrain.number].ground_column.get(level_in_column);
        return deniv;
    }


    public double groundAngle(Ground terrain, int column_space, int ncol,int level_in_column){
        double deniv=getDeniv( terrain,  column_space,  ncol, level_in_column);
        return Math.atan(deniv * terrain.ground_values.length/(Game.lenght*column_space*1.0));
    }

    public double getRebounce_coeff(){
        return rebounce_coeff;
    }

    public double getGravity(){
        return gravity;
    }
}
