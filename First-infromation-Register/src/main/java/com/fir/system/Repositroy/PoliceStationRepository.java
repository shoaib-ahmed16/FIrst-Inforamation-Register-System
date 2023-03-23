package com.fir.system.Repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fir.system.Entity.PoliceStation;

@Repository
public interface PoliceStationRepository extends JpaRepository<PoliceStation,Integer>{

}
