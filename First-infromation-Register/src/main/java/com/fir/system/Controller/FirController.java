package com.fir.system.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fir.system.DTO.FirDTO;
import com.fir.system.Entity.Police;
import com.fir.system.Entity.PoliceStation;
import com.fir.system.Entity.User;
import com.fir.system.GlobalExceptionHandler.UserException;
import com.fir.system.Service.Implement.FirIntrImpl;
import com.fir.system.Service.Implement.PoliceIntrImpl;
import com.fir.system.Service.Implement.PoliceStationIntrImpl;
import com.fir.system.Service.Implement.UserIntrImpl;

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
	public ResponseEntity<Object> registerFir(@RequestBody FirDTO firDto)
	{
		friServRepo.registerFir(firDto);
		return new ResponseEntity<Object>(firDto,HttpStatus.ACCEPTED);
	}
	
//	@GetMapping(value="/user/fir/{stationId}")
//	public ResponseEntity<FirDTO> getOldest_Open_Fir_from_Station(@PathVariable("stationId") Integer stationId)
//	{
//		return new ResponseEntity<FirDTO>(,HttpStatus.ACCEPTED);
//	}
	@DeleteMapping(value="/user/fir/{firId}")
	public ResponseEntity<Object> deleteFir(@PathVariable("firId") Integer firId)
	{
		friServRepo.deleteFir(firId);
		return new ResponseEntity<Object>("Delete",HttpStatus.ACCEPTED);
	}
}
