package dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class TripDto implements Serializable {

    private long idScooter;

    private long idUser;

    private long kilometres;

    private LocalDate Time;

    private long price;
}
