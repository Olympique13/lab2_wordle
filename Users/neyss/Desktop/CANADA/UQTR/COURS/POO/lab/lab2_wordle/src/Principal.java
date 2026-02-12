//Scanner, initialisation etc..
import java.util.Scanner;

public class Principal {
    static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        JeuWordle a ;
          a = new JeuWordle("radin", 6);
//        a = new JeuWordle("null", 6);
//        a = new JeuWordle("unique", 6);
//        a = new JeuWordle("ra-in", 6);
//        a = new JeuWordle("null", 0);

        if(a.estJeuValide()) {
            System.out.println("Bienvenue sur Wordle, le but est de trouver le bon mot de 5 lettres en 6 tentatives !");
            System.out.println("Vous avez un total de " + (a.getNbMaxTentatives() - a.getNbTentativesFaites()) + " tentatives ! Entrez un mot : ");
            while (!a.estTermine()) {
                String essai = sc1.next();
                System.out.println(a.evaluerEssai(essai));
                if (a.aGagne()) {
                    System.out.println("Félicitation, vous avez trouvé le mot mystère avec un total de : " + a.score() + " points");
                } else {
                    System.out.println("Il vous reste: " + (a.getNbMaxTentatives() - a.getNbTentativesFaites()) + " tentatives\nScore : " + a.score());
                }

                if (!a.aGagne() && (a.getNbMaxTentatives() - a.getNbTentativesFaites()) == 0) {
                    System.out.println("Vous n'avez pas réussi à trouver le mot et avez dépassez le nombre max de tentatives :(");
                }
            }
        }
//        System.out.println(a.estJeuValide());
//        System.out.println(a.estEssaiValid("  abcde "));
//        System.out.println(a.evaluerEssai("radin"));
//        System.out.println(a.tentativesRestantes());
//        System.out.println(a.estTermine());

    }
}
