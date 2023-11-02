package repository;

import dto.ScooterDto;
import entity.Scooter;
import entity.Trip;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("TripRepository")
public interface TripRepository extends BaseRepository<Trip, Long>{

//    Como administrador quiero consultar el total facturado en un rango de meses de cierto año.
    @Query(
            "select sum(t.price)" +
                    " from Trip t " +
                    " where :year = extract(year from t.startTime) and extract(month from t.startTime) between :month1 and :month2"
    )
    Long totalCharged(@Param("month1") int month1, @Param("month2") int month2, @Param("year") int year);

    @Modifying
    @Transactional
    @Query(
            "UPDATE Trip t set t.price = :price where t.id = :id"
    )
    void setPrice(@Param("price") long price, @Param("id") long id);

}
