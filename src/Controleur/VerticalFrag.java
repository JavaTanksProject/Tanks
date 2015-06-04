package Controleur;

import edu.princeton.cs.introcs.StdDraw;

public class VerticalFrag extends Explosives {
	
		public double a_vy;
	    public VerticalFrag(double x, double y, double vx, double vy){
	        super(x,y,vx,vy,"frag.png");}

	    public void singularity(){
	    	if(vy < 0 && a_vy > 0  ){
	    		this.vx = 0;
	    		this.picturepath = "Frag.png"; //mettre nouvelle image de la frag avec parachute
	    		
	    		
	    	}
	    	a_vy=vy;
	  
	    }
	    public void display(){
	    
	    
	    if ( !Double.isNaN(Math.atan(vy/vx))){
            a_angle=Math.atan(vy/vx);
            
        if(vx<0){a_angle=3.1415+a_angle;}
	    }
	    
        if(vy < 0 && a_vy < 0){
            a_angle+= Math.sin(y*20);
        }
            	
            	
	    	StdDraw.picture(x, y, picturepath, 0.03, 0.03,a_angle*57.3);
	    }
	    
	    
	    	

}
