/*########################################################*/
/*################ Classe abstraite Piece ################*/
/*########################################################*/

/*#### Hérite de la classe Piece ####*/

import java.util.ArrayList;
abstract public class Pion extends Piece{
    /*------------------------ Attributs ------------------------*/

    String type;
    ArrayList<Position> dep = new ArrayList<Position>();

    /*------------------------ Constructeurs ------------------------*/
    
    /*Constructeur par défaut créant un Pion ayant pour position A1 et pour couleur blanc via sa classe mère et avec son type étant Pion */
    public Pion(){
        super('B', "A1");
        this.type = "pion";
    }

    /*Constructeur créant un Pion prenant en paramètre un charactère pour la couleur et un objet de type
    position pour sa position, via sa classe mère et avec son type étant Pion */
    public Pion(char c, Position p){
        super(c, p);
        this.type = "pion";
    }

    /*Constructeur créant un Pion prenant en paramètre un charactère pour la couleur et une chaine
    de caractere pour sa position, via sa classe mère et avec son type étant Pion */
    public Pion(char c, String p){
        super(c, p);
        this.type = "pion";
    }

    /*Constructeur créant un Pion prenant en paramètre un charactère pour la couleur et deux entiers
    pour sa position, via sa classe mère et avec son type étant Pion */
    public Pion(char c, int x, int y){
        super(c, x, y);
        this.type = "pion";
    }

    /*------------------------ Méthodes ------------------------*/

    /*Méthode retournant une chaîne de caractère permettant d'avoir le nom de la piece ici Pion*/
    public String getType(){
        return this.type;
    }

    /*Méthode abstraite retournant un tableau de position permettant d'avoir toutes les positions pour tous les déplacements possibles d'un pion, prenant un plateau en paramètre*/
    abstract public ArrayList<Position> getDeplacementPossible(Plateau p);
}
