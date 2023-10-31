package entity;
import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
public class ScooterStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String location;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "stop", cascade = CascadeType.ALL)
    private Set<Scooter> scooter;


    //coordenada
}
