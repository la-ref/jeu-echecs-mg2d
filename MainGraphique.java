/*######################################################*/
/*################ Classe MainGraphique ################*/
/*######################################################*/

import MG2D.* ;
import MG2D.geometrie.* ;

import java.text.NumberFormat.Style;
import java.util.ArrayList;

class MainGraphique {
    public static void main(String[] args){
        /* Creation du plateau et de la fenetre*/
        Plateau plateau = new Plateau();
        Fenetre f = new Fenetre("Plateau", 800, 800);
        ArrayList<Texture> texturePiece = new ArrayList<Texture>();

        /* Creation graphique de plateau representant les cases avec l'echanges entre la couleur noire et blanche*/
        int nb2 = 0;
        for (int i = 0; i<8;i++){
           int nb = 0;
           for (int y=1; y<=8; y++){
               if (y%2 == 1){
                   if (i%2 == 0){
                       Carre c = new Carre(new Couleur(100,100,100), new Point(nb,nb2), 100, true);
                       f.ajouter(c);
                   }
                   else{
                       Carre c = new Carre(new Couleur(255,255,255), new Point(nb,nb2), 100, true);
                       f.ajouter(c);
                   }
               }
               else{
                   if (i%2 == 0){
                       Carre c = new Carre(new Couleur(255,255,255), new Point(nb,nb2), 100, true);
                       f.ajouter(c);
                   }
                   else{
                       Carre c = new Carre(new Couleur(100,100,100), new Point(nb,nb2), 100, true);
                       f.ajouter(c);
                   }
               }

               nb+= 100;
           }
           nb2+= 100;
        }

        /* Affichage des pièces presentes dans le plateau avec l'ajout à leur position*/
        for (int z = 0; z<8;z++){
            for (int v=0; v<8; v++){
                if (plateau.getCase(v, z) != null){
                    int x = plateau.getCase(v, z).getPosition().getX()*100;
                    int y = plateau.getCase(v, z).getPosition().getY()*100;

                    Texture t = new Texture("images/"+plateau.getCase(v, z).getNomLong()+".png", new Point(x,y), 100, 100);
                    texturePiece.add(t);
                    f.ajouter(t);
                    }
                }
            }
            f.setBackground (new Couleur(255,255,255));
        
        Souris souris = f.getSouris();
        ArrayList<Cercle> listeCercle = new ArrayList<Cercle>();
        ArrayList<Piece> pieceJoue = new ArrayList<Piece>();
        char cJoueur = 'B';
        int joue = 0;
        /* Boucle de jeu*/
        while (true){
            try {
                Thread.sleep(5);
            }
            catch (Exception e){}
            /* Affiche quel joueur doit jouer*/
            if (cJoueur == 'B' && joue == 0){
                System.out.println("Tour du joueur aux pieces blanches");

            }
            if (cJoueur == 'N' && joue == 0){
                System.out.println("Tour du joueur aux pieces noires");
            }
            joue = 1;
            /* Verification de clic*/
            if (souris.getClicGauche()){
                int x = (souris.getPosition().getX()/100);
                int y = (souris.getPosition().getY()/100);
                for (int i = 0; i<listeCercle.size();i++){
                    f.supprimer(listeCercle.get(i));
                }
                /* Selection de piece et affichage des deplacements possibles*/
                if (plateau.getCase(x, y) != null && plateau.getCase(x, y).getCouleur() == cJoueur){
                    Piece pieceSelectionne = plateau.getCase(x, y);
                    if (pieceJoue.size() >0){
                        pieceJoue.remove(0);
                    }
                    pieceJoue.add(pieceSelectionne);
                    ArrayList<Position> dep = pieceSelectionne.getDeplacementPossible(plateau);
                    for (int p = 0; p<dep.size(); p++){
                        Position po = new Position(dep.get(p));
                        Point point = new Point((po.getX()*100),(po.getY()*100));
                        Carre cc = new Carre(Couleur.ROUGE, point, 100);
                        Cercle cer = new Cercle(Couleur.ROUGE, cc);
                        f.ajouter(cer);
                        listeCercle.add(cer);
                    }
                    f.rafraichir(); 
                }
                /* Verification des deplacements possibles en fonction de la piece selectionne si il est possible de deplacer à l'endroit clique*/
                if (pieceJoue.size() >0){
                    Position po = new Position(x, y);
                    ArrayList<Position> dep = pieceJoue.get(0).getDeplacementPossible(plateau);
                    if (dep.contains(po)){
                        if (cJoueur == 'B' && plateau.deplacer(pieceJoue.get(0).getPosition(), po)){
                            cJoueur = 'N';
                        }
                        else {if(cJoueur == 'N' && plateau.deplacer(pieceJoue.get(0).getPosition(), po) ){
                            cJoueur = 'B';
                        }}
                        /* Refresh des pieces si deplacement*/
                        pieceJoue.remove(0);
                        for (int i = 0;i<texturePiece.size();i++){
                            f.supprimer(texturePiece.get(i));
                        }
                        for (int z = 0; z<8;z++){
                            for (int v=0; v<8; v++){
                                if (plateau.getCase(v, z) != null){
                                    int xx = plateau.getCase(v, z).getPosition().getX()*100;
                                    int yy = plateau.getCase(v, z).getPosition().getY()*100;
                
                                    Texture t = new Texture("images/"+plateau.getCase(v, z).getNomLong()+".png", new Point(xx,yy), 100, 100);
                                    texturePiece.add(t);
                                    f.ajouter(t);
                                    }
                                }
                            }
                            f.setBackground (new Couleur(255,255,255));
                            joue = 0;
                    }
                    /* Verification si le joueur adverse est en echec suite au deplacement*/
                    if (plateau.estEchec(cJoueur) == true){
                        if (cJoueur == 'B'){
                            System.out.println("Roi Joueur blanc en Echec");
                        }
                        if (cJoueur == 'N'){
                            System.out.println("Roi Joueur noir en Echec");
                        }
                    }
                    dep.clear();}
                    f.rafraichir();
            }
        }

    }
}