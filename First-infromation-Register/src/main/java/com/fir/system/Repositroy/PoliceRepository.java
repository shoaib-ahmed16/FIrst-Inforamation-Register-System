package com.fir.system.Repositroy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fir.system.Entity.Fir;
import com.fir.system.Entity.Police;

@Repository
@EnableJpaRepositories
public interface PoliceRepository  extends JpaRepository<Police,Integer>{

	
}
