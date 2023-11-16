package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Name("scooter")
public class Scooter {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private static long normalRate;
    @Column
    private static long extraRate;
    @Column
    @Name("status")
    private boolean status;
    @Column
    @Name("location")
    private String location;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @JsonBackReference
    private ScooterStop stop;

    public static void setNormalRate(long normalRate){
        Scooter.normalRate = normalRate;
    }

    public static void setExtraRate(long extraRate){
        Scooter.extraRate = extraRate;
    }
    public static long getNormalRate(){
        return normalRate;
    }

    public static long getExtraRate(){
        return extraRate;
    }

    public Scooter(long id, boolean status,String location){
        this.id=id;
        this.location= location;
        this.status=status;
    }

    public Scooter(long id, boolean status,String location, ScooterStop stop){
        this.id=id;
        this.location= location;
        this.status=status;
        this.stop=stop;
    }

    public Scooter() {}
}
