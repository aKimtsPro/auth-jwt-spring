package be.technifutur.bartholomiche.model.entities;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter

public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToMany
    @JoinTable(name = "panier_sandwichs", 
      joinColumns = @JoinColumn(name = "panier_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "sandwich_id", 
      referencedColumnName = "id"))
    private List<Sandwich> sandwiches = new ArrayList<>();
}
