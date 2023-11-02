package entity;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Name("scooter")
public class Scooter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Name("activeTime")
    private Timestamp activeTime;

    @Column
    @Name("offTime")
    private Timestamp offTime;

    @Column
    @Name("kilometres")
    private long kilometres;

    @Column
    @Name("status")
    private boolean status;

    @Column
    @Name("location")
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stop_id")
    private ScooterStop stop;

    public Scooter(long id, Timestamp activeTime,
                   Timestamp offTime, long kilometres,
                   boolean status,String location){
        this.id=id;
        this.offTime= offTime;
        this.location= location;
        this.kilometres=kilometres;
        this.activeTime=activeTime;
        this.status=status;
    }

    public Scooter() {

    }
}
