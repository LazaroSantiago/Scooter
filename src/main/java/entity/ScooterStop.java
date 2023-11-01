package entity;

import jakarta.persistence.*;
import lombok.Data;

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

}
