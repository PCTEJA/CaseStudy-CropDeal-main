package com.cropdeal.farmerservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection="Farmer")
public class Farmer {

	@Id
	private String farmerId;
	private String farmerName;
	private String farmeremail;
	private String farmerContactNo;
	private String farmerAddress;
	private String bankDetails;
	private List<Crop> crops;
	
	public Farmer() {
		
	}
	
	public Farmer(String farmerId, String farmerName, String farmeremail, String farmerContactNo,
			String farmerAddress, String bankDetails, List<Crop> crops) {
		super();
		this.farmerId = farmerId;
		this.farmerName = farmerName;
		this.farmeremail = farmeremail;
		this.farmerContactNo = farmerContactNo;
		this.farmerAddress = farmerAddress;
		this.bankDetails = bankDetails;
		this.crops = crops;
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

	public String getFarmerAddress() {
		return farmerAddress;
	}

	public void setFarmerAddress(String farmerAddress) {
		this.farmerAddress = farmerAddress;
	}

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}
	public List<Crop> getCrops() {
		return crops;
	}

	public void setCrops(List<Crop> crops) {
		this.crops = crops;
	}

	@Override
	public String toString() {
		return "Farmer [farmerId=" + farmerId + ", farmerName=" + farmerName + ", farmeremail=" + farmeremail
				+ ", farmerContactNo=" + farmerContactNo + ", farmerAddress=" + farmerAddress + ", bankDetails="
				+ bankDetails +  ", crops=" + crops + "]";
	}
	

}
