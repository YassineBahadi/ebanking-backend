package ma.yassine.ebankingbackend.exceptions;

/**
 * @author pc
 **/
public class BankAccountNotFoundException extends Exception {
    public BankAccountNotFoundException(String message) {
        super(message);
    }
}
