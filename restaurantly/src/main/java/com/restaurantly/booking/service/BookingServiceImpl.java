package com.restaurantly.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurantly.booking.dao.BookingDAO;
import com.restaurantly.booking.vo.BookingVO;

@Service("bookingService")
@Transactional
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingDAO bookingDAO;
	
	@Override
	public void bookATable(BookingVO bookingVO) throws Exception {
		bookingDAO.insertBooking(bookingVO);
	}

	@Override
	public List<BookingVO> listBooking(String customer_id) throws Exception {
		List<BookingVO> bookingList = bookingDAO.selectbookingList(customer_id);
		return bookingList;
	}

	@Override
	public void cancelTable(String booking_id) throws Exception {
		bookingDAO.updatebookingList(booking_id);	
	}
}
