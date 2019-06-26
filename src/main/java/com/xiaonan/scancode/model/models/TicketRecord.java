package com.xiaonan.scancode.model.models;

public class TicketRecord {

	private String ticket_code; //电子券码code
	private String ticket_state;//核销状态
	private String verify_time;//核销时间

	public String getTicket_code() {
		return ticket_code;
	}

	public void setTicket_code(String ticket_code) {
		this.ticket_code = ticket_code;
	}

	public String getTicket_state() {
		return ticket_state;
	}

	public void setTicket_state(String ticket_state) {
		this.ticket_state = ticket_state;
	}

	public String getVerify_time() {
		return verify_time;
	}

	public void setVerify_time(String verify_time) {
		this.verify_time = verify_time;
	}
}
