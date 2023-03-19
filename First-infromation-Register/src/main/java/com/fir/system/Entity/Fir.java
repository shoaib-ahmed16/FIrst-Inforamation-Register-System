package com.fir.system.Entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderColumn;

@Entity
public class Fir {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer firId;
	private String crimeDetail;
	private LocalDateTime localDateTime;
	@OneToOne
	private User applicant;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="criminal_under_Register_fir")
	@OrderColumn(name="criminals")
	private List<User> criminals;
	
	@ManyToOne(targetEntity=Police.class,cascade=CascadeType.ALL)  
	private Police officer;
	@ManyToOne(targetEntity=PoliceStation.class,cascade=CascadeType.ALL)  
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
	public Fir(Integer firId, String crimeDetail, LocalDateTime localDateTime, User applicant, List<User> criminals,
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
	public Fir() {
		
	}
	
}
