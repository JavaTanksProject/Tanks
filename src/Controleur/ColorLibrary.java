package Controleur;

import java.awt.*;

/**
 * Created by Etienne on 01/05/2015.
 */
public class ColorLibrary {
    public static Color dust = new Color (177, 166, 134);
    public static Color darkdust = new Color (143, 134, 108);
    public static Color grass= new Color (142, 203, 67);
    public static Color sky= new Color (36, 170, 230);
    public static Color grey=new Color(105,105,105);
    public static Color test=new Color(250,250,00);

    public static Color green_to_red (int pv){
        int red=(int)Math.floor(150-((pv/10)*(pv/10)*1.5)//on gere le rouge
                +(10*2.5*2.5066*Math.exp(pv*pv*0.00001/2)));//on ajoute de quoi faire du jaune grace a une gausienne allant jusqu'à 0.4 multipliee par 2. puis par 100
        int green=(int)Math.floor(((pv/10)*(pv/10)*1.5)
                +(10*2.5*2.5066*Math.exp(pv*pv*0.00001/2)));
        Color couleur=new Color(red,green,00);
        return couleur;
    }

}
