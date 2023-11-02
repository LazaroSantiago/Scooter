package util;

import controller.ScooterController;
import controller.ScooterStopController;
import controller.TripController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import entity.Scooter;
import entity.ScooterStop;
import entity.Trip;

@Component
public class Test {

    private final ScooterController ScooterController;
    private final ScooterStopController ScooterStopController;
    private final TripController TripController;

    @Autowired
    public Test(ScooterController ScooterController, controller.ScooterStopController scooterStopController, controller.TripController tripController) {
        this.ScooterController = ScooterController;
        this.ScooterStopController = scooterStopController;
        this.TripController = tripController;
    }

    public void testScooter() {
//        ScooterStop g = new ScooterStop(1L,"tandil");
//        ScooterStop h = new ScooterStop(2L,"azul");
//        ScooterStopController.save(g);
//        ScooterStopController.save(h);
//        Scooter a = new Scooter(5 , new Timestamp(1000), new Timestamp(1000), 1000, true, "tandil");
//        Scooter b = new Scooter(6 , new Timestamp(1000), new Timestamp(0), 1000, false, "tandil");
//        Scooter c = new Scooter(7 , new Timestamp(1000), new Timestamp(1000), 1000, true, "azul");
//        Scooter d = new Scooter(8 , new Timestamp(1000), new Timestamp(0), 1000, false, "azul");
//        ScooterController.save(a);
//        ScooterController.save(b);
//        ScooterController.save(c);
//        ScooterController.save(d);
//        Trip e = new Trip(1,5,1,1,10,100,2,new Timestamp(100), new Timestamp(100), new Timestamp(200));
//        Trip f = new Trip(1,5,2,1,10,100,1,new Timestamp(0), new Timestamp(100), new Timestamp(200));
//        TripController.save(e);
//        TripController.save(f);
    }
}
