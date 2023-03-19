package com.fir.system.Service.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fir.system.Repositroy.FirRepository;
import com.fir.system.Repositroy.PoliceRepository;
import com.fir.system.Repositroy.PoliceStationRepository;
import com.fir.system.Repositroy.UserRepository;
import com.fir.system.Service.FirIntr;

@Service
public class FirIntrImpl implements FirIntr{
	
	@Autowired
	private FirRepository firRepo;
	@Autowired
	private PoliceRepository policRepo;
	@Autowired
	private PoliceStationRepository policeStatRepo;
	@Autowired
	private UserRepository userRepo;
}
