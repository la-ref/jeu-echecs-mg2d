/*############################################*/
/*################ Classe Fou ################*/
/*############################################*/

/*#### Hérite de la classe Piece ####*/

import java.util.ArrayList;
public class Fou extends Piece{

    /*------------------------ Attributs ------------------------*/

    String type;
    ArrayList<Position> dep = new ArrayList<Position>();
    
    /*------------------------ Constructeurs ------------------------*/

    /*Constructeur par défaut créant un Fou ayant pour position A1 et pour couleur blanc via sa classe mère et avec son type étant Fou */
    public Fou(){
        super('B', "A1");
        this.type = "fou";
    }

    /*Constructeur créant un Fou prenant en paramètre un charactère pour la couleur et un objet de type
    position pour sa position, via sa classe mère et avec son type étant Fou */
    public Fou(char c, Position p){
        super(c, p);
        this.type = "fou";
    }

    /*Constructeur créant un Fou prenant en paramètre un charactère pour la couleur et une chaine
    de caractere pour sa position, via sa classe mère et avec son type étant Fou */
    public Fou(char c, String p){
        super(c, p);
        this.type = "fou";
    }

    /*Constructeur créant un Fou prenant en paramètre un charactère pour la couleur et deux entiers
    pour sa position, via sa classe mère et avec son type étant Fou */
    public Fou(char c, int x, int y){
        super(c, x, y);
        this.type = "fou";
    }

    /*------------------------ Méthodes ------------------------*/

    /*Méthode retournant une chaîne de caractère permettant d'avoir le nom de la piece ici Fou*/
    public String getType(){
        return this.type;
    }

    /*Méthode  retournant un tableau de position permettant d'avoir toutes les positions pour tous les déplacements possibles du Fou sois en diagonale, 
    prenant un plateau en paramètre*/
    public ArrayList<Position> getDeplacementPossible(Plateau p){
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();
        int c = this.getCouleur();

        int i = 0;
        int f = 0;
        while(x+i < 7 && y+i < 7 && f != 1){
            i++;
            if(p.getCase(x+i, y+i) == null){
                this.dep.add(new Position(x+i,y+i));
            }
            else {
                f = 1;
                if (p.getCase(x+i, y+i).getCouleur() != c){
                    this.dep.add(new Position(x+i,y+i));
                }
            }
        }
        f = 0;
        i=0;
        while(x-i > 0 && y-i > 0 && f != 1){
            i++;
            if(p.getCase(x-i, y-i) == null){
                this.dep.add(new Position(x-i,y-i));
            }
            else {
                f = 1;
                if (p.getCase(x-i, y-i).getCouleur() != c){
                    this.dep.add(new Position(x-i,y-i));
                }
            }
        }
        f = 0;
        i=0;
        while(x+i < 7 && y-i > 0 && f != 1){
            i++;
            if(p.getCase(x+i, y-i) == null){
                this.dep.add(new Position(x+i,y-i));
            }
            else {
                f = 1;
                if (p.getCase(x+i, y-i).getCouleur() != c){
                    this.dep.add(new Position(x+i,y-i));
                }
            }
        }
        f = 0;
        i=0;
        while(x-i > 0 && y+i < 7 && f != 1){
            i++;
            if(p.getCase(x-i, y+i) == null){
                this.dep.add(new Position(x-i,y+i));
            }
            else {
                f = 1;
                if (p.getCase(x-i, y+i).getCouleur() != c){
                    this.dep.add(new Position(x-i,y+i));
                }
            }
        }

        return this.dep;
    }

}
