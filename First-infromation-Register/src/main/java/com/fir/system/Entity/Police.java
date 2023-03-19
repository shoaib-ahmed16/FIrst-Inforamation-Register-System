package com.fir.system.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;

@Entity
public class Police {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer policeId;
	private String officerName;
	private String mobileNo;
	private String department;
	
	@OneToMany(targetEntity=Fir.class,cascade=CascadeType.ALL)
	@JoinColumn(name="assign_to_police")
	@OrderColumn(name="assign_me")
	private List<Fir> firList;
	
	@OneToMany(targetEntity=Fir.class,cascade=CascadeType.ALL)
	@JoinColumn(name="close_by_police")
	@OrderColumn(name="close_by_me")
	private List<Fir> casesClosed;
	
	public Integer getPoliceId() {
		return policeId;
	}
	public void setPoliceId(Integer policeId) {
		this.policeId = policeId;
	}
	public String getOfficerName() {
		return officerName;
	}
	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public List<Fir> getFirList() {
		return firList;
	}
	public void setFirList(List<Fir> firList) {
		this.firList = firList;
	}
	public List<Fir> getCasesClosed() {
		return casesClosed;
	}
	public void setCasesClosed(List<Fir> casesClosed) {
		this.casesClosed = casesClosed;
	}
	public Police(Integer policeId, String officerName, String mobileNo, String department, List<Fir> firList,
			List<Fir> casesClosed) {
		super();
		this.policeId = policeId;
		this.officerName = officerName;
		this.mobileNo = mobileNo;
		this.department = department;
		this.firList = firList;
		this.casesClosed = casesClosed;
	}
	public Police()
	{
		
	}
	
}
