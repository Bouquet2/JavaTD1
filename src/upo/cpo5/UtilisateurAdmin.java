package upo.cpo5;

import upo.cpo5.Exception.MonException;

/**
 * Fonctionalites :
 *
 * Liste de tout les comptes de la banque => comment inserer une liste de tous les objets compte ?
 * Cloturer un compte => Peut on cloturer un compte non vide ?
 * Voir les comptes d'un client
 * Creer un compte => Peut on creer 2comptes epargnes ? Comment verifier quel objet est présent dans la liste des comptes ?
 *
 * Interdit :
 *
 * Ne peut pas posséder de compte !
 */
public class UtilisateurAdmin extends Utilisateur {

    public UtilisateurAdmin(String nom) { super(nom);}

    public void creerCompteEpargne(UtilisateurClient utilisateur,double solde){
        Compte compte = null;
        try {
            compte = new CompteEpargne(utilisateur,solde);
            utilisateur.getListeCompte().add(compte);
        } catch (MonException e) {
            e.printStackTrace();
        }
    }

    public void creerCompteAction(UtilisateurClient utilisateur,double solde){
        Compte compte = null;
        try {
            compte = new CompteAction(utilisateur,solde);
            utilisateur.getListeCompte().add(compte);
        } catch (MonException e) {
            e.printStackTrace();
        }

    }

    public void creerCompteCourant(UtilisateurClient utilisateur,double plafondDecouvertAutorise){
        Compte compte = new CompteCourant(utilisateur,plafondDecouvertAutorise);
        utilisateur.getListeCompte().add(compte);
    }

    public void creerCompteCourant(UtilisateurClient utilisateur){
        Compte compte = new CompteCourant(utilisateur);
        utilisateur.getListeCompte().add(compte);
    }

    public void creerCompteCourant(double solde,UtilisateurClient utilisateur) {
        Compte compte = null;
        try {
            compte = new CompteCourant(solde,utilisateur);
        } catch (MonException e) {
            e.printStackTrace();
        }
        utilisateur.getListeCompte().add(compte);
    }

    public void creerCompteCourant(double solde,UtilisateurClient utilisateur,double plafondDecouvertAutorise){
        Compte compte = null;
        try {
            compte = new CompteCourant(solde,utilisateur,plafondDecouvertAutorise);
        } catch (MonException e) {
            e.printStackTrace();
        }
        utilisateur.getListeCompte().add(compte);
    }

    public void cloturerCompte(UtilisateurClient client,Compte compte){

    }

    public String afficherCompteClient(Utilisateur client){
        return client.toString();
    }
}
