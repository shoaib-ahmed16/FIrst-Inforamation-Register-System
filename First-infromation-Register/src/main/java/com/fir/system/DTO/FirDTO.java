package com.fir.system.DTO;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fir.system.Entity.Police;
import com.fir.system.Entity.PoliceStation;
import com.fir.system.Entity.User;

public class FirDTO {

	private Integer firId;
	private String crimeDetail;
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDateTime localDateTime;
	private User applicant;
	private List<User> criminals;
	private Police officer;
	private PoliceStation policeStation;
	private boolean isOpen;
	public Integer getFirId() {
		return firId;
	}
	public void setFirId(Integer firId) {
		this.firId = firId;
	}
	public String getCrimeDetail() {
		return crimeDetail;
	}
	public void setCrimeDetail(String crimeDetail) {
		this.crimeDetail = crimeDetail;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public User getApplicant() {
		return applicant;
	}
	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}
	public List<User> getCriminals() {
		return criminals;
	}
	public void setCriminals(List<User> criminals) {
		this.criminals = criminals;
	}
	public Police getOfficer() {
		return officer;
	}
	public void setOfficer(Police officer) {
		this.officer = officer;
	}
	public PoliceStation getPoliceStation() {
		return policeStation;
	}
	public void setPoliceStation(PoliceStation policeStation) {
		this.policeStation = policeStation;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public FirDTO(Integer firId, String crimeDetail, LocalDateTime localDateTime, User applicant, List<User> criminals,
			Police officer, PoliceStation policeStation, boolean isOpen) {
		super();
		this.firId = firId;
		this.crimeDetail = crimeDetail;
		this.localDateTime = localDateTime;
		this.applicant = applicant;
		this.criminals = criminals;
		this.officer = officer;
		this.policeStation = policeStation;
		this.isOpen = isOpen;
	}
	public FirDTO() {
		
	}
}
