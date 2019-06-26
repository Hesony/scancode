package com.xiaonan.scancode.model;

import com.xiaonan.scancode.model.models.FullOrderInfo;
import com.xiaonan.scancode.model.models.TicketRecord;

import java.util.List;

public class Response {
	private String code;
	private String tid; //订单号
	private String state; //订单号状态
	private String create_time;
	private List<TicketRecord> tickets; //电子券码信息
	private String is_success;
	private String open_id;
	private String union_id;

	private FullOrderInfo fullOrderInfo; //交易基础信息结构体

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public List<TicketRecord> getTickets() {
		return tickets;
	}

	public void setTickets(List<TicketRecord> tickets) {
		this.tickets = tickets;
	}

	public String getIs_success() {
		return is_success;
	}

	public void setIs_success(String is_success) {
		this.is_success = is_success;
	}

	public FullOrderInfo getFullOrderInfo() {
		return fullOrderInfo;
	}

	public void setFullOrderInfo(FullOrderInfo fullOrderInfo) {
		this.fullOrderInfo = fullOrderInfo;
	}

	public String getOpen_id() {
		return open_id;
	}

	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}

	public String getUnion_id() {
		return union_id;
	}

	public void setUnion_id(String union_id) {
		this.union_id = union_id;
	}
}
