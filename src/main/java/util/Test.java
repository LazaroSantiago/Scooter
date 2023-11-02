package util;

import controller.ScooterController;
import controller.ScooterStopController;
import controller.TripController;
import entity.Scooter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test {
    private final ScooterController scooterController;
    private final ScooterStopController scooterStopController;
    private final TripController tripController;

    @Autowired
    public Test(ScooterController scooterController, ScooterStopController scooterStopController, TripController tripController){
        this.scooterController = scooterController;
        this.scooterStopController = scooterStopController;
        this.tripController = tripController;
    }

    public void test() {
        Scooter scooter = new Scooter();
        scooterController.save(scooter);
    }
}
