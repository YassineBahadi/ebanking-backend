package ma.yassine.ebankingbackend.services;

import ma.yassine.ebankingbackend.entities.BankAccount;
import ma.yassine.ebankingbackend.entities.CurrentAccount;
import ma.yassine.ebankingbackend.entities.SavingAccount;
import ma.yassine.ebankingbackend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author pc
 **/
@Service
@Transactional
public class BankService {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    public void consulter(){
        BankAccount bankAccount=bankAccountRepository.findById("2e384230-7bb0-4da7-a351-496837dee3b8").orElse(null);
        if(bankAccount!=null){
            System.out.println("§y§y§y§y§y§y§y§y§y§y§y§y§y§y§y§y§y§y§y§y§y§y");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            System.out.println(bankAccount.getClass().getSimpleName());
            if(bankAccount instanceof CurrentAccount){
                System.out.println("Over draft=>"+((CurrentAccount)bankAccount).getOverDraft());
            }
            else if(bankAccount instanceof SavingAccount){
                System.out.println("Interest Rate=>"+((SavingAccount)bankAccount).getInterestRate());
            }
            bankAccount.getAccountOperations().forEach(op->{
                System.out.println(op.getOperationDate()+"***\t***"+op.getType()+"***\t***"+op.getAmount());
            });
        }
    }
}
