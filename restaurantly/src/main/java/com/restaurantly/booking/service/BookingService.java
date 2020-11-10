package com.restaurantly.booking.service;

import java.util.List;

import com.restaurantly.booking.vo.BookingVO;

public interface BookingService {

	public void bookATable(BookingVO bookingVO) throws Exception;

	public List<BookingVO> listBooking(String customer_id) throws Exception;

	public void cancelTable(String booking_id) throws Exception;

}
