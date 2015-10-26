package upo.cpo5;

import upo.cpo5.Exception.MonException;

import java.util.ArrayList;

/**
 * Fonctionalites:
 *
 * Liste des ses comptes
 * Credit compte
 * Debit compte
 * Virement
 * Calcult d'intéret d'un compte épargne
 * Afficher le solde d'un compte
 *
 * INTERDIT:
 *
 * Creation de compte interdite
 * Cloturation de compte interdite
 * Voir un compte qu'il ne possède pas
 *
 */
//ADADADADADADA
public class UtilisateurClient extends Utilisateur{
    private ArrayList<Compte> listeCompte;

    public UtilisateurClient(String nom,ArrayList<Compte> compte){
        super(nom);
        listeCompte = new ArrayList<>();
    }
    public UtilisateurClient(String nom) {
        super(nom);
        listeCompte = new ArrayList<>();
    }

    public ArrayList<Compte> getListeCompte() { return listeCompte;}

    public void setListeCompte(ArrayList<Compte> listeCompte) { this.listeCompte = listeCompte;}

    public void crediterCompte(Compte compte,double credit) {
        try {
            compte.creditCompte(credit);
        } catch (MonException e) {
            e.printStackTrace();
        }
    }

    public void debiterCompte(Compte compte,double debit){
        try {
            compte.debitCompte(debit);
        } catch (MonException e) {
            e.printStackTrace();
        }
    }

    public void virementCompte(Compte emetteur,Compte recepteur,double virement){
        try {
            emetteur.virementCompte(virement,recepteur);
        } catch (MonException e) {
            e.printStackTrace();
        }
    }

    public void calculInteret(CompteEpargne compte,int mois){
        compte.calculInteret(mois);
    }

    public String afficheUnCompte(Compte compte)throws MonException{
        if(compte.getUtilisateur() != this)
            throw new MonException("Vous ne pouvez pas afficher un compte d'un autre utilisateur");
        return compte.toString();
    }

    @Override
    public String toString() {
        final String Newligne=System.getProperty("line.separator");
        final StringBuilder sb = new StringBuilder(Newligne);
        sb.append("Comptes : ").append(listeCompte).append(Newligne);
        return sb.toString();
    }
}
