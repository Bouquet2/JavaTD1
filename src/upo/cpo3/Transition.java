package upo.cpo3;

import java.util.Objects;

/**
 * Classe Transition, defini Etat suivant et etiquiette
 */
public class Transition {

    private Etat suivant;
    private Object etiquette;

    public Transition(Etat suivant, Object etiquette) {
        this.suivant = suivant;
        this.etiquette = etiquette;
    }

    public Object getEtiquette() {
        return etiquette;
    }

    public void setEtiquette(Object etiquette) {
        this.etiquette = etiquette;
    }

    public Etat franchir(){
        return suivant;
    }
}
