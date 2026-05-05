package ma.yassine.ebankingbackend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.yassine.ebankingbackend.dtos.CustomerDTO;
import ma.yassine.ebankingbackend.entities.Customer;
import ma.yassine.ebankingbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author pc
 **/
@RestController
@AllArgsConstructor
@Slf4j
//@RequestMapping("/customers")
public class CustomerRestController {
    private BankAccountService bankAccountService;
    @GetMapping("/customers")
    public List<CustomerDTO> customers(){
        return bankAccountService.listCustomers();
    }
}
