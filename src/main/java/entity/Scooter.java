package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Data
public class Scooter {
    @Id
    private long id;

    @Column
    private static long normalRate;

    @Column
    private static long extraRate;

    @Column
    private Timestamp activeTime;

    @Column
    private Timestamp offTime;

    @Column
    private long kilometres;

    @Column
    private boolean status;

    @Column
    private String location;
}
