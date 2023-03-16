package be.technifutur.bartholomiche.model.DTO;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UserDTO {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private long panierId;
    private List<Long> shippingId;
}

