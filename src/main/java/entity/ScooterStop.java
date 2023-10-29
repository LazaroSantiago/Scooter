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
    private Long id;

    @OneToMany
    private Set<Scooter> scooter;

    //coordenada
}
