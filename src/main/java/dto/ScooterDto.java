package dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
public class ScooterDto implements Serializable {

    private Timestamp activeTime;

    private Timestamp offTime;

    private long kilometres;

    private boolean status;

    private String location;

    private long activeScooters;
    private long nonActiveScooters;

    public ScooterDto (Timestamp activeTime, long kilometres, boolean status){
        this.activeTime = activeTime;
        this.kilometres = kilometres;
        this.status = status;
    }

    public ScooterDto (Timestamp activeTime, Timestamp offTime, long kilometres, boolean status){
        this.activeTime = activeTime;
        this.kilometres = kilometres;
        this.offTime = offTime;
        this.status = status;
    }

    public ScooterDto (String location, long kilometres, boolean status){
        this.location = location;
        this.kilometres = kilometres;
        this.status = status;
    }

    public ScooterDto (long activeScooters, long nonActiveScooters){
        this.activeScooters = activeScooters;
        this.nonActiveScooters = nonActiveScooters;
    }
}
