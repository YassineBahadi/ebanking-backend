package ma.yassine.ebankingbackend.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.yassine.ebankingbackend.entities.BankAccount;
import ma.yassine.ebankingbackend.entities.CurrentAccount;
import ma.yassine.ebankingbackend.entities.Customer;
import ma.yassine.ebankingbackend.entities.SavingAccount;
import ma.yassine.ebankingbackend.exceptions.CustomerNotFoundException;
import ma.yassine.ebankingbackend.repositories.AccountOperationRepository;
import ma.yassine.ebankingbackend.repositories.BankAccountRepository;
import ma.yassine.ebankingbackend.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author pc
 **/
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class BankAccountServiceImpl implements BankAccountService{

    private CustomerRepository customerRepository;
    private BankAccountRepository bankAccountRepository;
    private AccountOperationRepository accountOperationRepository;

//    Logger log= LoggerFactory.getLogger(this.getClass().getName());

//    public BankAccountServiceImpl(CustomerRepository customerRepository, AccountOperationRepository accountOperationRepository, BankAccountRepository bankAccountRepository) {
//        this.customerRepository = customerRepository;
//        this.accountOperationRepository = accountOperationRepository;
//        this.bankAccountRepository = bankAccountRepository;
//    }

    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("Saving new customer");
        Customer savedCustomer=customerRepository.save(customer);
        return savedCustomer;
    }

    @Override
    public BankAccount saveBankAccount(double initialBalance, String type, Long customerId) throws CustomerNotFoundException {
        Customer customer=customerRepository.findById(customerId).orElse(null);
        if(customer==null){
            throw new CustomerNotFoundException("Customer not found");
        }
        BankAccount bankAccount;
        if(type.equals("current")){
            bankAccount=new CurrentAccount();
        }
        else{
            bankAccount=new SavingAccount();
        }
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        bankAccount.setBalance(initialBalance);


        return null;
    }

    @Override
    public List<Customer> listCustomers() {
        return List.of();
    }

    @Override
    public BankAccount getBankAccount(String accountId) {
        return null;
    }

    @Override
    public void debit(String accountId, double amount, String description) {

    }

    @Override
    public void credit(String accountId, double amount, String description) {

    }

    @Override
    public void transfer(String accountIdSource, String accountIdDestination, double amount) {

    }
}
