package Controleur;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Etienne on 17/03/2015.
 */
public class Ground {
    public static int number =1000;
    public GroundColumn[] ground_values = new GroundColumn[number];

    public Ground() {

        /**
         * if (posX<0.1){vX=vX+(0.1-posX)*0.0001;}
         if (posY<0.1){vY=vY+(0.1-posY)*0.0001;}
         if (posX>0.9){vX=vX+(0.9-posX)*0.0001;}
         if (posY>0.9){vY=vY+(0.9-posY)*0.0001;}
         if (vX*vX+vY*vY>0.1){aX=aX/10;aY=aY/10;}
         aX= aX*0.99+(Math.random()-0.5)*0.00001;
         aY= aY*0.99+(Math.random()-0.5)*0.00001;
         vX= vX*0.9+aX;
         vY= vY*0.9+aY;
         */
        double y = 0.4;
        double v = 0.0;
        double a = 0.0;

        for (int i = 0; i < ground_values.length; i++) {

            ground_values[i] = new GroundColumn(y);
            if (y < 0.2) {
                v = v * 0.9 + (0.2 - y) * 0.001;
            }
            if (y > 0.8) {
                v = v * 0.9 + (0.8 - y) * 0.0005;
            }
            if (y > 0.5) {
                v = v * 0.9 + (0.5 - y) * 0.0002;
            }
            a = a * 0.99 + (Math.random() - 0.5) * 0.00004;
            if (i>0.80*(number)){
                if (y>0.4){
//                    a=a*0.99999;
//                    v=v-0.00001*1/Math.log10(i/number);}
                    v=v-0.0001*i*i*i/number/number/number;}
                if (y<0.4){
//                    a=a*0.99999;
                    v=v+0.0001*i*i*i/number/number/number;}
//                    v=v+0.00001*i/number;}
            }
            v = v * 0.9 + a;
            y = y + v;
            //System.out.println(y);


        }

    }
    public Ground(double ground_level) {



        for (int i = 0; i < ground_values.length; i++) {

            ground_values[i] = new GroundColumn(ground_level);

            }
        }

    public void display() {
        int nval = ground_values.length;
        double[] posX = new double[nval + 2];
        double[] posY = new double[nval + 2];
        for (int i = 0; i < nval; i++) {
            double h = (Double) ground_values[i].ground_column.get(0);
            posX[i] = ((double) i + 1.0) * 2 / nval;
            posY[i] = h;
        }

        posX[nval] = 2.0;
        posY[nval] = 0.;
        posX[nval + 1] = 0.;
        posY[nval + 1] = 0.;

        StdDraw.setPenColor(ColorLibrary.grass);
        StdDraw.filledPolygon(posX, posY);
        StdDraw.setPenColor(ColorLibrary.darkdust);
        StdDraw.filledPolygon(posX, arrayMap(posY, 0.04));
        StdDraw.setPenColor(ColorLibrary.dust);
        StdDraw.filledPolygon(posX, arrayMap(posY, 0.01));



    }
    private double[] arrayMap (double[] array, double value) {
        for (int i = 0; i < array.length; i++)
            array[i] -= value;
        return array;
    }
    /*public void display() {
        int nval = ground_values.length;
        for (int i = 0; i < nval; i++) {
            double cumuly = 0.0;
            for (int j = 0; j < ground_values[i].ground_column.size(); j += 2) {
                StdDraw.setPenColor((Color) ground_values[i].ground_column.get(j + 1));
                double h = (Double) ground_values[i].ground_column.get(j);
                //System.out.println(i / nval + " / " + 0 + " / " + 1.0 / (2 * nval) + " / " + 0.5 * cumuly + h);

                StdDraw.filledRectangle((i + 1.0) * 2 / nval, cumuly + 0.5 * h, 2.0 / (1.0 * nval), 0.5 * h);
                //  StdDraw.filledRectangle();

                cumuly = cumuly + h;
            }
        }
    }*/

    public void explode (double x,double y, double radius) {
    Ground terrain= Game.terrain;
    Integer ncol = (int) Math.floor(terrain.ground_values.length*x/2);
	ArrayList<Double> actualcolumn =terrain.ground_values[ncol].ground_column;
   
    Integer half_ncolimp = (int) Math.floor(Ground.number*radius/Game.lenght);   // g.n*radius*2/2 parce que radius = diametre et 2 longueur du terrain
    				
  
    	for(int i = (int) Math.max(ncol - half_ncolimp, 0); i < (int) Math.min(ncol + half_ncolimp, Ground.number); i++){
    		
    		double cos_alpha = (Math.abs(ncol - i)*Game.lenght/(Ground.number*1.0))/radius;
    		
    		double alpha = Math.acos(cos_alpha);
    		
    		double hnew = Math.max((Double)Game.terrain.ground_values[i].ground_column.get(0),y - Math.sin(alpha)*radius);
    		Game.terrain.ground_values[i].ground_column.set(0, hnew);
    		
    	}
    	
    	
    	
  
    		// set les y des x < radius . les y deviennent ynew = (y - tan (Pi/)*(x-ncol)
    		
   
    
    	
    	


            }


}