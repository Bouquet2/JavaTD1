package upo.cpo5;

import upo.cpo5.Exception.MonException;

/**
 * Minimum sur les operations de credit
 * Depot minimum lors de la création (impossible de creer un compte sans solde)
 */

public class CompteEpargne extends CompteAvecLimite{
    private final double minimumCredit = 20;
    private final double depotMinimalCreation = 1000;
    private double tauxRemunerationVariable = 1.5;

    public CompteEpargne(Utilisateur utilisateur,double solde) throws MonException {
        super(utilisateur,solde);
        if(solde < depotMinimalCreation)
            throw new MonException("Compte Epargne creation : Solde < au depot minimal obligatoire");
    }

    public void creditCompte(double credit) throws MonException{
        if(credit < minimumCredit)
            throw new MonException("Compte Epargne : Credit demande insuffisant");
        if(credit + getSolde() > getPlafondDepot() )
            throw new MonException("Compte Epargne : Vous ne pouvez pas depasse le plafond de depot.");
        setSolde(getSolde() + credit);
    }

    public void debitCompte(double debit) throws MonException{
        if(getSolde() - debit < depotMinimalCreation){
            //CLIENT COMPTE REMOVE
            throw new MonException("Compte Epargne : Vous ne pouvez pas debite cette somme, le compte est supprime");
        }
        setSolde(getSolde() - debit);
    }

    public void virementCompte(double debit,Compte recepteur) throws MonException{
        try{
            this.debitCompte(debit);
            recepteur.setSolde(getSolde()+debit);
        } catch(MonException a){
            System.out.println(a);
        }
    }

    /**
     * Afficher le calcul d'interet ou juste retourne la valeur ? Quelle utilisateur de cette méthode ?
     */
    public double calculInteret(int mois){ return (13 - mois) * tauxRemunerationVariable;}

}
