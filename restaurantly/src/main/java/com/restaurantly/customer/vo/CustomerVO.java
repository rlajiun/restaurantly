package com.restaurantly.customer.vo;

import org.springframework.stereotype.Component;

@Component("customerVO")

public class CustomerVO {
	private String customer_id;
	private String customer_pw;
	private String customer_name;
	private String customer_email;
	private String customer_phone;
	private String customer_birthdate;
	private String customer_joindate;
	private String customer_image_path;
	private String customer_state;
	
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_pw() {
		return customer_pw;
	}
	public void setCustomer_pw(String customer_pw) {
		this.customer_pw = customer_pw;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCustomer_phone() {
		return customer_phone;
	}
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}
	public String getCustomer_birthdate() {
		return customer_birthdate;
	}
	public void setCustomer_birthdate(String customer_birthdate) {
		this.customer_birthdate = customer_birthdate;
	}
	public String getCustomer_joindate() {
		return customer_joindate;
	}
	public void setCustomer_joindate(String customer_joindate) {
		this.customer_joindate = customer_joindate;
	}
	public String getCustomer_image_path() {
		return customer_image_path;
	}
	public void setCustomer_image_path(String customer_image_path) {
		this.customer_image_path = customer_image_path;
	}
	public String getCustomer_state() {
		return customer_state;
	}
	public void setCustomer_state(String customer_state) {
		this.customer_state = customer_state;
	}
}