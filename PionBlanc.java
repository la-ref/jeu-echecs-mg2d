/*##################################################*/
/*################ Classe PionBlanc ################*/
/*##################################################*/

/*#### Hérite de la classe Piece et Pion ####*/

import java.util.ArrayList;
public class PionBlanc extends Pion{
    /*------------------------ Attributs ------------------------*/

    ArrayList<Position> dep = new ArrayList<Position>();
    
    /*------------------------ Constructeurs ------------------------*/

    /*Constructeur par défaut fessant appel au constructeur de la classe mère réant un pion de couleur blanc*/
    public PionBlanc(){
        super();
    }

    /*Constructeur prenant en paramètre un objet de type position fessant appel au 
    constructeur de la classe mère créant un Pion de couleur blanc*/
    public PionBlanc(Position p){
        super('B', p);
    }

    /*Constructeur prenant en paramètre une chaine de caractere pour sa position fessant appel au 
    constructeur de la classe mère créant un Pion de couleur blanc*/
    public PionBlanc(String p){
        super('B', p);
    }

    /*Constructeur prenant en paramètre deux entiers pour sa position fessant appel au 
    constructeur de la classe mère créant un Pion de couleur blanc*/
    public PionBlanc(int x, int y){
        super('B', x, y);
    }

    /*------------------------ Méthodes ------------------------*/

    /*Méthode  retournant un tableau de position permettant d'avoir toutes les positions pour tous les déplacements possibles du Pion blanc sois verticalement 
    en réduisant l'axe des y, prenant un plateau en paramètre*/
    public ArrayList<Position> getDeplacementPossible(Plateau p){
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        int c = this.getCouleur();
        if (c == 'B'){
            if (y<7 && p.getCase(x,y+1) == null){
                this.dep.add(new Position(x,y+1));
            }

            if (y<7 && x>0 && p.getCase(x-1,y+1) != null){
                if (p.getCase(x-1,y+1).getCouleur() != c){
                    this.dep.add(new Position(x-1,y+1));
                }
            }
            if (y<7 && x<7 && p.getCase(x+1,y+1) != null){
                if (p.getCase(x+1,y+1).getCouleur() != c){
                    this.dep.add(new Position(x+1,y+1));
                }
            }
            if (y == 1 && y<7){
                if (p.getCase(x,y+2) == null){
                    this.dep.add(new Position(x,y+2));
                }
            }
        }

        return this.dep;
    }
}
