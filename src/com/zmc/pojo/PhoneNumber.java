package com.zmc.pojo;

public class PhoneNumber {
	private String countryCode;
	private String stateCode;
	private String number;
	
	public PhoneNumber(String countryCode, String stateCode, String number) {
		super();
		this.countryCode = countryCode;
		this.stateCode = stateCode;
		this.number = number;
	}
	public PhoneNumber(String str){
		if (str!=null) {
			String[] strings = str.split("-");
			if (strings.length==3) {
				this.countryCode = strings[0];
				this.stateCode = strings[1];
				this.number = strings[2];
			}
		}
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.countryCode+"-"+this.stateCode+"-"+this.number;
	}
}
