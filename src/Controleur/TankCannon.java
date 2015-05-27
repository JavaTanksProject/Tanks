package Controleur;

/**
 * Created by Etienne on 25/05/2015.
 */
public class TankCannon extends PhysObj{


    public int side;//0 à droite 1 à gauche



    public TankCannon (int player) {
        if (player == 1) {this.side=0;}
        else if (player==2){this.side=0;}//à terme faudra changer le sens d'apparition pour player 2

        this.picturepath="head_tank_"+player+".png";
    }
}
