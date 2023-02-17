package com.cropdeal.dealerservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection = "Dealer")

public class Dealer {

	@Id

	private String id;
	private String dealerName;
	private String dealerEmail;
	private String dealerContactNo;
	private String passWord;
	private BankDetails bankDetail;
	public Dealer(String id, String dealerName, String dealerEmail, String dealerContactNo, String passWord,
			BankDetails bankDetail) {
		super();
		this.id = id;
		this.dealerName = dealerName;
		this.dealerEmail = dealerEmail;
		this.dealerContactNo = dealerContactNo;
		this.passWord = passWord;
		this.bankDetail = bankDetail;
	}
	public Dealer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public BankDetails getBankDetail() {
		return bankDetail;
	}
	public void setBankDetail(BankDetails bankDetail) {
		this.bankDetail = bankDetail;
	}
	@Override
	public String toString() {
		return "Dealer [id=" + id + ", dealerName=" + dealerName + ", dealerEmail=" + dealerEmail + ", dealerContactNo="
				+ dealerContactNo + ", passWord=" + passWord + ", bankDetail=" + bankDetail + "]";
	}
	
	
	}
