package upo.cpo4;

/**
 * Created by Valentin on 04/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        ParcAttraction a = new ParcAttraction("MiageWonderland",1000,30,20);
        a.vendreBillets(500,Tarif.ILLIMITE);
        a.vendreBillets(20,Tarif.REDUIT);
        a.vendreBillets(50,Tarif.REDUIT5);
        a.vendreBillets(10,Tarif.ILLIMITE5);
        System.out.println(a.toString());
    }
}
