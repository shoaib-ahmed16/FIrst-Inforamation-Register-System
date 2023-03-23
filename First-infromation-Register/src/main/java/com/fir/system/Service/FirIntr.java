package com.fir.system.Service;

import com.fir.system.DTO.FirDTO;

public interface FirIntr {

	public void registerFir(FirDTO firDto);
	
	public void deleteFir(Integer firId);
	
}
