/*################################################*/
/*################ Classe Plateau ################*/
/*################################################*/
import java.util.ArrayList;

class Plateau {
    /*------------------------ Attributs ------------------------*/

    private ArrayList<Piece> tableau = new ArrayList<Piece>();

    /*------------------------ Constructeurs ------------------------*/

    /*Constructeur par défaut créant un tableau remplis de toutes les pièces d'un jeu d'echec en ajoutant leur couleur et leur position*/
    public Plateau(){

         for(int i = 0; i<=7; i++){
             this.tableau.add(new PionBlanc(i, 1));
             this.tableau.add(new PionNoir(i, 6));
         }
         // BLANC
         this.tableau.add(new Tour('B', "A1"));
         this.tableau.add(new Cavalier('B', "B1"));
         this.tableau.add(new Fou('B', "C1"));
         this.tableau.add(new Dame('B', "D1"));
         this.tableau.add(new Roi('B', "E1"));
         this.tableau.add(new Fou('B', "F1"));
         this.tableau.add(new Cavalier('B', "G1"));
         this.tableau.add(new Tour('B', "H1"));

         // NOIR
         this.tableau.add(new Tour('N', "A8"));
         this.tableau.add(new Cavalier('N', "B8"));
         this.tableau.add(new Fou('N', "C8"));
         this.tableau.add(new Dame('N', "D8"));
         this.tableau.add(new Roi('N', "E8"));
         this.tableau.add(new Fou('N', "F8"));
         this.tableau.add(new Cavalier('N', "G8"));
         this.tableau.add(new Tour('N', "H8"));
    }

    /*Constructeur par copie prenant en paramètre un objet de type ArrayList*/
    public Plateau(ArrayList t){
        this.tableau = t;
    }

    /*------------------------ Méthodes ------------------------*/

    /*Méthode Getter prenant en paramètre deux entiers x et y représentant une position retournant une piece si il y a une piece à cette
    position et qu'elle est présente dans le tableau/plateau sinon retourne null*/
    public Piece getCase(int x, int y){
        for(int i = 0; i<this.tableau.size(); i++){
            if (this.tableau.get(i).getPosition().getX() == x && this.tableau.get(i).getPosition().getY() == y){
                return this.tableau.get(i);
            }
        }
        return null;
    }

    /*Méthode Getter prenant en paramètre un objet de type Position retournant une piece si il y a une piece à cette
    position et qu'elle est présente dans le tableau/plateau sinon retourne null*/
    public Piece getCase(Position p){
        for(int i = 0; i<this.tableau.size(); i++){
            if (this.tableau.get(i).getPosition().getX() == p.getX() && this.tableau.get(i).getPosition().getY() == p.getY()){
                return this.tableau.get(i);
            }
        }
        return null;
    }

    /*Méthode Getter prenant en paramètre une chaine de caractère représentant une position retournant une piece si il y a une piece à cette
    position et qu'elle est présente dans le tableau/plateau sinon retourne null*/
    public Piece getCase(String pp){
        Position p = new Position(pp);
        for(int i = 0; i<this.tableau.size(); i++){
            if (this.tableau.get(i).getPosition().getX() == p.getX() && this.tableau.get(i).getPosition().getY() == p.getY()){
                return this.tableau.get(i);
            }
        }
        return null;
    }
    /*Méthode retournant un tableau de piece comportant toutes les pieces de couleurs blanches dans le tableau/plateau.*/
    public ArrayList<Piece> getPieceBlanches(){
        ArrayList<Piece> tab = new ArrayList<Piece>();
        for(int i = 0; i<this.tableau.size(); i++){
            if (this.tableau.get(i).getCouleur() == 'B'){
                tab.add(this.tableau.get(i));
            }
        }
        return tab;
    }

    /*Méthode retournant un tableau de piece comportant toutes les pieces de couleurs noires dans le tableau/plateau.*/
    public ArrayList<Piece> getPieceNoires(){
        ArrayList<Piece> tab = new ArrayList<Piece>();
        for(int i = 0; i<this.tableau.size(); i++){
            if (this.tableau.get(i).getCouleur() == 'N'){
                tab.add(this.tableau.get(i));
            }
        }
        return tab;
    }

    /*Méthode Getter prenant en paramètre un caractère représentant une couleur retournant la piece roi de cette couleur dans si elle est présente dans le tableau/plateau*/
    public Piece getRoi(char c){
        for(int i = 0; i<this.tableau.size(); i++){
            if (this.tableau.get(i).getCouleur() == c && this.tableau.get(i).getNomCourt().equals("Ro"+c)){
                return this.tableau.get(i);
            }
        }
        return null;
    }

