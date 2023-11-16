package controller;

import entity.ScooterStop;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ScooterStopService;

@Controller
@RestController
@RequestMapping("/ScooterStop")
public class ScooterStopController {

    @Autowired
    private ScooterStopService SStopService;

    @PostMapping("")
    @Operation(summary = "Crea una nueva parada de scooters")
    public ResponseEntity<?> save(@RequestBody ScooterStop entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(SStopService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina una parada de scooters")
    public ResponseEntity<?> delete(@PathVariable long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(SStopService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }
}
