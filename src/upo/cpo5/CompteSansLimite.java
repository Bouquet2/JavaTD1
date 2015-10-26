package upo.cpo5;


public abstract class CompteSansLimite extends Compte {

    public CompteSansLimite(Utilisateur utilisateur) { super(utilisateur);}

    public CompteSansLimite(Utilisateur utilisateur,double solde) { super(utilisateur,solde);}
}
