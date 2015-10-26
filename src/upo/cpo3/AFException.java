package upo.cpo3;


/**
 * Décrivez votre classe MachineException ici.
 *
 */

public class AFException extends Exception
{
    /**
     * Constructeur d'objets de classe MachineException
     */
    public AFException(String message)
    {
        super("Problème d'automate : \n" + message);
    }

}

