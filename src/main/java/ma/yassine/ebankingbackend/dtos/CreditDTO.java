package ma.yassine.ebankingbackend.dtos;

import lombok.Data;

/**
 * @author pc
 **/
@Data
public class CreditDTO {
    private String accountId;
    private double amount;
    private String description;
}
