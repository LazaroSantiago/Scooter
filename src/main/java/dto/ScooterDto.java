package dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class ScooterDto implements Serializable {

    private BigDecimal activeTime;

    private BigDecimal offTime;

    private long kilometres;

    private boolean status;

    private String location;

    private long trips;

    private long activeScooters;
    private long nonActiveScooters;

    public ScooterDto (long trips, long kilometres, boolean status){
        this.trips = trips;
        this.kilometres = kilometres;
        this.status = status;
    }

    public ScooterDto (BigDecimal activeTime, BigDecimal offTime, long kilometres, boolean status){
        this.activeTime = activeTime;
        this.kilometres = kilometres;
        this.offTime = offTime;
        this.status = status;
    }

    public ScooterDto (String location, boolean status){
        this.location = location;
        this.status = status;
    }

    public ScooterDto (long activeScooters, long nonActiveScooters){
        this.activeScooters = activeScooters;
        this.nonActiveScooters = nonActiveScooters;
    }
}
