package entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ScooterStop {
    @Id
    private Long id;

    //coordenada
}
