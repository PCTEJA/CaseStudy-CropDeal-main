package com.example.models;

public class BankDetails {
	
	private String accountNumber;
	private String bankName;
	private String IFSCCode;
	
	public BankDetails() {
		
	}

	public BankDetails(String accountNumber, String bankName, String iFSCCode) {
		super();
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.IFSCCode = iFSCCode;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIFSCCode() {
		return IFSCCode;
	}

	public void setIFSCCode(String iFSCCode) {
		this.IFSCCode = iFSCCode;
	}

	
	
}
