package ma.yassine.ebankingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.yassine.ebankingbackend.enums.AccountStatus;

import java.util.Date;
import java.util.List;

/**
 * @author pc
 **/
@Data
@NoArgsConstructor  @AllArgsConstructor
@Entity
public class BankAccount {
    @Id
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;

    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "bankAccount")
    private List<AccountOperation> accountOperations;
}
