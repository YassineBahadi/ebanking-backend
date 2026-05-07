package ma.yassine.ebankingbackend.repositories;

import ma.yassine.ebankingbackend.entities.AccountOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author pc
 **/
public interface AccountOperationRepository extends JpaRepository<AccountOperation,Long> {
     List<AccountOperation> findByBankAccountId(String accountId);

     Page<AccountOperation> findByBankAccountIdOrderByOperationDateDesc(String bankAccountId, Pageable pageable);
}
