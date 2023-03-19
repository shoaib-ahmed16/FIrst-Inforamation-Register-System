package com.fir.system.Service.Implement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fir.system.Entity.User;
import com.fir.system.GlobalExceptionHandler.UserException;
import com.fir.system.Repositroy.FirRepository;
import com.fir.system.Repositroy.PoliceRepository;
import com.fir.system.Repositroy.PoliceStationRepository;
import com.fir.system.Repositroy.UserRepository;
import com.fir.system.Service.UserIntr;

@Service
public class UserIntrImpl  implements UserIntr{
	
	@Autowired
	private FirRepository firRepo;
	@Autowired
	private PoliceRepository policRepo;
	@Autowired
	private PoliceStationRepository policeStatRepo;
	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public User registerUser(User user) {
		Optional<User> find =userRepo.findById(user.getMobileNumber());
		if(find.isPresent())
			throw new UserException("User Allready Persent ! Cannot add Duplicate");
		return userRepo.save(user);
	}

}
