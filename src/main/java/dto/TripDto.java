package dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TripDto {

    private long idScooter;

    private long idUser;

    private long kilometres;

    private LocalDate Time;

    private long price;
}
