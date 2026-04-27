package ma.yassine.ebankingbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yassine.ebankingbackend.enums.OperationType;

import java.util.Date;

/**
 * @author pc
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountOperation {
    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    private BankAccount bankAccount;
}
