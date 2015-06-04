package Controleur;

import edu.princeton.cs.introcs.StdDraw;

/**
 * Created by Etienne on 03/06/2015.
 */
public class Frag extends Explosives {
	public double a_vy;
    public Frag(double x, double y, double vx, double vy){
        super(x,y,vx,vy,"frag.png");}
    
    public void singularity(){
    	if(vy < 0 && a_vy > 0  ){
    		Frag frag1 = new Frag(this.x, this.y, this.vx + vx*0.2, this.vy);
    		Frag frag2 = new Frag(this.x, this.y, this.vx - vx*0.2, this.vy);
    		frag1.picturepath = "ammunstandard.png";
    		frag2.picturepath = "ammunstandard.png";
    		
    		
    		
    		Game.ammunitions.add(frag1);
    		Game.ammunitions.add(frag2);
    		this.picturepath = "ammunstandard.png";
    		
    	}
    	a_vy=vy;
    }
    public void display(){
    	
	    if ( !Double.isNaN(Math.atan(vy/vx))){
            a_angle=Math.atan(vy/vx);
            
        if(vx<0){a_angle=3.1415+a_angle;}
	    }
	    
        if(vy < 0 && a_vy < 0){
          StdDraw.picture(x, y, picturepath, 0.015, 0.015,a_angle*57.3);
	    }
        else
        	StdDraw.picture(x, y, picturepath, 0.03, 0.03,a_angle*57.3);
        }
            	
            	
	    	
	    
    
}
