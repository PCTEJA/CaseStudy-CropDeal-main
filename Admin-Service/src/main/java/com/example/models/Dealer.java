package com.example.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Dealer")
public class Dealer {
	@Id
	private String dealerid;
	private String dealerName;
	private String dealerEmail;
	private String dealerContactNo;
	private String password;
	private BankDetails BankDetail;

	public Dealer() {
	
	}

	public Dealer(String dealerid, String dealerName, String dealerEmail, String dealerContactNo, String password,
			BankDetails bankDetail) {
		super();
		this.dealerid = dealerid;
		this.dealerName = dealerName;
		this.dealerEmail = dealerEmail;
		this.dealerContactNo = dealerContactNo;
		this.password = password;
		BankDetail = bankDetail;
	}

	public String getDealerid() {
		return dealerid;
	}

	public void setDealerid(String dealerid) {
		this.dealerid = dealerid;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerEmail() {
		return dealerEmail;
	}

	public void setDealerEmail(String dealerEmail) {
		this.dealerEmail = dealerEmail;
	}

	public String getDealerContactNo() {
		return dealerContactNo;
	}

	public void setDealerContactNo(String dealerContactNo) {
		this.dealerContactNo = dealerContactNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BankDetails getBankDetail() {
		return BankDetail;
	}

	public void setBankDetail(BankDetails bankDetail) {
		BankDetail = bankDetail;
	}

	@Override
	public String toString() {
		return "Dealer [dealerid=" + dealerid + ", dealerName=" + dealerName + ", dealerEmail=" + dealerEmail
				+ ", dealerContactNo=" + dealerContactNo + ", password=" + password + ", BankDetail=" + BankDetail
				+ "]";
	}

}
