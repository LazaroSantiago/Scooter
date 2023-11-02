package repository;

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
            "select s from Scooter s inner join Trip t on s.id = t.idScooter where UNIX_TIMESTAMP(t.offTime) > 0 order by t.offTime desc"
    )
    List<Scooter> reportWithStop();

//    Generar reporte de uso de monopatines por tiempo sin pausas
    @Query(
            "select s from Scooter s inner join Trip t on s.id = t.idScooter where UNIX_TIMESTAMP(t.offTime) = 0"
    )
    List<Scooter> reportWithNoStop();

//    Como administrador quiero consultar la cantidad de monopatines actualmente en operación,
//    versus la cantidad de monopatines actualmente en mantenimiento.
    @Query(
            "select new dto.ScooterDto(SUM(CASE WHEN s.status = true THEN 1 ELSE 0 END),  SUM(CASE WHEN s.status = false THEN 1 ELSE 0 END)) " +
                    "from Scooter s"
    )
    List<ScooterDto> functionalScooter();

    //    Como administrador quiero consultar los monopatines con más de X viajes en un cierto año.
    @Query(
            "select s from  Scooter s " +
                    "where :lot < (select count(*) from Trip t where t.id = s.id " +
                    "and extract(year from t.startTime) = :year group by  t.id)"
    )
    List<Scooter> reportXTrips(@Param("lot") int lot, @Param("year") int year);

    //    Como usuario quiero lun listado de los monopatines cercanos a mi zona,
//    para poder encontrar un monopatín cerca de mi ubicación
    @Query(
            "select s " +
                    "from Scooter s inner join ScooterStop ss on s.stop.stop_id = ss.stop_id" +
                    " where ss.location like :location and s.status = TRUE "
    )
    List<Scooter> near(@Param("location") String location);

}
