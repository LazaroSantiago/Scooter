package entity;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Data
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private long idScooter;
    @Column
    private long idUser;
    @Column
    private long kilometres;
    @Column
    private LocalDate startTime;
    @Column
    private LocalDate endTime;
    @Column
    private long price;
    @Column
    private Timestamp offTime;

    private long idStartStop;

    private long idEndStop;
}
