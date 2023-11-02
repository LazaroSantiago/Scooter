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
    private long idStartStop;
    @Column
    private long kilometres;
    @Column
    private Timestamp startTime;
    @Column
    private Timestamp endTime;
    @Column
    private long price;
    @Column
    private Timestamp offTime;
    @Column
    private long idEndStop;

    public Trip(long id,long idScooter,
                long idUser,long idStartStop,
                long kilometres,long price,
                long idEndStop, Timestamp offTime,
                Timestamp startTime, Timestamp endTime){
        this.id=id;
        this.endTime=endTime;
        this.idEndStop=idEndStop;
        this.kilometres=kilometres;
        this.startTime=startTime;
        this.idStartStop=idStartStop;
        this.idUser=idUser;
        this.idScooter=idScooter;
        this.price=price;this.offTime = offTime;
    }

    public Trip() {

    }
}
