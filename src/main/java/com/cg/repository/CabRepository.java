package com.cg.repository;

import com.cg.entities.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabRepository extends JpaRepository<Cab, Integer> {
    @Query("SELECT e from Cab e WHERE e.carType=?1")
    List<Cab>findByCarType(String carType);

    int countByCarType(String carType);
}
