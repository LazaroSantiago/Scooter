package entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class ScooterStop {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String location;

    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "stop", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Scooter> scooter;

    public ScooterStop(Long stop_id, String location){
        this.id=stop_id;
        this.location=location;
    }

    public ScooterStop() {}
}
