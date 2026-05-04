package ma.yassine.ebankingbackend.exceptions;

/**
 * @author pc
 **/
public class BalanceNotSufficientException extends Exception {
    public BalanceNotSufficientException(String message) {
        super(message);
    }
}
