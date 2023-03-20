package com.fir.system.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fir.system.Entity.Police;
import com.fir.system.Entity.PoliceStation;
import com.fir.system.Entity.User;
import com.fir.system.GlobalExceptionHandler.UserException;
import com.fir.system.Service.Implement.FirIntrImpl;
import com.fir.system.Service.Implement.PoliceIntrImpl;
import com.fir.system.Service.Implement.PoliceStationIntrImpl;
import com.fir.system.Service.Implement.UserIntrImpl;

import aj.org.objectweb.asm.TypeReference;

@RestController
@RequestMapping(value="management/")
public class FirController {

	private final String type1 ="User";
	private final String type2 ="Police";
	private final String type3 ="Station";
	
	@Autowired
	private FirIntrImpl friServRepo;
	@Autowired
	private PoliceIntrImpl policeServRepo;
	@Autowired
	private PoliceStationIntrImpl policeStatServRepo;
	@Autowired
	private UserIntrImpl userServRepo;
	
	@PostMapping(value="user/register")
	public ResponseEntity<Object> registerUser(@RequestBody Map<String,String> map)
	{
		String type =map.get("Type");
		if(type.equals(this.type1))
		{
			User user = new User();
			user.setAddress(map.get("address"));
			user.setAge(Integer.parseInt(map.get("age")));
			user.setFirstName(map.get("firstName"));
			user.setLastName(map.get("lastName"));
			user.setGender(map.get("gender"));
			user.setMobileNumber(map.get("mobileNumber"));
			user.setPassword(map.get("password"));
			return new ResponseEntity<>(userServRepo.registerUser(user),HttpStatus.OK);
			
		}else if(type.equals(this.type2))
		{
			Police police = new Police();
			police.setDepartment(map.get("department"));
			police.setMobileNo(map.get("mobileNumber"));
			police.setOfficerName(map.get("officerName"));
			return new ResponseEntity<>(policeServRepo.registerPolice(police),HttpStatus.OK);
		}else if(type.equals(this.type3))
		{
			PoliceStation ps = new PoliceStation();
			ps.setAddress(map.get("address"));
			ps.setStationCode(map.get("stationCode"));
			return new ResponseEntity<>(policeStatServRepo.registerPoliceStation(ps),HttpStatus.OK);
		}
		else
			throw new UserException("Invalid Type of registrations, please check the type of registration or You are missing the Type. !!!");
		
	}
	
	@PostMapping(value="/user/fir")
	public ResponseEntity<Object> registerFir(@RequestBody Map<String,Object> map)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		String crimeDetail  =String.valueOf(map.get("crimeDetail"));
//		LocalDateTime localDateTime  =objectMapper.convertValue(map.get("localDateTime"),LocalDateTime.class);
		User user =objectMapper.convertValue(map.get("applicant"),User.class);
		Object list =map.get("criminals");
//		List<User> list2 = ((List<User>) list).stream().map(s->(User)s).collect(Collectors.toList()); 
		
		
		
		
		
		
		
		
		
		
		Police police =objectMapper.convertValue(map.get("officer"),Police.class);
		PoliceStation ps =objectMapper.convertValue(map.get("policeStation"),PoliceStation.class);
		boolean bol =(boolean)map.get("isOpen");
		return new ResponseEntity<Object>(list2,HttpStatus.ACCEPTED);
	}
}
