package dto;

import lombok.Data;

@Data
public class CantidadDeScooters {

    private long activeScooters;
    private long nonActiveScooters;

    public CantidadDeScooters (long activeScooters, long nonActiveScooters){
        this.activeScooters = activeScooters;
        this.nonActiveScooters = nonActiveScooters;
    }
}
