package ma.yassine.ebankingbackend.repositories;

import ma.yassine.ebankingbackend.entities.BankAccount;
import ma.yassine.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pc
 **/
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
