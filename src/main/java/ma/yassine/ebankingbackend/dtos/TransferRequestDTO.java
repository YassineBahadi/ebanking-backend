package ma.yassine.ebankingbackend.dtos;

import lombok.Data;

/**
 * @author pc
 **/
@Data
public class TransferRequestDTO {
    private String accountSource;
    private String accountDestination;
    private double amount;
    private String description;
}
