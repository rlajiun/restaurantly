package com.restaurantly.booking.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.restaurantly.booking.vo.BookingVO;

@Repository("bookingDAO")
public class BookingDAOImpl implements BookingDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertBooking(BookingVO bookingVO) throws DataAccessException {
		sqlSession.insert("mapper.booking.insertBooking", bookingVO);
	}

	@Override
	public List<BookingVO> selectbookingList(String customer_id) throws DataAccessException {
		List<BookingVO> bookingList = (List)sqlSession.selectList("mapper.booking.selectbookingList", customer_id);
		return bookingList;
	}

	@Override
	public void updatebookingList(String booking_id) throws DataAccessException {
		sqlSession.update("mapper.booking.updateBookingCancel", booking_id);
	}

}
