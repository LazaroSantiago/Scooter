package controller;

import entity.Scooter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ScooterService;

import java.time.LocalDate;

@RestController
@RequestMapping("/scooter")
public class ScooterController {

    @Autowired
    private ScooterService scooterService;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Scooter entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestBody Scooter entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }


    @PutMapping("/InMaintenance/{id}")
    public ResponseEntity<?> registerInMaintenance(@PathVariable long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.registerInMaintenance(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/OutMaintenance/{id}")
    public ResponseEntity<?> registerOutMaintenance(@PathVariable long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.registerOutMaintenance(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/PerKilometer")
    public ResponseEntity<?> reportPerKilometer(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.reportPerKilometer());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/StopYes")
    public ResponseEntity<?> reportTimeStopYes(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.reportTimeStopYes());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/StopNo")
    public ResponseEntity<?> reportTimeStopNo(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.reportTimeStopNo());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

//    ADMIN

//    http://tuaplicacion.com/api/productos?fechaLanzamiento=2023-11-01
    @PutMapping("/NormalRate/{price}")
    public ResponseEntity<?> setNormalRate(@PathVariable long price/*, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate fecha*/){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.setNormalRate(price));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/extraRate/{price}")
    public ResponseEntity<?> setExtraRate(@PathVariable long price){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.setextraRate(price));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

}
