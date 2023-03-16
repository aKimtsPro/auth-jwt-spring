package be.technifutur.bartholomiche.form;

import be.technifutur.bartholomiche.model.entities.Panier;
import be.technifutur.bartholomiche.model.entities.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserInsertForm {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    //@Pattern( regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;

    
    public User toEntity(){
        User entity = new User();
        entity.setEmail(email);
        entity.setUsername(username);
        entity.setFirstName(firstName);
        entity.setLastName(lastName);
        entity.setPassword(password);
        return entity;
    }
}
