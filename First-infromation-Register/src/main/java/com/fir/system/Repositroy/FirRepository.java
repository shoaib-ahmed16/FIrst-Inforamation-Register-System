package com.fir.system.Repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fir.system.Entity.Fir;

@Repository
public interface FirRepository extends JpaRepository<Fir,Integer> {
//	@Query("Select top 1 * from ( select top 1 * from shoaibfir.Fir order by isOpen desc) as isOpen_case order by isOpen where ;")
}
