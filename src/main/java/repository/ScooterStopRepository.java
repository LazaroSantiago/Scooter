package repository;

import entity.Scooter;
import entity.ScooterStop;
import org.springframework.stereotype.Repository;

@Repository("ScooterStopRepository")
public interface ScooterStopRepository extends BaseRepository<ScooterStop, Long>{

}
