package ma.yassine.ebankingbackend.services;

import ma.yassine.ebankingbackend.entities.BankAccount;
import ma.yassine.ebankingbackend.entities.CurrentAccount;
import ma.yassine.ebankingbackend.entities.Customer;
import ma.yassine.ebankingbackend.entities.SavingAccount;
import ma.yassine.ebankingbackend.exceptions.BalanceNotSufficientException;
import ma.yassine.ebankingbackend.exceptions.BankAccountNotFoundException;
import ma.yassine.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

/**
 * @author pc
 **/
public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<Customer> listCustomers();
    BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId,double amount,String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId,double amount,String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource,String accountIdDestination,double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;


    List<BankAccount> bankAccountList();
}
