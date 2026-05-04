package ma.yassine.ebankingbackend.services;

import ma.yassine.ebankingbackend.entities.BankAccount;
import ma.yassine.ebankingbackend.entities.Customer;
import ma.yassine.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

/**
 * @author pc
 **/
public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    BankAccount saveBankAccount(double initialBalance,String type,Long customerId) throws CustomerNotFoundException;
    List<Customer> listCustomers();
    BankAccount getBankAccount(String accountId);
    void debit(String accountId,double amount,String description);
    void credit(String accountId,double amount,String description);
    void transfer(String accountIdSource,String accountIdDestination,double amount);




}
