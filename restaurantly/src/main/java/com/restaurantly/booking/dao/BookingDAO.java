package com.restaurantly.booking.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.restaurantly.booking.vo.BookingVO;

public interface BookingDAO {

	public void insertBooking(BookingVO bookingVO) throws DataAccessException;

	public List<BookingVO> selectbookingList(String customer_id) throws DataAccessException;

	public void updatebookingList(String booking_id) throws DataAccessException;

}
