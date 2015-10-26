package upo.cpo2;

public class Employe {
    private final String nom;
    private double salaireHoraire;
    private int nbHeures;

    public Employe(String nom, double salaireHoraire,int nbHeures) throws EmployeException{
        if(salaireHoraire < 13)
            throw new EmployeException("Salaire Horaire inferieur a 13");
        if(nbHeures > 60)
            throw new EmployeException("Nombre d'heure superieur a 60");
        this.nom = nom;
        this.salaireHoraire = salaireHoraire;
        this.nbHeures = nbHeures;
    }

    public double getSalaireHoraire() {
        return salaireHoraire;
    }

    public void setSalaireHoraire(double salaireHoraire) {
        this.salaireHoraire = salaireHoraire;
    }

    public String getNom() {
        return nom;
    }

    public int getNbHeures() {
        return nbHeures;
    }

    public void setNbHeures(int nbHeures) {
        this.nbHeures = nbHeures;
    }
}
