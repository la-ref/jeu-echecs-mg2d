class Main {
    public static void main(String[] args){
        Plateau pl = new Plateau();
        pl.getCase(1,7);
        System.out.println(pl);

        pl.toStringTableau();

        Piece test = pl.getCase("A2");
        System.out.println(test.getDeplacementPossible(pl));

        System.out.println(pl.estEchec('B'));
//
       // Position p = new Position("F3");
       // Position d = new Position("D5");
//
       // pl.deplacer(p, d, test.getDeplacementPossible(pl));
//
       // pl.toStringTableau();
//
       // Position e = new Position("G8");
       // Piece testt = pl.getCase("D5");
       // pl.deplacer(d, e, testt.getDeplacementPossible(pl));
//
       // pl.toStringTableau();
        
    }
}