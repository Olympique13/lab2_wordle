public class JeuWordle {
    private final String motSecret;
    private final int nbMaxTentatives;
    private int nbTentativesFaites;
    private boolean gagne;
    private boolean jeuValide;

    //Constructeur
    public JeuWordle(String motSecret, int nbMaxTentatives){
        this.nbTentativesFaites = 0;
        this.gagne = false;
        this.jeuValide = true;

        if(nbMaxTentatives <= 0){
            System.out.println("Erreur : nombre de tentatives invalide");
            jeuValide = false;
        }

        String motNormalise = "";
        if (motSecret == null) {
            System.out.println("Erreur : mot secret invalide");
            this.jeuValide = false;
        } else {
            motNormalise = motSecret.trim().toLowerCase();

            if (motNormalise.length() != 5) {
                System.out.println("Erreur : mot secret invalide");
                this.jeuValide = false;
            } else {
                for (int i = 0; i < 5; i++) {
                    char c = motNormalise.charAt(i);
                    if (!Character.isLetter(c)) {
                        System.out.println("Erreur : mot secret invalide");
                        this.jeuValide = false;
                        break;
                    }
                }
            }
        }

        if (jeuValide) {
            this.motSecret = motNormalise;
            this.nbMaxTentatives = nbMaxTentatives;
        } else {
            this.motSecret = "aaaaa";
            this.nbMaxTentatives = 0;
        }
    }

//    public int addition(int x){
//        int resultat = x;
//        for(int i = 1; i<3; i++){
//            resultat += i;
//        }
//        return resultat;
//    }

    public boolean estJeuValide(){
        if(jeuValide) {
            return true;
        } else {
            System.out.println("Impossible de démarrer le jeu");
            return false;
        }
    }

    public boolean aGagne(){
        if(gagne){
            return true;
        } else {
            return false;
        }
    }

    public boolean estTermine(){
        if (!jeuValide || gagne || nbTentativesFaites >= nbMaxTentatives){
            return true;
        }
        return false;
    }

    public int tentativesRestantes(){
        if(nbMaxTentatives > nbTentativesFaites){
            return nbMaxTentatives - nbTentativesFaites;
        }
        return 0;
    }

    public boolean estEssaiValid(String essai) {

        if (essai == null) {
            return false;
        }

        String essaiNormalise = essai.trim();
        if (essaiNormalise.length() != 5) {
            return false;
        }

        for (int i = 0; i < 5; i++) {
            char e = essaiNormalise.charAt(i);
            if (!Character.isLetter(e)) {
                return false;
            }
        }

        return true;
    }

    public String evaluerEssai(String essai){
        if(!jeuValide){
            System.out.println("Jeu invalide");
            return "BBBBB";
        } else if(estTermine()){
            System.out.println("Partie terminé");
            return "BBBBB";
        } else if(!estEssaiValid(essai)){
            System.out.println("Essai invalide (5 lettres)");
            return "BBBBB";
        }
        nbTentativesFaites++;

        essai = essai.trim().toLowerCase();
        StringBuilder caracteres = new StringBuilder();
        for(int i=0; i < 5; i++){
            char lettreEssai = essai.charAt(i);
            if(lettreEssai == motSecret.charAt(i)){
                caracteres.append("G");
            } else if(motSecret.contains(""+lettreEssai)){
                caracteres.append("Y");
            } else{
                caracteres.append("B");
            }
        }

        if (caracteres.toString().equals("GGGGG")){
            gagne = true;
        }

        return caracteres.toString();
    }

    //Getter
    public String getMotSecret(){
        return motSecret;
    }
    public int getNbMaxTentatives()
    {
        return nbMaxTentatives;
    }
    public int getNbTentativesFaites() {
        return nbTentativesFaites;
    }
    public boolean getGagne()
    {
        return gagne;
    }
    public boolean getJeuValide()
    {
        return jeuValide;
    }

    //Setter
    public void setNbTentativesFaites(int nbTentativesFaites) {
        this.nbTentativesFaites = nbTentativesFaites;
    }
    public void setGagne(boolean gagne) {
        this.gagne = gagne;
    }
    public void setJeuValide(boolean jeuValide) {
        this.jeuValide = jeuValide;
    }

    public int score(){
        int score = 100 - 10 * nbTentativesFaites;

        if (score < 0){
            return 0;
        }
        return score;
    }

}
