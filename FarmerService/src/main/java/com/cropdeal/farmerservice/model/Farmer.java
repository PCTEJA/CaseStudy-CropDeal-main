package com.cropdeal.farmerservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection="Farmer")
public class Farmer {

	@Id
	private String farmerId;
	private String farmerName;
	private String farmeremail;
	private String farmerContactNo;
	private Location farmerAddress;
	private BankDetails bankDetails;
	
	public Farmer() {
		
	}
	
	public Farmer(String farmerId, String farmerName, String farmeremail, String farmerContactNo,
			Location farmerAddress, BankDetails bankDetails) {
		super();
		this.farmerId = farmerId;
		this.farmerName = farmerName;
		this.farmeremail = farmeremail;
		this.farmerContactNo = farmerContactNo;
		this.farmerAddress = farmerAddress;
		this.bankDetails = bankDetails;
	}

	public String getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(String farmerId) {
		this.farmerId = farmerId;
	}

	public String getFarmerName() {
		return farmerName;
	}

	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getFarmeremail() {
		return farmeremail;
	}

	public void setFarmeremail(String farmeremail) {
		this.farmeremail = farmeremail;
	}

	public String getFarmerContactNo() {
		return farmerContactNo;
	}

	public void setFarmerContactNo(String farmerContactNo) {
		this.farmerContactNo = farmerContactNo;
	}

	public Location getFarmerAddress() {
		return farmerAddress;
	}

	public void setFarmerAddress(Location farmerAddress) {
		this.farmerAddress = farmerAddress;
	}

	public BankDetails getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}

	@Override
	public String toString() {
		return "Farmer [farmerId=" + farmerId + ", farmerName=" + farmerName + ", farmeremail=" + farmeremail
				+ ", farmerContactNo=" + farmerContactNo + ", farmerAddress=" + farmerAddress + ", bankDetails="
				+ bankDetails + "]";
	}
	

}
