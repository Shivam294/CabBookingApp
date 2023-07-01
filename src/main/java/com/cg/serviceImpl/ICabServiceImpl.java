package com.cg.serviceImpl;

import com.cg.Converter;
import com.cg.dto.CabDto;
import com.cg.entities.Cab;
import com.cg.exception.CabAlreadyExistsException;
import com.cg.exception.CabNotFoundException;
import com.cg.repository.CabRepository;
import com.cg.service.ICabService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ICabServiceImpl implements ICabService {
    ICabServiceImpl() {
        System.out.println("Cab Service Bean Created.");
    }

    @Autowired
    private CabRepository cabRepository;

    @Override
    public CabDto insertCab(CabDto cabDto) throws CabAlreadyExistsException{
        if (cabDto == null){
            return null;
        }
        Optional<Cab> cabOptional= cabRepository.findById(Converter.convertCabDtoToEntity(cabDto).getCabId());
        if (cabOptional.isPresent()){
            throw new CabAlreadyExistsException("Cab Already Exists.");
        }

        Cab cab=Converter.convertCabDtoToEntity(cabDto);
        Cab cab1= cabRepository.save(cab);
        CabDto cabDto1=Converter.convertCabEntityToDto(cab1);
        return cabDto1;
    }

    @Override
    public CabDto updateCab(CabDto cabDto) throws CabNotFoundException {
        if (cabDto == null) {
            return null;
        }

        Optional<Cab> cabOptional= cabRepository.findById(Converter.convertCabDtoToEntity(cabDto).getCabId());
        if (!cabOptional.isPresent()){
            throw new CabNotFoundException("Cab Does Not Exists.");
        }

        Cab cab=Converter.convertCabDtoToEntity(cabDto);
        return Converter.convertCabEntityToDto(cabRepository.save(cab));
    }

    @Override
    public int countCabsByType(String carType) throws CabNotFoundException {
        long count= cabRepository.countByCarType(carType);
        int cabCount= (int) count;
        if (cabCount!=0){
            return cabCount;
        } else {
            throw new CabNotFoundException("Cab Does Not Exist for this type: "+carType);
        }
    }

    @Override
    public CabDto findByCabId(int id) throws CabNotFoundException {
        Optional<Cab> cab= cabRepository.findById(id);
        if (cab.isPresent()){
            return Converter.convertCabEntityToDto(cab.get());
        }
        throw new CabNotFoundException("Cab Does Not Exist for this ID: "+id);
    }

    @Override
    public CabDto deleteCab(@NotNull CabDto cabDto) throws CabNotFoundException {
        Optional<Cab> cabOptional= cabRepository.findById(cabDto.getCabId());
        if (cabOptional.isPresent()){
            cabRepository.delete(Converter.convertCabDtoToEntity(cabDto));
            return cabDto;
        }
        throw new CabNotFoundException("Cab Does Not Exist.");
    }

    @Override
    public List<Cab> viewCabsOfType(String carType) throws CabNotFoundException {
        List<Cab> cabOptional= cabRepository.findByCarType(carType);
        if (cabOptional.isEmpty()){
            throw new CabNotFoundException("Cab Does Not Exist for this type: "+carType);
        } else {
            return cabOptional;
        }
    }
}
