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
         int [] t_personal_goods=new int [10];
        t_personal_goods[1]=100;
        t_personal_goods[2]=5;
        t_personal_goods[3]=1;
        t_personal_goods[4]=3;
        personal_goods=t_personal_goods;

        this.tank.player=id;

    }

}
