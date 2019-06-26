package com.xiaonan.scancode.dao;

public class CertCardInfo {
	private String serialNumber; //序列号
	private String redeemCode; //兑换码
	private String value;      //面值
	private String createTime;//创建时间
	private String validity;   //过期时间
	private String isSend;	   //是否已被使用，Y：使用； N：未使用


	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getRedeemCode() {
		return redeemCode;
	}

	public void setRedeemCode(String redeemCode) {
		this.redeemCode = redeemCode;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getIsSend() {
		return isSend;
	}

	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}
}
