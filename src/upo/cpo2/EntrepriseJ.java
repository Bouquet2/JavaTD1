package upo.cpo2;


public class EntrepriseJ {

    public static void main(String[] args) {
        try {
            Employe a = new Employe("toto", 13, 60);
            afficheInformation(a);
        }catch (EmployeException b){
            System.out.println(b);
        }
    }

    public static double salaireHebdomadaire(Employe a){
        if(a.getNbHeures() <= 40){
            return a.getNbHeures() * a.getSalaireHoraire();
        }
        return (a.getSalaireHoraire() * 40) +
                ((a.getNbHeures() - 40) * (a.getSalaireHoraire() *1.5));
    }

    public static void afficheSalaireHebdomadaire(Employe a){
        System.out.println(salaireHebdomadaire(a));
    }

    public static void afficheInformation(Employe a){
        if(erreur(a)) System.out.println("Erreur");
        System.out.println(affiche(a));
    }

    public static boolean erreur(Employe a){
        if(a.getNbHeures() > 60
                ||a.getSalaireHoraire() < 13){
            return true;
        }
        return false;
    }

    public static String affiche(Employe a) {
        final StringBuilder sb = new StringBuilder("");
        sb.append(a.getNom()).append(",");
        sb.append(" salaire horaire : ").append(a.getSalaireHoraire());
        sb.append(" heures travaillees : ").append(a.getNbHeures());
        return sb.toString();
    }
}
