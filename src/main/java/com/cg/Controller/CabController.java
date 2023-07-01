package com.cg.Controller;

import com.cg.dto.CabDto;
import com.cg.entities.Cab;
import com.cg.exception.CabAlreadyExistsException;
import com.cg.exception.CabNotFoundException;
import com.cg.serviceImpl.ICabServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cabs")
public class CabController {
    @Autowired
    ICabServiceImpl iCabService;

    @PostMapping(value = "/add")
    public ResponseEntity<Object> addNewCab(@RequestBody CabDto cabDto) throws CabAlreadyExistsException{
        return ResponseEntity.ok(iCabService.insertCab(cabDto));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Object> updateCab(@RequestBody CabDto cabDto) throws CabNotFoundException{
        return ResponseEntity.ok(iCabService.updateCab(cabDto));
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> deleteCab(@RequestBody CabDto cabDto) throws CabNotFoundException{
        return ResponseEntity.ok(iCabService.deleteCab(cabDto));
    }

    @GetMapping(value = "/countCabsOfType/{carType}")
    public int countCabsOfType(@RequestBody String carType) throws CabNotFoundException{
        return iCabService.countCabsByType(carType);
    }

    @GetMapping(value="/getCab/{id}")
    public CabDto getCabById(@PathVariable int id) throws CabNotFoundException {
        return iCabService.findByCabId(id);
    }

    @GetMapping({"/cabType/{carType}"})
    public List<Cab> viewAllCabsOfType(@PathVariable String carType) throws CabNotFoundException {
        return this.iCabService.viewCabsOfType(carType);
    }
}
