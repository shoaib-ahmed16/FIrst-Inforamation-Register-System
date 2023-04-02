package com.fir.system.Service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fir.system.Entity.Fir;
import com.fir.system.Entity.Police;
import com.fir.system.Repositroy.FirRepository;
import com.fir.system.Repositroy.PoliceRepository;
import com.fir.system.Repositroy.PoliceStationRepository;
import com.fir.system.Repositroy.UserRepository;
import com.fir.system.Service.PoliceIntr;

@Service
public class PoliceIntrImpl implements PoliceIntr {


	@Autowired
	private FirRepository firRepo;
	@Autowired
	private PoliceRepository policRepo;
	@Autowired
	private PoliceStationRepository policeStatRepo;
	@Autowired
	private UserRepository userRepo;
	@Override
	public Police registerPolice(Police police) {
		// TODO Auto-generated method stub
		return policRepo.save(police);
	}
	
}
