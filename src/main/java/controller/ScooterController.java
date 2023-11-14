package controller;

import entity.Scooter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ScooterService;

import java.time.LocalDate;

@Controller
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }


    @PutMapping("/inMaintenance/{id}")
    public ResponseEntity<?> registerInMaintenance(@PathVariable long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.registerInMaintenance(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/outMaintenance/{id}")
    public ResponseEntity<?> registerOutMaintenance(@PathVariable long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.registerOutMaintenance(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/report/stopYes")
    public ResponseEntity<?> reportStopYes(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.reportStopYes());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/report/stopNo")
    public ResponseEntity<?> reportStopNo(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.reportStopNo());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/report/activated")
    public ResponseEntity<?> reportFunctionalScooter(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.reportFunctionalScooter());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/report/{lot}/{year}")
    public ResponseEntity<?> reportXTrips(@PathVariable int lot, @PathVariable int year){
        try {
            System.out.println(lot);
            System.out.println(year);
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.reportXTrips(lot, year));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<?> near(@PathVariable String location){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.scooterService.near(location));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/normalRate/{price}")
    public ResponseEntity<?> setNormalRate(@PathVariable long price){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ScooterService.setNormalRate(price));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/extraRate/{price}")
    public ResponseEntity<?> setExtraRate(@PathVariable long price){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ScooterService.setextraRate(price));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/normalRate/")
    public ResponseEntity<?> setNormalRate(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ScooterService.getNormalRate());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/extraRate/")
    public ResponseEntity<?> setExtraRate(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ScooterService.getextraRate());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

}
