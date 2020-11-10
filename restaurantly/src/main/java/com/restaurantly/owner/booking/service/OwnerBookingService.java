package com.restaurantly.owner.booking.service;

import java.util.List;

import com.restaurantly.booking.vo.BookingVO;

public interface OwnerBookingService {

	public List<BookingVO> booklist(String restaurant_license) throws Exception;

	public void delTable(String booking_id) throws Exception;

}
