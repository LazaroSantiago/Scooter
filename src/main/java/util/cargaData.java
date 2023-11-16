package util;

import controller.ScooterController;
import controller.ScooterStopController;
import controller.TripController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import entity.Scooter;
import entity.ScooterStop;
import entity.Trip;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class cargaData {

    private final ScooterController ScooterController;
    private final ScooterStopController ScooterStopController;
    private final TripController TripController;

    @Autowired
    public cargaData(ScooterController ScooterController, ScooterStopController scooterStopController, TripController tripController) {
        this.ScooterController = ScooterController;
        this.ScooterStopController = scooterStopController;
        this.TripController = tripController;
    }

    public void carga() {
        ScooterStop ss1 = new ScooterStop(1L,"tandil");
        ScooterStop ss2 = new ScooterStop(2L,"azul");
        ScooterStop ss3 = new ScooterStop(3L, "tandil");
        ScooterStop ss4 = new ScooterStop(4L, "azul");
        ScooterStopController.save(ss1);
        ScooterStopController.save(ss2);
        ScooterStopController.save(ss3);
        ScooterStopController.save(ss4);

        ScooterController.save(new Scooter(1,true, "tandil", ss1));
        ScooterController.save(new Scooter(2,true, "tandil", ss3));
        ScooterController.save(new Scooter(3,false, "tandil", ss1));
        ScooterController.save(new Scooter(4,true, "tandil", ss3));
        ScooterController.save(new Scooter(5,false, "tandil", ss1));
        ScooterController.save(new Scooter(6,true, "azul", ss2));
        ScooterController.save(new Scooter(7,false, "azul", ss4));
        ScooterController.save(new Scooter(8,true, "azul", ss2));
        ScooterController.save(new Scooter(9,false, "azul", ss4));
        ScooterController.save(new Scooter(10,true, "azul", ss2));
        ScooterController.save(new Scooter(11,false, "tandil", ss3));
        ScooterController.save(new Scooter(12,false, "tandil", ss1));
        ScooterController.save(new Scooter(13,true, "azul", ss4));
        ScooterController.save(new Scooter(14,false, "azul", ss2));

        TripController.save(new Trip(1,1,1,1,10,100,2,new Timestamp(0), new Timestamp(0), new Timestamp(0)));
        TripController.save(new Trip(2, 14, 3, 2, 15, 120, 2, new Timestamp(31525200), new Timestamp(31525200), new Timestamp(38525200)));
        TripController.save(new Trip(3, 6, 1, 3, 20, 80, 3, new Timestamp(31525200), new Timestamp(31525200), new Timestamp(37525200)));
        TripController.save(new Trip(4, 3, 5, 4, 12, 150, 1, new Timestamp(0), new Timestamp(31525200), new Timestamp(36525200)));
        TripController.save(new Trip(5, 12, 4, 1, 18, 90, 4, new Timestamp(31525200), new Timestamp(31525200), new Timestamp(32525200)));
        TripController.save(new Trip(6, 7, 2, 2, 25, 110, 2, new Timestamp(31525200), new Timestamp(31525200), new Timestamp(34525200)));
        TripController.save(new Trip(7, 2, 3, 3, 14, 130, 3, new Timestamp(31525200), new Timestamp(31525200), new Timestamp(32525200)));
        TripController.save(new Trip(8, 11, 5, 4, 22, 70, 4, new Timestamp(31525200), new Timestamp(31525200), new Timestamp(39525200)));
        TripController.save(new Trip(9, 4, 1, 1, 17, 100, 1, new Timestamp(0), new Timestamp(31525200), new Timestamp(32525200)));
        TripController.save(new Trip(10, 13, 2, 2, 19, 85, 2, new Timestamp(31525200), new Timestamp(38525200), new Timestamp(42525200)));
        TripController.save(new Trip(11, 10, 4, 3, 16, 120, 3, new Timestamp(31525200), new Timestamp(39525200), new Timestamp(42525200)));
        TripController.save(new Trip(12,5,2,1,10,100,1,new Timestamp(0), new Timestamp(31525200), new Timestamp(31525200)));
        TripController.save(new Trip(13, 9, 1, 1, 17, 100, 1, new Timestamp(0), new Timestamp(31525200), new Timestamp(32525200)));
        TripController.save(new Trip(14, 8, 2, 2, 19, 85, 2, new Timestamp(31525200), new Timestamp(38525200), new Timestamp(42525200)));

    }
}
