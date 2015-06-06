package Controleur;


/**
 * Created by Etienne on 07/05/2015.
 */


public class SetOfClouds {
    public int size;
    public Cloud[]  set= new Cloud [size];

    public SetOfClouds(int size,int wind){
        this.size=size;
        set= new Cloud [size];
        for (int i=0;i<size;i++){
            set[i]=new Cloud();
        }

    }
    public void moveAndDisplay(){
        for (int i=0;i<size;i++){

             set[i].moveAndDisplay();

        }
    }
}
