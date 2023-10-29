package service;

import dto.ScooterDto;
import entity.Scooter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ScooterRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service("ScooterService")
public class ScooterService implements BaseService<Scooter>{
    private static long NormalRate = 0;
    private static long ExtraRate = 0;
    @Autowired
    private ScooterRepository scooterRepository;

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

    public boolean registerInMaintenance(long id) throws Exception {
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

    public boolean registerOutMaintenance(long id) throws Exception {
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

    public List<ScooterDto> reportPerKilometer() throws Exception {
        try {
            var result = this.scooterRepository.reportPerKilometer();
            return result.stream().map(Scooter -> new ScooterDto((int)(Scooter.getActiveTime().getTime()/1000), (int)(Scooter.getOffTime().getTime()/1000), Scooter.getKilometres(), Scooter.isStatus())).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<ScooterDto> reportTimeStopYes() throws Exception {
        try {
            Timestamp ceroTime = new Timestamp(0);
            var result = this.scooterRepository.reportTimeWithStop(ceroTime);
            return result.stream().map(Scooter -> new ScooterDto((int)(Scooter.getActiveTime().getTime()/1000),
                    (int)(Scooter.getOffTime().getTime()/1000),
                    Scooter.getKilometres(),
                    Scooter.isStatus())).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public List<ScooterDto> reportTimeStopNo() throws Exception {
        try {
            Timestamp ceroTime = new Timestamp(0);
            var result = this.scooterRepository.reportTimeWithNoStop(ceroTime);
            return result.stream().map(Scooter -> new ScooterDto((int)(Scooter.getActiveTime().getTime()/1000),
                    (int)(Scooter.getOffTime().getTime()/1000),
                    Scooter.getKilometres(),
                    Scooter.isStatus())).collect(Collectors.toList());
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

//    ADMIN

    public List<ScooterDto> reportFunctionalScooter() throws Exception {
        try {
            return this.scooterRepository.functionalScooter();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

//    Como administrador quiero hacer un ajuste de precios, y que a partir de cierta fecha el sistema
//    habilite los nuevos precios.
    public static boolean setNormalRate(long NormalRat){
        NormalRate = NormalRat;
        return true;
    }

    public static boolean setextraRate(long extraRat){
        ExtraRate = extraRat;
        return true;
    }

//    public static boolean setNormalRate(long NormalRat, long ExtraRate, LocalDate date){
//        try {
//            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//            long now = System.currentTimeMillis();
//            long tiempoHastaFechaDeseada = date.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
//            long totalTime = tiempoHastaFechaDeseada - now;
//            scheduler.schedule(new Rate(NormalRat, ExtraRate), totalTime, TimeUnit.MILLISECONDS);
//            NormalRate = NormalRat;
//        }
//
//        return true;
//    }
//
//    static class Rate implements Runnable {
//        private static long normalRate;
//        private static long extraRate;
//        public Rate (long normalRat, long extraRat){
//            normalRate = normalRat;
//            extraRate = extraRat;
//        }
//        @Override
//        public void run() {
//            NormalRate = normalRate;
//            ExtraRate = extraRate;
//        }
//    }
}
