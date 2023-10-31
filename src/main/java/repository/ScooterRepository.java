package repository;

import dto.ScooterDto;
import entity.Scooter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository("ScooterRepository")
public interface ScooterRepository extends BaseRepository<Scooter, Long>{

//    Registrar monopatín en mantenimiento (debe marcarse como no disponible para su uso)
    @Query(
            " update Scooter s set s.status = false where s.id = :id "
    )
    void registerInMaintenance(@Param("id") long id);

//    Registrar fin de mantenimiento de monopatín
    @Query(
            " update Scooter s set s.status = true where s.id = :id "
    )
    void registerOutOfMaintenance(@Param("id") long id);

//    Generar reporte de uso de monopatines por tiempo con pausas
    @Query(
            "select s from Scooter s inner join Trip t on s.id = t.idScooter where t.offTime > :ceroTime order by t.offTime desc"
    )
    List<Scooter> reportWithStop(@Param("ceroTime") Timestamp ceroTime);

//    Generar reporte de uso de monopatines por tiempo sin pausas
    @Query(
            "select s from Scooter s inner join Trip t on s.id = t.idScooter where t.offTime <= :ceroTime"
    )
    List<Scooter> reportWithNoStop(@Param("ceroTime") Timestamp ceroTime);

//    Como administrador quiero consultar la cantidad de monopatines actualmente en operación,
//    versus la cantidad de monopatines actualmente en mantenimiento.
    @Query(
            "select new dto.ScooterDto(SUM(CASE WHEN s.status = true THEN 1 ELSE 0 END),  SUM(CASE WHEN s.status = false THEN 1 ELSE 0 END)) " +
                    "from Scooter s"
    )
    List<ScooterDto> functionalScooter();


}
