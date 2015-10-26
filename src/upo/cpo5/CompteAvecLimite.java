package upo.cpo5;

/**
 *
 */
public abstract class CompteAvecLimite extends Compte{

    private final double plafondDepot = 1500;

    public CompteAvecLimite(Utilisateur utilisateur) {super(utilisateur);}

    public CompteAvecLimite(Utilisateur utilisateur,double solde) { super(utilisateur,solde);}

    public double getPlafondDepot() {return plafondDepot;}
}
