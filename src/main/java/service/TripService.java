package service;

import entity.Scooter;
import entity.ScooterStop;
import entity.Trip;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TripRepository;

import java.util.List;
import java.util.Optional;

@Service("TripService")
public class TripService implements BaseService<Trip>{

    @Autowired
    private TripRepository tripRepository;

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if (this.tripRepository.existsById(id)){
                tripRepository.deleteById(id);
                return true;
            }else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Trip save(Trip entity) throws Exception {
        try {
            return this.tripRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Trip findById(Long id) throws Exception {
        try{
            Optional<Trip> result = tripRepository.findById(id);
            return result.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    public long totalCharged(int month1, int month2, int year) throws Exception {
        try {
            return this.tripRepository.totalCharged(month1,month2,year);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean setPrice(long id, long price) throws Exception {
        try {
            if (this.tripRepository.existsById(id)){
                this.tripRepository.setPrice(price, id);
                return true;
            } else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
