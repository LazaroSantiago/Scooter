package controller;

import entity.Trip;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.TripService;

@Controller
@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping("")
    @Operation(summary = "Crea un nuevo viaje")
    public ResponseEntity<?> save(@RequestBody Trip entity){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.tripService.save(entity));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un viaje por id")
    public ResponseEntity<?> delete(@PathVariable long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.tripService.delete(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/{month1}/{month2}/{year}")
    public ResponseEntity<?> totalCharged(@PathVariable int month1, @PathVariable int month2, @PathVariable int year){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.tripService.totalCharged(month1, month2, year));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/{id}/{price}")
    public ResponseEntity<?> setPrice (@PathVariable int id, @PathVariable int price){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.tripService.setPrice(id, price));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

}
