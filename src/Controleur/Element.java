package Controleur;

import java.awt.*;

import java.awt.Color;
import java.awt.Point;


    public class Element {

        //Attributs

        public static final Color DEFAULT_ELEMENT_COLOR = Color.red; //on initialise la couleur à rouge
        private Point position; // chaque elment devra avoir une position par rapport aux autres
        private int size;
        private Color colour;

        //Constructeurs

        public Element(Point position){
            this.position = position; //La position attribut de la classe sera égale au paramètre du constructeur public Element(Point position)
            this.colour = DEFAULT_ELEMENT_COLOR;

        }

        public Element(int x, int y){
            this(new Point(x,y));//Ici on construit directement un nouveau point aux coordonnées x et y grâce au constructeur de la classe java.awt.Point importées au début qui prend en paramètre directement x et y
            //nous construisons donc un Element aux coords x et y, en passant par un point;
            this.colour = DEFAULT_ELEMENT_COLOR;
        }

        public Element(Point position, Color colour){
            this.position = position;
            this.colour = colour;
        }
        public Element(int x, int y, Color colour){
            this(new Point(x,y));
            this.colour = colour;
        }

        //Accesseurs
        // Accesseurs en écriture (set)
        public void setPosition (Point position) {
            this.position = position;
        }

        public void setCoordinate(int x, int y){
            this.position.x = x;
            this.position.y = y;
        }

        public void setX(int x){
            this.position.x =x;
        }

        public void setY(int y){
            this.position.y = y;
        }

        public void setColour (Color colour){
            this.colour = colour;
        }
        // Accesseurs en lecture (get)

        public Point getPosition() {
            return position;
        }

        public Color getColour() {
            return colour;
        }

        public int getX(){
            return (int) position.getX();
        }

        public int getY(){
            return (int) position.getY();
        }


        //Méthodes
        //Méthodes String cette méthode sert à envoyer des données au println de mes classes test.

        public String toString(){
            return "("+this.position.x+ ","+this.position.y+")";
        }

    }
