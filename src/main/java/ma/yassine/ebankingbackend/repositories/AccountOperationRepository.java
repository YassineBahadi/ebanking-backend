package ma.yassine.ebankingbackend.repositories;

import ma.yassine.ebankingbackend.entities.AccountOperation;
import ma.yassine.ebankingbackend.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pc
 **/
public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
}
