package be.technifutur.bartholomiche.form;

import be.technifutur.bartholomiche.model.entities.Regime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegimeInsertForm {
    private long id;
    @NotBlank
    private String name;
    private String description;


}
