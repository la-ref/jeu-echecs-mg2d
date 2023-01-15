/*#################################################*/
/*################ Classe PionNoir ################*/
/*#################################################*/

/*#### Hérite de la classe Piece et Pion ####*/

import java.util.ArrayList;
public class PionNoir extends Pion{
    /*------------------------ Attributs ------------------------*/

    ArrayList<Position> dep = new ArrayList<Position>();

    /*------------------------ Constructeurs ------------------------*/
    
    /*Constructeur par défaut fessant appel au constructeur de la classe mère créant un pion de couleur noir 
    en position A1*/
    public PionNoir(){
        super('N', "A1");
    }

    /*Constructeur prenant en paramètre un objet de type position fessant appel au 
    constructeur de la classe mère créant un Pion de couleur noir*/
    public PionNoir(Position p){
        super('N', p);
    }

    /*Constructeur prenant en paramètre une chaine de caractere pour sa position fessant appel au 
    constructeur de la classe mère créant un Pion de couleur noir*/
    public PionNoir(String p){
        super('N', p);
    }

    /*Constructeur prenant en paramètre deux entiers pour sa position fessant appel au 
    constructeur de la classe mère créant un Pion de couleur noir*/
    public PionNoir(int x, int y){
        super('N', x, y);
    }

    /*------------------------ Méthodes ------------------------*/

    /*Méthode  retournant un tableau de position permettant d'avoir toutes les positions pour tous les déplacements possibles du Pion noir sois verticalement 
    en augmentant l'axe des y, prenant un plateau en paramètre*/
    public ArrayList<Position> getDeplacementPossible(Plateau p){
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        int c = this.getCouleur();
        if (c == 'N'){
            if (y>0 && p.getCase(x,y-1) == null){
                this.dep.add(new Position(x,y-1));
            }

            if (y>0 && x<7 && p.getCase(x+1,y-1) != null){
                if (p.getCase(x+1,y-1).getCouleur() != c){
                    this.dep.add(new Position(x+1,y-1));
                }
            }
            if (y>0 && x>0 && p.getCase(x-1,y-1) != null){
                if (p.getCase(x-1,y-1).getCouleur() != c){
                    this.dep.add(new Position(x-1,y-1));
                }
            }
            if (y == 6 && y>0){
                if (p.getCase(x,y-2) == null){
                    this.dep.add(new Position(x,y-2));
                }
            }
        }

        return this.dep;
    }
}
