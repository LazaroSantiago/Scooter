package repository;

import entity.Scooter;
import entity.Trip;
import org.springframework.stereotype.Repository;

@Repository("TripRepository")
public interface TripRepository extends BaseRepository<Trip, Long>{

}
