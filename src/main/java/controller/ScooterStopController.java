package controller;

import entity.ScooterStop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ScooterStopService;

@RestController
@RequestMapping("/ScooterStop")
public class ScooterStopController {

    @Autowired
    private ScooterStopService SStopService;

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody ScooterStop entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(SStopService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(@RequestBody ScooterStop entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(SStopService.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
        }
    }

//    @GetMapping("{location}")
//    public ResponseEntity<?> reportStopYes(@PathVariable String location){
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(SStopService.near(location));
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
//        }
//    }
}
