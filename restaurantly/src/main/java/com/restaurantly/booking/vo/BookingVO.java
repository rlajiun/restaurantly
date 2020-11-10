package com.restaurantly.booking.vo;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@NoArgsConstructor
@Getter @Setter
@ToString
public class BookingVO {
	private String booking_id; /* 예약번호 */
	private String customer_id; /* 고객ID */
	private String restaurant_license; /* 사업자등록번호 */
	private String booking_date; /* 예약날짜 */
	private String booking_time; /* 예약시간 */
	private int booking_count; /* 예약인원 */
	private String booking_message; /* 예약문자 */
	private String booking_state; /* 예약상태 */
	
	private String customer_name; /* 고객이름 */
	private String customer_phone; /* 고객번호 */
	private String restaurant_name; /* 식당이름 */
	private String restaurant_phone; /* 식당번호 */
	private String restaurant_address; /* 식당주소 */
	private String restaurant_image; /* 식당사진 */
}
