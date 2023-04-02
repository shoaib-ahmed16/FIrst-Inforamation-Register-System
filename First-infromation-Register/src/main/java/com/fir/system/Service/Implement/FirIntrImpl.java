package com.fir.system.Service.Implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fir.system.DTO.FirDTO;
import com.fir.system.Entity.Fir;
import com.fir.system.GlobalExceptionHandler.UserException;
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

	@Override
	public void deleteFir(Integer firId) {
		// TODO Auto-generated method stub
		firRepo.deleteById(firId);
	}

	@Override
	public FirDTO updateFir(Integer firId,FirDTO firDto) {
		// TODO Auto-generated method stub
		Optional<Fir> firUp =firRepo.findById(firId);
		if(firUp.isPresent())
		{
			Fir fir =firUp.get();
			Fir firNew = firDtoToFir(firDto);
			firRepo.save(firNew);
			firRepo.flush();
			return firDto;
		}
		throw new UserException("Not found any Fir for the enter Fir Id"+firId);
	}
	 protected Fir firDtoToFir(FirDTO firDto)
	{
		Fir fir = new Fir();
		fir.setApplicant(firDto.getApplicant());
		fir.setCrimeDetail(firDto.getCrimeDetail());
		fir.setCriminals(firDto.getCriminals());
		fir.setLocalDateTime(firDto.getLocalDateTime());
		fir.setOfficer(firDto.getOfficer());
		fir.setOpen(firDto.getIsOpen());
		fir.setPoliceStation(firDto.getPoliceStation());
		return fir;
	}
}
