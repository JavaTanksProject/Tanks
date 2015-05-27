package Controleur;

/**
 * Created by Etienne on 25/05/2015.
 */
public class Tank {
    public TankBoady     tankboady;
    public TankHead      tankhead;
    public TankCannon    tankcannon;
    public int           player;
    public int           pv;
    public double        aim_angle;




    public Tank(int player){
        this.player=player;
        this.tankboady=new TankBoady(player);
        this.tankhead=new TankHead(player);
        this.tankcannon=new TankCannon(player);
        this.pv=100;
        aim_angle=0.;

    }
public void  moveAndDisplay (){
    System.out.println(tankboady.angle);
    tankboady.moveAndDisplay();

    tankcannon.move(aim_angle,tankhead);
    tankcannon.display();

    tankhead.move(aim_angle,tankboady);
    tankhead.display();




    }


}
