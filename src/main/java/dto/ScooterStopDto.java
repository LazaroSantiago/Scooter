package dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ScooterStopDto implements Serializable {

    private String location;

    public ScooterStopDto(String location){
        this.location = location;
    }
}
