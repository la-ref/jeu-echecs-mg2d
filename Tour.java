/*#############################################*/
/*################ Classe Tour ################*/
/*#############################################*/

/*#### Hérite de la classe Piece ####*/

import java.util.ArrayList;
class Tour extends Piece{

    /*------------------------ Attributs ------------------------*/

    String type;
    ArrayList<Position> dep = new ArrayList<Position>();

    /*------------------------ Constructeurs ------------------------*/
    
    /*Constructeur par défaut créant un Tour ayant pour position A1 et pour couleur blanc via sa classe mère et avec son type étant Tour */
    public Tour(){
        super('B', "A1");
        this.type = "tour";
    }

    /*Constructeur créant une Tour prenant en paramètre un charactère pour la couleur et un objet de type
    position pour sa position, via sa classe mère et avec son type étant Tour */
    public Tour(char c, Position p){
        super(c, p);
        this.type = "tour";
    }

    /*Constructeur créant une Tour prenant en paramètre un charactère pour la couleur et une chaine
    de caractere pour sa position, via sa classe mère et avec son type étant Tour */
    public Tour(char c, String p){
        super(c, p);
        this.type = "tour";
    }

    /*Constructeur créant une Tour prenant en paramètre un charactère pour la couleur et deux entiers
    pour sa position, via sa classe mère et avec son type étant Tour */
    public Tour(char c, int x, int y){
        super(c, x, y);
        this.type = "tour";
    }

    /*------------------------ Méthodes ------------------------*/

    /*Méthode retournant une chaîne de caractère permettant d'avoir le nom de la piece ici Tour*/
    public String getType(){
        return this.type;
    }

    /*Méthode  retournant un tableau de position permettant d'avoir toutes les positions pour tous les déplacements possibles de la Tour sois horizontalement et verticalement, 
    prenant un plateau en paramètre*/
    public ArrayList<Position> getDeplacementPossible(Plateau p){
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        int c = this.getCouleur();
        int f = 0;
        int i = 0;
        while(x+i < 7 && f != 1){
            i++;
            if(p.getCase(x+i, y) == null){
                this.dep.add(new Position(x+i,y));
            }
            else {
                f = 1;
                if (p.getCase(x+i, y).getCouleur() != c){
                    this.dep.add(new Position(x+i,y));
                }
            }
        }
        f = 0;
        i=0;
        while(x-i > 0 && f != 1){
            i++;
            if(p.getCase(x-i, y) == null){
                this.dep.add(new Position(x-i,y));
            }
            else {
                f = 1;
                if (p.getCase(x-i, y).getCouleur() != c){
                    this.dep.add(new Position(x-i,y));
                }
            }
        }
        f = 0;
        i=0;
        while(y+i<7 && f != 1){
            i++;
            if(p.getCase(x, y+i) == null){
                this.dep.add(new Position(x,y+i));
            }
            else {
                f = 1;
                if (p.getCase(x, y+i).getCouleur() != c){
                    this.dep.add(new Position(x,y+i));
                }
            }
        }
        f = 0;
        i=0;
        while(y-i > 0 && f != 1){
            i++;
            if(p.getCase(x, y-i) == null){
                this.dep.add(new Position(x,y-i));
            }
            else {
                f = 1;
                if (p.getCase(x, y-i).getCouleur() != c){
                    this.dep.add(new Position(x,y-i));
                }
            }
        }
        return this.dep;
    }
    
}
