/*############################################*/
/*################ Classe Roi ################*/
/*############################################*/

/*#### Hérite de la classe Piece ####*/

import java.util.ArrayList;
public class Roi extends Piece {

    /*------------------------ Attributs ------------------------*/

    String type;
    ArrayList<Position> dep = new ArrayList<Position>();

    /*------------------------ Constructeurs ------------------------*/
    
    /*Constructeur par défaut créant un Roi ayant pour position A1 et pour couleur blanc via sa classe mère et avec son type étant Roi */
    public Roi(){
        super('B', "A1");
        this.type = "roi";
    }

        /*Constructeur créant un Roi prenant en paramètre un charactère pour la couleur et un objet de type
    position pour sa position, via sa classe mère et avec son type étant Roi */
    public Roi(char c, Position p){
        super(c, p);
        this.type = "roi";
    }

    /*Constructeur créant un Roi prenant en paramètre un charactère pour la couleur et une chaine
    de caractere pour sa position, via sa classe mère et avec son type étant Roi */
    public Roi(char c, String p){
        super(c, p);
        this.type = "roi";
    }

    /*Constructeur créant un Roi prenant en paramètre un charactère pour la couleur et deux entiers
    pour sa position, via sa classe mère et avec son type étant Roi */
    public Roi(char c, int x, int y){
        super(c, x, y);
        this.type = "roi";
    }

    /*------------------------ Méthodes ------------------------*/

    /*Méthode retournant une chaîne de caractère permettant d'avoir le nom de la piece ici Roi*/
    public String getType(){
        return this.type;
    }

    /*Méthode  retournant un tableau de position permettant d'avoir toutes les positions pour tous les déplacements possibles du Roi tout autour de lui en +1, 
    prenant un plateau en paramètre*/
    public ArrayList<Position> getDeplacementPossible(Plateau p){
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        int c = this.getCouleur();
        if (x<7 && p.getCase(x+1, y) == null){
            this.dep.add(new Position(x+1,y));
        }
        else {
            if (x<7 && p.getCase(x+1, y).getCouleur() != c){
                this.dep.add(new Position(x+1,y));
            }
        }

        if (x>0 && p.getCase(x-1, y) == null){
                this.dep.add(new Position(x-1,y));
        }
        else{
            if (x>0 && p.getCase(x-1, y).getCouleur() != c){
                this.dep.add(new Position(x-1,y));
            }
        }

        if (y>0 && p.getCase(x, y-1) == null){
            this.dep.add(new Position(x,y-1));
        }
        else{
            if (y>0 && p.getCase(x, y-1).getCouleur() != c){
                this.dep.add(new Position(x,y-1));
            }
        }

        if (y<7 && p.getCase(x, y+1) == null){ 
            this.dep.add(new Position(x,y+1));
        }
        else{
            if (y<7 && p.getCase(x, y+1).getCouleur() != c){
                this.dep.add(new Position(x,y+1));
            }
        }
        
        if (y<7 && x < 7 && p.getCase(x+1, y+1) == null){
            this.dep.add(new Position(x+1,y+1));
        }
        else {
            if (y<7 && x < 7 && p.getCase(x+1, y+1).getCouleur() != c){
                this.dep.add(new Position(x+1,y+1));
            }
        }

        if (y>0 && x > 0 && p.getCase(x-1, y-1) == null){
            this.dep.add(new Position(x-1,y-1));
        }
        else{
            if (y>0 && x > 0 && p.getCase(x-1, y-1).getCouleur() != c){
                this.dep.add(new Position(x-1,y-1));
            }
        }

        if (x>0 && y<7 && p.getCase(x-1, y+1) == null){
            this.dep.add(new Position(x-1,y+1));
        }
        else{  
            if ( x>0 && y<7 && p.getCase(x-1, y+1).getCouleur() != c){
                this.dep.add(new Position(x-1,y+1));
            }
        }
        
        if (y>0 && x<7 && p.getCase(x+1, y-1) == null){
            this.dep.add(new Position(x+1,y-1));
        }
        else{
            if (y>0 && x<7 && p.getCase(x+1, y-1).getCouleur() != c){
                this.dep.add(new Position(x+1,y-1));
            }
        } 

            return this.dep;
        }

}
