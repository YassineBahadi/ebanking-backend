package ma.yassine.ebankingbackend.dtos;

import lombok.Data;

import java.util.List;

/**
 * @author pc
 **/
@Data
public class AccountHistoryDTO {
    private String accountId;
    private double balance;
    private int currentPage;
    private int totalPages;
    private int pageSize;
    private List<AccountOperationDTO> accountOperationDTOS;
}
