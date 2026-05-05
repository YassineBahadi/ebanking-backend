package ma.yassine.ebankingbackend.dtos;

import lombok.Data;

/**
 * @author pc
 **/
@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private String email;
}
