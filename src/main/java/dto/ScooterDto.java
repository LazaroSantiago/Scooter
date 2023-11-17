package dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class ScooterDto implements Serializable {

    private long id;

    private BigDecimal offTime;

    private long kilometres;

    private boolean status;

    private String location;

    public ScooterDto(long id, BigDecimal offTime, long kilometres, boolean status, String location) {
        this.id = id;
        this.offTime = offTime;
        this.kilometres = kilometres;
        this.status = status;
        this.location = location;
    }

    public ScooterDto (long id){
        this.id = id;
    }


}
