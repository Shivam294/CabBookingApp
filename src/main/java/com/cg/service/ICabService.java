package com.cg.service;

import com.cg.dto.CabDto;
import com.cg.entities.Cab;
import com.cg.exception.CabAlreadyExistsException;
import com.cg.exception.CabNotFoundException;

import java.util.List;

public interface ICabService {
    CabDto insertCab(CabDto cabDto) throws CabAlreadyExistsException;
    CabDto updateCab(CabDto cabDto) throws CabNotFoundException;
    int countCabsByType(String carType) throws CabNotFoundException;
    CabDto findByCabId(int id) throws CabNotFoundException;
    CabDto deleteCab(CabDto cabDto) throws CabNotFoundException;
    List<Cab> viewCabsOfType(String carType) throws CabNotFoundException;
}
