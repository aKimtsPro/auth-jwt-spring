package be.technifutur.bartholomiche.model.entities;

import java.time.LocalDateTime;
import java.util.List;

import be.technifutur.bartholomiche.model.Enum.ShippingStateEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private long id;
    @Column(name="ordered_at")
    private LocalDateTime orderedAt;
    @Column(name="delivered_at")
    private LocalDateTime deliveredAt;
    private ShippingStateEnum state;
    //  @OneToOne
    //  @JoinColumn(nullable = false)
    // private Panier panier;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
    @ManyToMany
    @JoinTable(name = "shipping_sandwichs", 
    joinColumns = @JoinColumn(name = "shipping_id", referencedColumnName = "id"), 
    inverseJoinColumns = @JoinColumn(name = "sandwich_id", 
    referencedColumnName = "id"))
    private List<Sandwich> sandwiches;
}
