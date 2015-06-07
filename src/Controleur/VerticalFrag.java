package Controleur;

import edu.princeton.cs.introcs.StdDraw;

public class VerticalFrag extends Explosives {
	
		public double a_vy;
	    public VerticalFrag(double x, double y, double vx, double vy){
	        super(x,y,vx,vy,"vertical.png");
        this.id=3;
        this.radius=0.1;
        this.damage=50;}

	    public void singularity(){
	    	if(vy < 0 && a_vy > 0  ){
	    		this.vx = 0;
	    		this.picturepath = "vertical.png"; //mettre nouvelle image de la frag avec parachute


	    		
	    	}
            if (vy<0){StdDraw.picture(x, y+0.05,"parachute.png", 0.08, 0.08);}
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
