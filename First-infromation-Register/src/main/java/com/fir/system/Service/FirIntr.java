package com.fir.system.Service;

import org.springframework.web.bind.annotation.RequestBody;

import com.fir.system.DTO.FirDTO;

public interface FirIntr {

	public void registerFir(FirDTO firDto);
	
	public void deleteFir(Integer firId);
	
	public FirDTO updateFir(Integer firId,FirDTO firDto);
	
}
