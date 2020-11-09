package com.restaurantly.owner.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurantly.booking.vo.BookingVO;
import com.restaurantly.owner.booking.dao.OwnerBookingDAO;

@Service("ownerBookingService")
@Transactional
public class OwnerBookingServiceImpl implements OwnerBookingService {
	@Autowired
	private OwnerBookingDAO ownerBookingDAO;

	@Override
	public List<BookingVO> booklist(String restaurant_license) throws Exception {
		List<BookingVO> bookList = ownerBookingDAO.selectbookList(restaurant_license);
		return bookList;
	}
	
	@Override
	public void delTable(String booking_id) throws Exception {
		ownerBookingDAO.deleteBooking(booking_id);		
	}

}
