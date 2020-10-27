package com.restaurantly.owner.user.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component("Owner")
@NoArgsConstructor
@Getter @Setter
public class OwnerVO {
	private String owner_id; /* 판매자ID */
	private String owner_pw; /* 비밀번호 */
	private String owner_name; /* 이름 */
	private String owner_phone; /* 전화번호 */
	private String owner_email; /* 이메일 */
	private String owner_joindate; /* 가입일 */
}
