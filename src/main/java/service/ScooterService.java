package service;

import dto.ScooterDto;
import dto.ScooterStopDto;
import entity.Scooter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ScooterRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("ScooterService")
public class ScooterService implements BaseService<Scooter>{

    @Autowired
    private ScooterRepository scooterRepository;

    @Autowired
    private TripService TripService;

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(this.scooterRepository.existsById(id)){
                this.scooterRepository.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Scooter save(Scooter entity) throws Exception {
        try {
            return this.scooterRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Scooter findById(Long id) throws Exception {
        try{
            Optional<Scooter> result = scooterRepository.findById(id);
            return result.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean registerInMaintenance(Long id) throws Exception {
        try {
            if (this.scooterRepository.existsById(id)){
                this.scooterRepository.registerInMaintenance(id);
                return true;
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean registerOutMaintenance(Long id) throws Exception {
        try {
            if (this.scooterRepository.existsById(id)){
                this.scooterRepository.registerOutOfMaintenance(id);
                return true;
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<ScooterDto> reportStopYes() throws Exception {
        try {
            var result = this.scooterRepository.reportWithStop();
            return result.stream().map(Scooter -> new ScooterDto(
                    Scooter.getActiveTime(),
                    Scooter.getOffTime(),
                    Scooter.getKilometres(),
                    Scooter.isStatus())).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<ScooterDto> reportStopNo() throws Exception {
        try {
            var result = this.scooterRepository.reportWithNoStop();
            return result.stream().map(Scooter -> new ScooterDto(
                    Scooter.getActiveTime(),
                    Scooter.getOffTime(),
                    Scooter.getKilometres(),
                    Scooter.isStatus())).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<ScooterDto> reportXTrips(int lot, int year) throws Exception {
        try {
            var result = this.scooterRepository.reportXTrips(lot, year);
            return result.stream().map(Scooter -> new ScooterDto(
                    Scooter.getActiveTime(),
                    Scooter.getOffTime(),
                    Scooter.getKilometres(),
                    Scooter.isStatus())).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<ScooterDto> near(String location) throws Exception {
        try {
            var result = this.scooterRepository.near(location);
            return result.stream().map(Scooter -> new ScooterDto(
                    Scooter.getLocation(),
                    Scooter.getKilometres(),
                    Scooter.isStatus())).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<ScooterDto> reportFunctionalScooter() throws Exception {
        try {
            return this.scooterRepository.functionalScooter();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

//    Como administrador quiero hacer un ajuste de precios, y que a partir de cierta fecha el sistema
//    habilite los nuevos precios.
    public static boolean setNormalRate(long normalRate){
        Scooter.setNormalRate(normalRate) ;
        return true;
    }

    public static boolean setextraRate(long extraRate){
        Scooter.setExtraRate(extraRate);
        return true;
    }

    public static Long getNormalRate(){
        return Scooter.getNormalRate();
    }

    public static Long getextraRate(){
        return Scooter.getExtraRate();
    }
}
