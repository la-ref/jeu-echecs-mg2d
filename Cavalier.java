/*################################################*/
/*################ Classe Cavalier ###############*/
/*################################################*/

/*#### Hérite de la classe Piece ####*/

import java.util.ArrayList;
public class Cavalier extends Piece{

    /*------------------------ Attributs ------------------------*/

    String type;
    ArrayList<Position> dep = new ArrayList<Position>();
    
    /*------------------------ Constructeurs ------------------------*/

    /*Constructeur par défaut créant un Cavalier ayant pour position A1 et pour couleur blanc via sa classe mère et avec son type étant cavalier */
    public Cavalier(){
        super('B', "A1");
        this.type = "cavalier";
    }

    /*Constructeur créant un Cavalier prenant en paramètre un charactère pour la couleur et un objet de type
    position pour sa position, via sa classe mère et avec son type étant cavalier */
    public Cavalier(char c, Position p){
        super(c, p);
        this.type = "cavalier";
    }

    /*Constructeur créant un Cavalier prenant en paramètre un charactère pour la couleur et une chaine
    de caractere pour sa position, via sa classe mère et avec son type étant cavalier */
    public Cavalier(char c, String p){
        super(c, p);
        this.type = "cavalier";
    }
    
    /*Constructeur créant un Cavalier prenant en paramètre un charactère pour la couleur et deux entiers
    pour sa position, via sa classe mère et avec son type étant cavalier */
    public Cavalier(char c, int x, int y){
        super(c, x, y);
        this.type = "cavalier";
    }

    /*------------------------ Méthodes ------------------------*/

    /*Méthode retournant une chaîne de caractère permettant d'avoir le nom de la piece ici Cavalier*/
    public String getType(){
        return this.type;
    }

    /*Méthode  retournant un tableau de position permettant d'avoir toutes les positions pour tous les déplacements possibles du cavalier sois en forme de L autour de lui, 
    prenant un plateau en paramètre*/
    public ArrayList<Position> getDeplacementPossible(Plateau p){
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        int c = this.getCouleur();

        if (x<6 && y>0 && (p.getCase(x+2,y-1) == null || p.getCase(x+2,y-1).getCouleur() != c)){
            this.dep.add(new Position(x+2,y-1));
        }
        if (x<7 && y>1 && (p.getCase(x+1,y-2) == null || p.getCase(x+1,y-2).getCouleur() != c)){
            this.dep.add(new Position(x+1,y-2));
        }
        if (y<7 && x<6 && (p.getCase(x+2,y+1) == null || p.getCase(x+2,y+1).getCouleur() != c)){
            this.dep.add(new Position(x+2,y+1));
        }
        if (y<6 && x<7 && (p.getCase(x+1,y+2) == null || p.getCase(x+1,y+2).getCouleur() != c)){
            this.dep.add(new Position(x+1,y+2));
        }
        
        if (x>1 && y>0 && (p.getCase(x-2,y-1) == null || p.getCase(x-2,y-1).getCouleur() != c)){
            this.dep.add(new Position(x-2,y-1));
        }
        if (x>0 && y>1 && (p.getCase(x-1,y-2) == null || p.getCase(x-1,y-2).getCouleur() != c)){
            this.dep.add(new Position(x-1,y-2));
        }
        if (y<7 && x>1 && (p.getCase(x-2,y+1) == null || p.getCase(x-2,y+1).getCouleur() != c)){
            this.dep.add(new Position(x-2,y+1));
        }
        if (y<6 && x>0 && (p.getCase(x-1,y+2) == null || p.getCase(x-1,y+2).getCouleur() != c)){
            this.dep.add(new Position(x-1,y+2));
        }
        
        return this.dep;
    }
    
}
