/*#################################################*/
/*################ Classe Position ################*/
/*#################################################*/

class Position {
    /*------------------------ Attributs ------------------------*/
    private int x,y;

    /*------------------------ Constructeurs ------------------------*/

    /*Constructeur par défaut créant une position en x = 0 et y = 0*/
    public Position(){
        this.x = 0;
        this.y = 0;
    }

    /*Constructeur prenant en paramètre deux entiers, pour la position de la piece*/
    public Position(int xx, int yy){
        if (xx <= 7 && xx >= 0 && yy <= 7 && yy >= 0){
            this.x = xx;
            this.y = yy;
        }
        else {
            System.out.println("Impossible, x et y doivent être compris entre 0 et 7, mise à 0");
            this.x = 0;
            this.y = 0;
        }
    }

    /*Constructeur prenant en paramètre une chaine de caractere, pour la position de la piece*/
    public Position(String s){
        int xx = getLettre(s.substring(0,1));
        int yy = Integer.parseInt(s.substring(1,2))-1;
        if (xx <= 7 && xx >= 0 && yy <= 7 && yy >= 0){
            this.x = xx;
            this.y = yy;
        }
        else {
            System.out.println("Impossible");
        }
    }

    /*Constructeur par copie prenant en paramètre un objet de type Position*/
    public Position(Position p){
        this.x = p.x;
        this.y = p.y;
    }

    /*------------------------ Méthodes ------------------------*/

    /*Méthode privé prenant une chaine de charactère en paramètre pour permettre d'obtenir en fonction de la lettre du tableau de l'échiquier, la position en entier,
    retourne l'entier ou -1*/
    private int getLettre(String lettre){
        String l[] = {"A","B","C","D","E","F","G","H"};
        for(int i = 0; i<8; i++){
            if (lettre.equals(l[i])){
                return i;
            }
        }
        return -1;
    }

    /*Méthode Setter pour permettre de modifier l'attribut x et y avec deux entiers en paramètre représentant une position*/
    public void setPosition(int xx, int yy){
        if (xx <= 7 && xx >= 0 && yy <= 7 && yy >= 0){
            this.x = xx;
            this.y = yy;
        }
        else {
            System.out.println("Impossible, x et y doivent être compris entre 0 et 7");
        }
    }

    /*Méthode Setter pour permettre de modifier l'attribut x et y avec une chaîne de caractère en paramètre représentant une position*/
    public void setPosition(String s){
        int xx = getLettre(s.substring(0,1));
        int yy = Integer.parseInt(s.substring(1,2))-1;
        if (xx <= 7 && xx >= 0 && yy <= 7 && yy >= 0){
            this.x = xx;
            this.y = yy;
        }
        else {
            System.out.println("Impossible, x et y doivent être compris entre 0 et 7");
        }
    }

    /*Méthode Setter permettant de retourner l'attribut x*/
    public int getX(){
        return this.x;
    }

    /*Méthode Setter permettant de retourner l'attribut y*/
    public int getY(){
        return this.y;
    }

    /*Méthode Setter pour permettre de modifier l'attribut x avec un entier en paramètre*/
    public void setX(int xx){
        this.x = xx;
    }

    /*Méthode Setter pour permettre de modifier l'attribut y avec un entier en paramètre*/
    public void setY(int yy){
        this.y = yy;
    }

    /*Méthode toString retournant une chaîne de caractère donnant la position en format échiquier, sous forme:
    A8
    B8
    ...*/
    public String toString(){
        String l[] = {"A","B","C","D","E","F","G","H"};
        return new String(l[this.x]+(this.y+1));
    }

    /*Méthode equals retournant un boolean verifiant l'egalite entre deux objets et verfie si c'est une position avec un objet en parametre */
    public boolean equals(Object p){
        if(p instanceof Position){
            Position po = (Position) p;
            if(po != null && this.x == po.x && this.y == po.y){
                return true;
            }
        }
        return false;
    }

    
}