package upo.cpo2;

/**
 * Created by vabouque on 01/10/2015.
 */
public class EmployeException extends Exception{

    public EmployeException(String message){
        super("Erreur declaration Employe, " + message);
    }
}
