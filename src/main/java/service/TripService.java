package service;

import entity.Trip;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TripRepository;

import java.util.List;

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

    public List<Long> reportXTrips(int lot, int year) throws Exception {
        try {
            List<Long> result = this.tripRepository.reportXTrips(lot, year);
            return result;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
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
                this.tripRepository.setPrice(id, price);
                return true;
            } else {
                throw new Exception();
            }

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


}
