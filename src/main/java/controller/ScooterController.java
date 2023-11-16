package controller;

import entity.Scooter;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Crea un nuevo scooter")
    public ResponseEntity<?> save(@RequestBody Scooter entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un scooter por id")
    public ResponseEntity<?> delete(@PathVariable long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("")
    @Operation(summary = "Obtener todos los scooters")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un scooter por id")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }


    @PutMapping("/inMaintenance/{id}")
    @Operation(summary = "Registrar un scooter en mantenimiento por id")
    public ResponseEntity<?> registerInMaintenance(@PathVariable long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.registerInMaintenance(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/outMaintenance/{id}")
    @Operation(summary = "Registrar un scooter fuera de mantenimiento por id")
    public ResponseEntity<?> registerOutMaintenance(@PathVariable long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.registerOutMaintenance(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/report/stopYes")
    @Operation(summary = "Obtener un scooter con parada durante algun viaje")
    public ResponseEntity<?> reportStopYes(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.reportStopYes());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/report/stopNo")
    @Operation(summary = "Obtener un scooter sin parada durante algun viaje")
    public ResponseEntity<?> reportStopNo(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.reportStopNo());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/report/activated")
    @Operation(summary = "Obtener reporte de scooters activos y no activos")
    public ResponseEntity<?> reportFunctionalScooter(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(scooterService.reportFunctionalScooter());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/report/{lot}/{year}")
    @Operation(summary = "Obtener reporte de scooters con mas de X viajes en un año")
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
    @Operation(summary = "Obtener scooters cercanos")
    public ResponseEntity<?> near(@PathVariable String location){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.scooterService.near(location));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/normalRate/{price}")
    @Operation(summary = "Setea el precio normal del scooter")
    public ResponseEntity<?> setNormalRate(@PathVariable long price){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ScooterService.setNormalRate(price));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @PutMapping("/extraRate/{price}")
    @Operation(summary = "Setea el precio extra del scooter ante un descanzo en el viaje ")
    public ResponseEntity<?> setExtraRate(@PathVariable long price){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ScooterService.setextraRate(price));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/normalRate/")
    @Operation(summary = "Obtener el precio normal del scooter")
    public ResponseEntity<?> getNormalRate(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ScooterService.getNormalRate());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @GetMapping("/extraRate/")
    @Operation(summary = "Obtener el precio extra del scooter")
    public ResponseEntity<?> getExtraRate(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ScooterService.getextraRate());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

}
