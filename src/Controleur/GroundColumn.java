package Controleur;

import java.awt.*;
import java.util.ArrayList;
/**
 * Created by Etienne on 17/03/2015.
 */
public class GroundColumn {
    public ArrayList ground_column;

    public GroundColumn(double height){
        ArrayList lesvaleurs= new ArrayList();
        lesvaleurs.add(height);
        /*lesvaleurs.add(ColorLibrary.dust);//couleur de la terre
        lesvaleurs.add(0.01);
        lesvaleurs.add(ColorLibrary.darkdust);
        lesvaleurs.add(0.04);
        lesvaleurs.add(ColorLibrary.grass);*/
        this.ground_column=lesvaleurs;
    }




   /* public static ArrayList<Double> levels(GroundColumn colonne){ //donne une liste avec le niemme niveau ou ya de la matiere,
    // liste de taille: le nombre de passage de la ligne terre/ciel sur la colonne

        ArrayList<Double>  height = new ArrayList<Double>();
                height.add(0,0.0);
                int niveau=0;
        for (int i=0;i< colonne.ground_column.size();i=i+2){
            double b=0;
            b=b+(Double)colonne.ground_column.get(i);//la hauteur temporaire du niveau
            if (colonne.ground_column.get(i+1)==ColorLibrary.sky)//si intersection avec le ciel
            {height.set(niveau,b);//on a un niveau
                height.set(niveau+1,b+(Double)colonne.ground_column.get(i+2));//et le niveau du dessus
                niveau+=2;}
            height.set(niveau,b);

        }
        return height;
    }*/

}
