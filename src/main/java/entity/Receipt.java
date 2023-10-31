package entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Receipt {
    @Id
    private Long id ;
    @Column
    private long idScooter;
    @Column
    private LocalDate startTime;
    @Column
    private LocalDate endTime;
    @Column
    private long price;
    @Column
    private long kilometres;
}
