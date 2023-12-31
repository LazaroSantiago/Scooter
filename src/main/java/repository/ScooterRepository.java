package repository;

import dto.CantidadDeScooters;
import dto.ScooterDto;
import dto.ScooterStopDto;
import entity.Scooter;
import entity.Trip;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository("ScooterRepository")
public interface ScooterRepository extends BaseRepository<Scooter, Long>{

//    Registrar monopatín en mantenimiento (debe marcarse como no disponible para su uso)
    @Modifying
    @Transactional
    @Query(
            " update Scooter s set s.status = false where s.id = :id "
    )
    void registerInMaintenance(@Param("id") long id);

//    Registrar fin de mantenimiento de monopatín
    @Modifying
    @Transactional
    @Query(
            " update Scooter s set s.status = true where s.id = :id "
    )
    void registerOutOfMaintenance(@Param("id") Long id);

//    Generar reporte de uso de monopatines por tiempo con pausas
    @Query(
            "select new dto.ScooterDto(s.id, sum(UNIX_TIMESTAMP(t.offTime)), count(t.kilometres), s.status, s.location) " +
                    " from Scooter s inner join Trip t on s.id = t.idScooter " +
                    " group by s.id " +
                    " having sum(unix_timestamp(t.offTime)) > 0 " +
                    "order by sum(unix_timestamp(t.offTime)) desc"
    )
    List<ScooterDto> reportWithStop();

//    Generar reporte de uso de monopatines por tiempo sin pausas
    @Query(
            "select new dto.ScooterDto(s.id, sum(UNIX_TIMESTAMP(t.offTime)), count(t.kilometres), s.status, s.location) " +
                    " from Scooter s inner join Trip t on s.id = t.idScooter " +
                    " group by s.id " +
                    " having sum(unix_timestamp(t.offTime)) = 0 "
    )
    List<ScooterDto> reportWithNoStop();

//    Como administrador quiero consultar la cantidad de monopatines actualmente en operación,
//    versus la cantidad de monopatines actualmente en mantenimiento.
    @Query(
            "select new dto.CantidadDeScooters(SUM(CASE WHEN s.status = true THEN 1 ELSE 0 END),  SUM(CASE WHEN s.status = false THEN 1 ELSE 0 END)) " +
                    "from Scooter s"
    )
    CantidadDeScooters functionalScooter();

    //    Como administrador quiero consultar los monopatines con más de X viajes en un cierto año.
    @Query(
            "select new dto.ScooterDto(s.id, sum(UNIX_TIMESTAMP(t.offTime)), count(t.kilometres), s.status, s.location)  " +
                    " from Scooter s inner join Trip t on s.id = t.idScooter " +
                    " where extract(year from t.startTime) = :year " +
                    " group by s.id " +
                    " having count(t.id) > :lot "
    )
    List<ScooterDto> reportXTrips(@Param("lot") int lot, @Param("year") int year);

    //    Como usuario quiero lun listado de los monopatines cercanos a mi zona,
//    para poder encontrar un monopatín cerca de mi ubicación
    @Query(
            "select s " +
                    "from Scooter s inner join ScooterStop ss on s.stop.id = ss.id" +
                    " where ss.location like :location and s.status = TRUE "
    )
    List<Scooter> near(@Param("location") String location);

}
