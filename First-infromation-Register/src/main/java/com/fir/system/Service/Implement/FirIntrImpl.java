package com.fir.system.Service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fir.system.DTO.FirDTO;
import com.fir.system.Entity.Fir;
import com.fir.system.Entity.User;
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
	@Override
	public void registerFir(FirDTO firDto) {
		// TODO Auto-generated method stub
		Fir fir =firDtoToFir(firDto);
		firRepo.save(fir);
		firRepo.flush();
	}
	
	public Fir firDtoToFir(FirDTO firDto)
	{
		Fir fir = new Fir();
		fir.setApplicant(firDto.getApplicant());
		fir.setCrimeDetail(firDto.getCrimeDetail());
		fir.setCriminals(firDto.getCriminals());
		fir.setLocalDateTime(firDto.getLocalDateTime());
		fir.setOfficer(firDto.getOfficer());
		fir.setOpen(firDto.isOpen());
		fir.setPoliceStation(firDto.getPoliceStation());
		return fir;
	}

	@Override
	public void deleteFir(Integer firId) {
		// TODO Auto-generated method stub
		firRepo.deleteById(firId);
	}
}
