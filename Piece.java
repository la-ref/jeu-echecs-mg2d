/*########################################################*/
/*################ Classe abstraite Piece ################*/
/*########################################################*/

import java.util.ArrayList;
abstract class Piece {
    /*------------------------ Attributs ------------------------*/

    private char couleur;
    private Position position;

    /*------------------------ Constructeurs ------------------------*/

    /*Constructeur par défaut créant une piece ayant pour position A2 et une couleur blanche*/
    public Piece(){
        this.couleur = 'B';
        this.position = new Position("A2");
    }

    /*Constructeur par copie prenant en paramètre un objet de type Piece*/
    public Piece(Piece p){
        this.couleur = p.couleur;
        this.position = new Position(p.position);
    }

    /*Constructeur prenant en paramètre un charactère pour la couleur, un entier x et un entier y pour la position de la piece*/
    public Piece(char c, int x, int y){
        if (verifCouleur(c)){
            this.couleur = c;
        }
        else{
            System.out.println("Couleur impossible ou non en majuscule, blanc mis");
            this.couleur = 'B';
        }
        this.position = new Position(x, y);
    }

    /*Constructeur prenant en paramètre un charactère pour la couleur, un objet de type position pour la position de la piece*/
    public Piece(char c, Position p){

        if (verifCouleur(c)){
            this.couleur = c;
        }
        else{
            System.out.println("Couleur impossible, blanc mis");
            this.couleur = 'B';
        }
        this.position = new Position(p);
    }

    /*Constructeur prenant en paramètre un charactère pour la couleur, une chaîne de caractère pour la position de la piece*/
    public Piece(char c, String p){
        if (verifCouleur(c)){
            this.couleur = c;
        }
        else{
            System.out.println("Couleur impossible, blanc mis");
            this.couleur = 'B';
        }
        this.position = new Position(p);
    }

    /*------------------------ Méthodes ------------------------*/

    /*Méthode privé pour verifier si une couleur est blanche ou noir via un charactère en paramètre*/
    private boolean verifCouleur(char c){
        if (c == 'B' || c == 'N'){
            return true;
        }
        else {
            return false;
        }
    }

    /*Méthode Setter pour permettre de modifier l'attribut couleur avec un caractère en paramètre*/
    public void setCouleur(char c){
        if (verifCouleur(c)){
            this.couleur = c;
        }
        else {
            System.out.println("Couleur impossible");
        }
    }

    /*Méthode Setter pour permettre de modifier l'attribut position avec une chaîne de caractère en paramètre représentant une position*/
    public void setPosition(String p){
        this.position = new Position(p);
    }

    /*Méthode Setter pour permettre de modifier l'attribut position avec deux entiers x, y en paramètre représentant une position*/
    public void setPosition(int x, int y){
        this.position = new Position(x, y);
    }

    /*Méthode Setter pour permettre de modifier l'attribut position avec un objet Position en paramètre représentant une position*/
    public void setPosition(Position p){
        this.position = new Position(p);
    }

    /*Méthode abstraite retournant une chaîne de caractère permettant d'avoir le nom de la piece*/
    abstract public String getType();

    /*Méthode Getter retournant la valeur de l'attribut couleur, sois la couleur*/
    public char getCouleur(){
        return this.couleur;
    }

    /*Méthode Getter retournant la valeur de l'attribut position, sois la position*/
    public Position getPosition(){
        return this.position;
    }
    /*Méthode Getter retournant une chaîne de caractère représentant le nom de la piece avec sa couleur sous forme réduite comme ceci : 
    PiN, Pour Pion Noir
    RoB, Pour Roi Blanc
    ...*/
    public String getNomCourt(){
        return new String((this.getType().substring(0,1)).toUpperCase() + this.getType().substring(1,2) + this.couleur);
    }

    /*Méthode Getter retournant une chaîne de caractère représentant le nom de la piece avec sa couleur sous forme longue comme ceci : 
    pion_N, Pour Pion Noir
    roi_B, Pour Roi Blanc
    ...*/
    public String getNomLong(){
        return new String(this.getType()+"_"+this.couleur);
    }

    /*Méthode abstraite retournant un tableau de position permettant d'avoir toutes les positions pour tous les déplacements possibles d'une piece, prenant un plateau en paramètre*/
    abstract public ArrayList<Position> getDeplacementPossible(Plateau p);

    /*Méthode equals retournant un boolean verifiant l'egalite entre deux objets et verfie si c'est une piece avec un objet en parametre */
    public boolean equals(Object p){
        if(p instanceof Piece){
            Piece pi = (Piece) p;
            if(pi != null && this.couleur == pi.couleur && this.position.equals(pi.position)){
                return true;
            }
        }
        return false;
    }

    /*Méthode toString retournant une chaîne de caractère donnant le type de piece, sa couleur et sa postion sous forme:
    tour noir en A8
    cavalier noir en B8
    ...*/
    public String toString(){
        String c;
        if (this.couleur == 'B'){
            c = "blanc";
        }
        else{
            c = "noir";
        }
        return new String(this.getType() + " " + c + " en " + this.position.toString());
    }

}