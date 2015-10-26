package upo.cpo3;


/**
 * La classe principale des automates finis
 *
 */

public class AutomateFini {
    /** Etat de départ de l'automate fini */
    private Etat etat_depart;
    /** Etat final de l'automate fini */
    private Etat etat_courant;
    /** L'automate est-il actif ? */
    private boolean active;
    /** L'automate est-il terminé ? */
    private boolean finish;

    public AutomateFini(Etat etat_depart) throws AFException {
        // PREREQUIS : L'état de départ doit être non nul
        if(etat_depart==null)
            throw new AFException("Etat de départ nul");
        // TRAITEMENTS
        this.etat_depart = etat_depart;
        this.etat_courant = etat_depart;
        active = false;
        finish = getEtatDepart().isTerminal();

    }

    public void start() throws AFException {
        // PREREQUIS : la machine n'est pas déjà démarrée
        if(active)
            throw new AFException("machine déjà démarrée");

        // TRAITEMENTS
        active = true;
        etat_courant = getEtatDepart();
        finish = getEtatDepart().isTerminal();
    }

    public void step(Object entree) throws AFException {

        Etat suivant = etat_courant.getSuivant(entree);
        if(entree == null)
            throw new AFException("object entree null");
        if(isActive())
            throw new AFException("Machine deja en fonctionnement");
        if(suivant == null)
            throw new AFException("Il n'existe pas d'etat suivant");
        // TRAITEMENTS
        etat_courant=suivant;
        finish = etat_courant.isTerminal();
    }

    public void stop() throws AFException {
        if(!isActive())
            throw new AFException("Machine déjà arrêtée");

        // TRAITEMENTS
        active = false;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isFinish() {
        return finish;
    }

    public Etat getEtatDepart() {
        return etat_depart;
    }

    public Etat getEtatCourant() {
        return etat_courant;
    }

}
