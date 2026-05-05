package ma.yassine.ebankingbackend.dtos;


import lombok.Data;
import ma.yassine.ebankingbackend.enums.AccountStatus;
import java.util.Date;


/**
 * @author pc
 **/
@Data
public class SavingBankAccountDTO extends BankAccountDTO {
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDTO customerDTO;
    private double interestRate;
}
