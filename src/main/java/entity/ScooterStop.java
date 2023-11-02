package entity;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class ScooterStop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Name("stop_id")
    private Long stop_id;
    @Column
    private String location;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "stop", cascade = CascadeType.ALL)
    private Set<Scooter> scooter;

    public ScooterStop(Long stop_id, String location){
        this.stop_id=stop_id;
        this.location=location;
    }

    public ScooterStop() {

    }
}
