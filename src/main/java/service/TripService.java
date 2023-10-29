package service;

import entity.Trip;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TripRepository;

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
}
