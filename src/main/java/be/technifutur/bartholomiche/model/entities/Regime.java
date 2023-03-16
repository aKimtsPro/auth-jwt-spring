package be.technifutur.bartholomiche.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Regime {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true)
    private long id;
    private String name;
    private String description;
}
