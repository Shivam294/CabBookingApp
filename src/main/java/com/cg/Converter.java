package com.cg;

import com.cg.dto.CabDto;
import com.cg.entities.Cab;

public class Converter {
    public static CabDto convertCabEntityToDto(Cab cab){
        CabDto cabDto = new CabDto();
        cabDto.setCarType(cab.getCarType());
        cabDto.setPerKmRate(cabDto.getPerKmRate());
        cabDto.setCabId(cab.getCabId());
        return cabDto;
    }

    public static Cab convertCabDtoToEntity(CabDto cabDto){
        Cab cab = new Cab();
        cab.setCabId(cabDto.getCabId());
        cab.setCarType(cabDto.getCarType());
        cab.setPerKmRate(cabDto.getPerKmRate());
        return cab;
    }
}
