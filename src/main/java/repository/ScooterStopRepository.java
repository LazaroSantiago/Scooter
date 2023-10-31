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

//    Como usuario quiero lun listado de los monopatines cercanos a mi zona,
//    para poder encontrar un monopatín cerca de mi ubicación
    @Query(
            "select new dto.ScooterStopDto(ss.location) " +
                    "from Scooter s inner join ScooterStop ss on s.stop.id = ss.id" +
                    " where ss.location like :location and s.status = TRUE " +
                    " group by ss.id " +
                    " having count(ss.id) > 0 "
    )
    List<ScooterStopDto> near(@Param("location") String location);
}
