package controller;

import entity.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.TripService;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Trip entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.tripService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> dalete(@RequestBody long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.tripService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }
}
