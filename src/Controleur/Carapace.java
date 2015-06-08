package Controleur;

/**
 * Created by Etienne on 08/06/2015.
 */
public class Carapace extends Explosives {

    public double id_to_focus;
    public double a_vy;
    public boolean activate;

    public Carapace(double x, double y, double vx, double vy){
        super(x,y,vx,vy,"carapace.png");
        this.id=4;
        this.radius=0.1;
        this.damage=30;
        this.id_to_focus=(Game.active_tank.player%2)+1;
        this.activate=false;
    }
    public void singularity(){
        if(vy < 0 && a_vy > 0  ) {
            activate=true;
        }
        if (activate){
            double go_to_x = 0.0;
            double go_to_y = 0.0;
            if (id_to_focus == 1) {
                go_to_x = Game.tank1.tankboady.x - this.x;
                go_to_y = Game.tank1.tankboady.y - this.y;
            }
            if (id_to_focus == 2) {
                go_to_x = Game.tank2.tankboady.x - this.x;
                go_to_y = Game.tank2.tankboady.y - this.y;
            }
            System.out.println(id_to_focus);
            this.vx += go_to_x * 0.0005;
            this.vy += go_to_y * 0.0005;
        }
        this.a_vy=this.vy;
    }
}
