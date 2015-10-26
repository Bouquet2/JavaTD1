package upo.cpo5;

import upo.cpo5.Exception.MonException;

/**
 * Classe principal compte dont dérivera tous les autres comptes
 * Fonctionalites:
 * Credit
 * Debit
 * Virement
 * Affiche numero de compte & solde
 */

public abstract class Compte{
    private Utilisateur utilisateur;
    private double solde;
    private final int numero;
    private static int cpt=0;

    public Compte(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        solde = 0;
        cpt++;
        numero = cpt;
    }

    public Compte(Utilisateur utilisateur,double solde) {
        this.utilisateur = utilisateur;
        this.solde = solde;
        cpt++;
        numero = cpt;
    }

    public Utilisateur getUtilisateur() { return utilisateur;}

    public void setUtilisateur(Utilisateur utilisateur) { this.utilisateur = utilisateur;}

    public double getSolde() { return solde;}

    public void setSolde(double solde) { this.solde = solde;}

    public static int getCpt() { return cpt;}

    public int getNumero() { return numero;}


    abstract public void creditCompte(double credit) throws MonException;

    abstract public void debitCompte(double debit) throws MonException;

    abstract public void virementCompte(double debit,Compte recepteur) throws MonException;

    @Override
    public String toString() {
        final String Newligne=System.getProperty("line.separator");
        final StringBuilder sb = new StringBuilder(Newligne);
        sb.append("Numero de compte : ").append(numero).append(Newligne);
        sb.append("Solde : ").append(solde).append(Newligne);
        return sb.toString();
    }
}
