package com.fir.system.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderColumn;

@Entity
public class PoliceStation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer stationId;
	private String stationCode;
	private String address;
	@OneToOne(cascade=CascadeType.ALL)
	private Police officerInCharge;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="constable_in_station")
	@OrderColumn(name="type")
	private List<Police> constables;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fir_register_in_station")
	private List<Fir> firlist;
	public Integer getStationId() {
		return stationId;
	}
	public void setStationId(Integer stationId) {
		this.stationId = stationId;
	}
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Police getOfficerInCharge() {
		return officerInCharge;
	}
	public void setOfficerInCharge(Police officerInCharge) {
		this.officerInCharge = officerInCharge;
	}
	public List<Police> getConstables() {
		return constables;
	}
	public void setConstables(List<Police> constables) {
		this.constables = constables;
	}
	public List<Fir> getFirlist() {
		return firlist;
	}
	public void setFirlist(List<Fir> firlist) {
		this.firlist = firlist;
	}
	public PoliceStation(Integer stationId, String stationCode, String address, Police officerInCharge,
			List<Police> constables, List<Fir> firlist) {
		super();
		this.stationId = stationId;
		this.stationCode = stationCode;
		this.address = address;
		this.officerInCharge = officerInCharge;
		this.constables = constables;
		this.firlist = firlist;
	}
	public PoliceStation() {
		
	}
	
	
}

