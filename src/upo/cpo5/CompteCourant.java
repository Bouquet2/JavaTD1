package upo.cpo5;

import upo.cpo5.Exception.MonException;

/**
 * Plafond de decouvert autorise
 * Impossible de changer le plafond si le solde est deja negatif
 */
public class CompteCourant extends CompteSansLimite{

    private double plafondDecourvert;

    public CompteCourant(Utilisateur utilisateur, double plafondDecourvert) {
        super(utilisateur);
        this.plafondDecourvert = plafondDecourvert;
    }

    public CompteCourant(double solde,Utilisateur utilisateur, double plafondDecourvert) throws MonException{
        super(utilisateur,solde);
        if(solde < plafondDecourvert)
            throw new MonException("Compte courant creation : Vous ne pouvez pas initialiser un compte avec un solde inferieur au plafond de découvert autorise");
        this.plafondDecourvert = plafondDecourvert;
    }

    public CompteCourant(Utilisateur utilisateur) {
        super(utilisateur);
        this.plafondDecourvert = 0;
    }

    public CompteCourant(double solde,Utilisateur utilisateur) throws MonException{
        super(utilisateur,solde);
        if(solde < 0)
            throw new MonException("Compte courant creation : Vous ne pouvez pas initialiser un compte avec un solde inferieur a 0");
        this.plafondDecourvert = 0;
    }

    public double getPlafondDecourvert() {
        return plafondDecourvert;
    }

    public void setPlafondDecourvert(double plafondDecourvert) throws MonException{
        if(getSolde() < 0)
            throw new MonException("Compte courant : Impossible de modifier le plafond de decouvert votre solde est deja negatif");
        this.plafondDecourvert = plafondDecourvert;
    }

    public void creditCompte(double credit) throws MonException { setSolde(credit+getSolde());}

    public void debitCompte(double debit) throws MonException {
        if(getSolde() - debit < plafondDecourvert)
            throw new MonException("Compte courant : Impossible de debiter cette somme, le solde du compte ne peut etre inferieur au plafond decouvert autorise");
    }

    public void virementCompte(double debit, Compte recepteur)  {
        try {
            this.debitCompte(debit);
            recepteur.creditCompte(debit);
        } catch (MonException e) {
            e.printStackTrace();
        }
    }
}
