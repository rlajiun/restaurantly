package com.restaurantly.owner.booking.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.restaurantly.booking.vo.BookingVO;

public interface OwnerBookingDAO {

	public List<BookingVO> selectbookList(String restaurant_license) throws DataAccessException;

	public void deleteBooking(String booking_id) throws DataAccessException;

}
