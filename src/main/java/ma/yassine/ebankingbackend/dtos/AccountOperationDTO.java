package ma.yassine.ebankingbackend.dtos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yassine.ebankingbackend.entities.BankAccount;
import ma.yassine.ebankingbackend.enums.OperationType;

import java.util.Date;

/**
 * @author pc
 **/
@Data
public class AccountOperationDTO {
    private Long id;
    private Date operationDate;
    private double amount;
    private String description;
    private OperationType type;

}
