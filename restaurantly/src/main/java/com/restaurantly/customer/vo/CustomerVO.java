package com.restaurantly.customer.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@NoArgsConstructor
@Getter @Setter
@ToString
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
}