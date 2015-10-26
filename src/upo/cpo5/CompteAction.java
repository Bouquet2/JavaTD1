package upo.cpo5;

import upo.cpo5.Exception.MonException;

/**
 * Verifier cloture compte
 * Virement non autorise vers CompteAction, comment verifie ?
 */

public class CompteAction extends CompteSansLimite{
    private final double plafondOperationCredit = 300;
    private final double versementInitialObligatoire = 5000;

    public CompteAction(Utilisateur utilisateur, double solde) throws MonException{
        super(utilisateur, solde);
        if(solde < versementInitialObligatoire)
            throw new MonException("Creation Compte Action : Le solde fixe est inferieur au versement minimal obligatoire lors de l'ouverture du compte ");
    }

    public double getPlafondOperationCredit() { return plafondOperationCredit;}

    public double getVersementInitialObligatoire() { return versementInitialObligatoire;}

    public void creditCompte(double credit) throws MonException{
        if(credit > plafondOperationCredit)
            throw new MonException("Compte Action : Credit demande superieur au plafond sur les operations de credit");
        setSolde(getSolde() + credit);
    }

    public void debitCompte(double debit) throws MonException{
        throw new MonException("Compte Action : Debit ponctuel non autorise sur un Compte Action");
    }

    public void virementCompte(double debit,Compte recepteur) throws MonException {
        if (getSolde() - debit < versementInitialObligatoire)
            throw new MonException("Compte Action : Virement non autorise, le solde du compte ne peut etre inferieur au versement initial obligatoire");
        setSolde(getSolde() - debit);
        recepteur.setSolde(recepteur.getSolde() + debit);
    }
}