    /*Méthode prenant en paramètre deux objet de type Position permettant de déplacer en modifiant ça position une piece et ou de manger également une autre piece
    si les déplacements de la piece from le permette, retournant true si possible sinon false */
    public boolean deplacer(Position from, Position to){
        if (this.getCase(from) != null){
            ArrayList<Position> tt = this.getCase(from).getDeplacementPossible(new Plateau(this.tableau));
            if(tt.contains(to)){
                if (this.getCase(to) != null){
                    this.tableau.remove(this.getCase(to));
                    this.getCase(from).setPosition(to);
                }
                else{
                    this.getCase(from).setPosition(to);
                }
                return true;
            }
        }
        return false;
    }

    /*Méthode prenant en paramètre deux objet de type Position permettant de déplacer en modifiant ça position une piece et ou de manger également une autre piece
    si les déplacements de la piece from le permette, retournant true si possible sinon false */
    public boolean estEchec(char c){
        if (this.getRoi(c) != null){
            ArrayList<Piece> tab = new ArrayList<Piece>();
            Piece roi = this.getRoi(c);
            if (c == 'B'){
                tab = this.getPieceNoires();
            }
            if(c == 'N'){
                tab = this.getPieceBlanches();
            }
            for (int i = 0; i<tab.size(); i++){
                Piece p = tab.get(i);
                ArrayList<Position> dep = p.getDeplacementPossible(new Plateau(this.tableau));
                for (int y = 0; y<dep.size();y++){
                    if (dep.get(y).equals(roi.getPosition())){
                        return true;
                    }
                }
            }
        }
        return false;
        
    }

    /*Méthode toString retournant une chaîne de caractère donnant toutes les pieces présentes dans le tableau/plateau avec leur couleur et leur postion sous forme:
    {
    ["tour", "blanc", 0, 0], ["cavalier", "blanc", 1, 0], ["fou", "blanc", 2, 0],
    ["dame", "blanc", 3, 0], ["roi", "blanc", 4, 0], ["fou", "blanc", 5, 0]}
    ...*/
    public String toString(){
        String s = "{";
        String c;
        for(int i = 0; i<this.tableau.size(); i++){
            if (this.tableau.get(i).getCouleur() == 'B'){
                c = "blanc";
            }
            else{
                c = "noir";
            }
            s = s + "[" + "\""+this.tableau.get(i).getType()+"\""+", " + "\""+c+"\""+  ", " + this.tableau.get(i).getPosition().getX() +  ", " + this.tableau.get(i).getPosition().getY() + "]" +", ";
            if (i%3 == 0 && i != 0){s = s+"\n";}
        }
        s = s + "}";
        return s;
    }

    /*Méthode affichant toutes les pieces présentes dans le tableau/plateau sous forme de tableau 8*8 représentant un échiquier:
     |---|---|---|---|---|---|---|---|
    8|ToN|CaN|FoN|DaN|RoN|FoN|CaN|ToN|8
     |---|---|---|---|---|---|---|---|
    7|PiN|PiN|PiN|PiN|PiN|PiN|PiN|PiN|7
     |---|---|---|---|---|---|---|---|
    6|   |   |   |   |   |   |   |   |6
     |---|---|---|---|---|---|---|---|
    5|   |   |   |   |   |   |   |   |5
     |---|---|---|---|---|---|---|---|
    4|   |   |   |   |   |   |   |   |4
     |---|---|---|---|---|---|---|---|
    3|   |   |   |   |   |   |   |   |3
     |---|---|---|---|---|---|---|---|
    2|PiB|PiB|PiB|PiB|PiB|PiB|PiB|PiB|2
     |---|---|---|---|---|---|---|---|
    1|ToB|CaB|FoB|DaB|RoB|FoB|CaB|ToB|1
     |---|---|---|---|---|---|---|---|
       A   B   C   D   E   F   G   H
*/ 
    public void toStringTableau(){
        System.out.println("   A   B   C   D   E   F   G   H  ");
        for (int i=8; i>0; i--){
            String message = "";
            System.out.println(" |---|---|---|---|---|---|---|---|");
            message += i;
            for (int y=0; y<8; y++){        
                if (this.getCase(y, i-1) == null){
                    message += "|   ";
                }
                else{
                    message += "|" + this.getCase(y, i-1).getNomCourt();
                }
            }
            System.out.println(message + "|" + (i));
        }
        System.out.println(" |---|---|---|---|---|---|---|---|");
        System.out.println("   A   B   C   D   E   F   G   H  ");
    }
}