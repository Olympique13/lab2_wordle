//// À noter que le code n'est pas encore terminé, donc il y aura des erreurs de compilation qui disparaitront une fois complété.
//
//public class JeuWordlee {
//
//    private final String motSecret;
//    private final int nbMaxTentatives;
//    private int nbTentativesFaites;
//    private boolean gagne;
//    private boolean jeuValide;
//
//    public JeuWordlee(String motSecret, int nbMaxTentatives) {
//        nbTentativesFaites = 0;
//        gagne = false;
//        jeuValide = true;
//
//// Une alternative (style "validation positive") est de démarrer avec jeuValide = false
//// et passer à true seulement si tout est correct.
//// Pour faire ça, tu devrais :
//// 1) Remplacer la ligne "jeuValide = true;" par "jeuValide = false;"
//// 2) Créer une variable locale (ex: boolean estCorrect = true;)
//// 3) Au lieu de faire "jeuValide = false" à chaque erreur, faire "estCorrect = false"
//// 4) À la fin du constructeur, faire "jeuValide = toutEstCorrect;"
//
//
//        if (nbMaxTentatives <= 0) {
//            System.out.println("Erreur : nombre de tentatives invalide");
//            jeuValide = false;
//        }
//
//        String motNormalise;
//
//        if (motSecret == null) {
//            System.out.println("Erreur : mot secret invalide");
//            jeuValide = false;
//        }
//
//
//        motNormalise = motSecret.trim().toLowerCase();
//
//        if (motNormalise.length() != 5) {
//            System.out.println("Erreur : mot secret invalide");
//            jeuValide = false;
//        }
//
//        for (int i = 0; i < 5; i++) {
//            char c = motNormalise.charAt(i);
//            if (!Character.isLetter(c)) {
//                System.out.println("Erreur : mot secret invalide");
//                jeuValide = false;
//                break;
//            }
//        }
//
//        if(jeuValide){
//            this.motSecret = motSecret;
//            this.nbMaxTentatives = nbMaxTentatives;
//        } else {
//            this.motSecret = "aaaaa";
//            this.nbMaxTentatives = 0;
//        }
//
//    }
//
//    public boolean estJeuValide(){
//        return jeuValide;
//    }
//
//    public boolean aGagne(){
//        return gagne;
//    }
//
//    public boolean estTermine(){
//        if (!jeuValide || !gagne || nbTentativesFaites >= nbMaxTentatives){
//            return true;
//        }
//        return false;
//    }
//
//}
