package dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class ScooterDto {

    private int activeTime;

    private int offTime;

    private long kilometres;

    private boolean status;

    private String location;

    private long activeScooters;
    private long nonActiveScooters;

    public ScooterDto (int activeTime, long kilometres, boolean status){
        this.activeTime = activeTime;
        this.kilometres = kilometres;
        this.status = status;
    }

    public ScooterDto (int activeTime, int offTime, long kilometres, boolean status){
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
