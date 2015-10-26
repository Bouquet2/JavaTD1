package upo.cpo4;


public class ParcAttraction {
    private final String nom;
    private final int capacite;
    private final double prixNormal;
    private final double prixNormal5;
    private int nbBilletsVendusIllimite;
    private int nbBilletsVendusIllimite5;
    private int nbBilletsVendusReduit;
    private int nbBilletsVendusReduit5;

    public ParcAttraction(String nom, int capacite, double prixNormal,double prixNormal5) {
        this.nom = nom;
        this.capacite = capacite;
        this.prixNormal = prixNormal;
        this.prixNormal5 = prixNormal5;
        nbBilletsVendusIllimite = 0;
        nbBilletsVendusIllimite5 = 0;
        nbBilletsVendusReduit = 0;
        nbBilletsVendusReduit5 = 0;

    }

    public String getNom() { return nom;}

    public int getCapacite() { return capacite;}

    public double getPrixNormal() { return prixNormal;}

    public double getPrixNormal5() { return prixNormal5;}

    public int getNbBilletsVendusIllimite() { return nbBilletsVendusIllimite;}

    public void setNbBilletsVendusIllimite(int nbBilletsVendusIllimite) {
        this.nbBilletsVendusIllimite = nbBilletsVendusIllimite;
    }

    public int getNbBilletsVendusIllimite5() { return nbBilletsVendusIllimite5;}

    public void setNbBilletsVendusIllimite5(int nbBilletsVendusIllimite5) {
        this.nbBilletsVendusIllimite5 = nbBilletsVendusIllimite5;
    }

    public int getNbBilletsVendusReduit() { return nbBilletsVendusReduit;}

    public void setNbBilletsVendusReduit(int nbBilletsVendusReduit) {
        this.nbBilletsVendusReduit = nbBilletsVendusReduit;
    }

    public int getNbBilletsVendusReduit5() { return nbBilletsVendusReduit5;}

    public void setNbBilletsVendusReduit5(int nbBilletsVendusReduit5) {
        this.nbBilletsVendusReduit5 = nbBilletsVendusReduit5;
    }



    public int nbPlacesDispo(){
        return capacite - (nbBilletsVendusReduit5 + nbBilletsVendusReduit
                + nbBilletsVendusIllimite + nbBilletsVendusIllimite5);
    }

    public void vendreBillets(int nb,Tarif tarif){
        switch (tarif){
            case ILLIMITE:
                nbBilletsVendusIllimite+= nb;
                break;
            case ILLIMITE5:
                nbBilletsVendusIllimite5+=nb;
                break;
            case REDUIT:
                nbBilletsVendusReduit+=nb;
                break;
            case REDUIT5:
                nbBilletsVendusReduit5+=nb;
                break;
            default:
                System.out.println("ERREUR TARIF");
                break;
        }
    }
    public void reinitialiser(){
        nbBilletsVendusIllimite = 0;
        nbBilletsVendusIllimite5 = 0;
        nbBilletsVendusReduit = 0;
        nbBilletsVendusReduit5 = 0;
    }

    public double chiffreAffaires(){
        return nbBilletsVendusIllimite * prixNormal + nbBilletsVendusIllimite5 * prixNormal5
                + nbBilletsVendusReduit * (prixNormal * 0.7) + nbBilletsVendusReduit5 * (prixNormal5 * 0.7);
    }

    public double tauxRemplissage(){
        return ((capacite - (double)nbPlacesDispo()) / capacite) * 100;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("Parc ").append(nom).append("\n");
        sb.append("Capacite d'accueil : ").append(capacite).append("").append("\n");; //RETOUR A LA LIGNE
        sb.append("Tarif normal illimite : ").append(prixNormal).append("\n");
        sb.append("Tarif normal illimite5 : ").append(prixNormal5).append("\n");
        sb.append(nbBilletsVendusIllimite).append(" Billets vendus au tarif illimite").append("\n");
        sb.append(nbBilletsVendusIllimite5).append(" Billets vendus au tarif illimite 5").append("\n");
        sb.append(nbBilletsVendusReduit).append(" Billets vendus au tarif reduit").append("\n");
        sb.append(nbBilletsVendusReduit5).append(" Billets vendus au tarif reduit 5").append("\n");
        sb.append("Taux de remplissage : ").append(tauxRemplissage()).append("%").append("\n");
        sb.append("Chiffres affaires : ").append(chiffreAffaires()).append("\n");
        return sb.toString();
    }
}



