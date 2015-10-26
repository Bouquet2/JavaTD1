package upo.cpo3;



import java.util.ArrayList;

/**
 * Un Etat d'automate fini
 *

 */

public class Etat {

    /** nom de l'état */
    private String nom;

    /** liste des transitions partant de cet état */
    private ArrayList<Transition> transitions;

    /** est-ce-que l'état est terminal ? */
    private boolean terminal;

    /**
     * Constructeur principal
     **/
    public Etat(String nom) {
        this(nom,false);
    }

    /**
     * Constructeur protégé
     */

    protected Etat(String nom, boolean terminal) {
        this.nom = nom;
        this.transitions = new ArrayList<Transition>(	);
        this.terminal = terminal;
    }


    /** retourne le nom de l'état */
    public String getNom() {
        return nom;
    }

    /**
     * Chercher et retourner un état suivant
     */

    public Etat getSuivant(Object input) {
        for(int i=0;i<transitions.size();i++) {
            if(transitions.get(i).getEtiquette().equals(input))
                return transitions.get(i).franchir();
        }
        // si on ne peut franchir une transition
        // l'état suivant est null
        return null;
    }

    /** retourne true si c'est un état final, false sinon */
    public boolean isTerminal() {
        return terminal;
    }

    /**
     * ajout d'une transition à l'état
     */
    public void addTransition(Transition trans) {
        transitions.add(trans);
    }

}

