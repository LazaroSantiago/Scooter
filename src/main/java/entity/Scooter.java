package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Scooter {
    @Id
    private Long id;
    //ubicacion
    //tiempo de uso
    //kms totales
    //get(tiempo uso con pausas)
    //get(tiempo uso sin pausas)
    private char status;
}
