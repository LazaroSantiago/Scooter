package service;

import dto.ScooterStopDto;
import entity.Scooter;
import entity.ScooterStop;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ScooterStopRepository;

import java.util.List;
import java.util.Optional;

@Service("ScooterStopService")
public class ScooterStopService implements BaseService<ScooterStop>{

    @Autowired
    private ScooterStopRepository SStopRepository;

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            if (this.SStopRepository.existsById(id)){
                this.SStopRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public ScooterStop save(ScooterStop entity) throws Exception {
        try {
            return this.SStopRepository.save(entity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public ScooterStop findById(Long id) throws Exception {
        try{
            Optional<ScooterStop> result = SStopRepository.findById(id);
            return result.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

//    public List<ScooterStopDto> near(String location) throws Exception {
//        try {
//            return this.SStopRepository.near(location);
//        }catch (Exception e){
//            throw new Exception(e.getMessage());
//        }
//    }
}
