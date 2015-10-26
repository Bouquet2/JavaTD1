package upo.cpo5;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;

/**
 * Integrer un mdp pour la connexion : Y / N ?
 * Abstract : Y / N ?
 * Interface : Y / N ?
 */

public class Utilisateur {
    private final String nom;
    private final int numero;
    private static int cptNumero=0;
    //private String mdp;

    public Utilisateur(String nom) {
        this.nom = nom;
        numero = ++cptNumero;
    }

    public String getNom() { return nom;}

    public int getNumero() { return numero;}

    @Override
    public String toString() {
        final String Newligne=System.getProperty("line.separator");
        final StringBuilder sb = new StringBuilder("Utilisateur : ");
        sb.append("Nom Utilisateur : ").append(nom).append(Newligne);
        sb.append("Numero utilisateur : ").append(numero).append(Newligne);
        return sb.toString();
    }
}
