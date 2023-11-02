package repository;

import dto.ScooterDto;
import dto.ScooterStopDto;
import entity.Scooter;
import entity.ScooterStop;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ScooterStopRepository")
public interface ScooterStopRepository extends BaseRepository<ScooterStop, Long>{

}
