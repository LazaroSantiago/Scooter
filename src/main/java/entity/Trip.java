package entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Trip {
    @Id
    private Long id;

    //id_scooter
    //id_usuario
    @Column
    private long kilometers;
    //startTime
    //endTime
    //paradaInicio
    //paradaFin
    //horaInicio
    //horaFin
}
