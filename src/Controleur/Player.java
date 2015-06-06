package Controleur;

import java.util.ArrayList;

/**
 * Created by Etienne on 04/06/2015.
 */

public class Player {

    public Tank tank;
    public int money;
    public int [] personal_goods;//chaque truc acheté
    //1-standard
    //2-barrage
    //3-verticale

    public Player(int id){
        this.tank=new Tank(1+((id+1)%2));
        this.money=0;
        this.personal_goods=new int [10];
        this.personal_goods[1]=100;
        this.personal_goods[2]=5;
        this.personal_goods[3]=1;
        this.tank.player=id;

    }

}
