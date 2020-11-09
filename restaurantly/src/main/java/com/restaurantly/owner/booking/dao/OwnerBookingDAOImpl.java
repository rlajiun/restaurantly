package com.restaurantly.owner.booking.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.restaurantly.booking.vo.BookingVO;

@Repository("ownerBookingDAO")
public class OwnerBookingDAOImpl implements OwnerBookingDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<BookingVO> selectbookList(String restaurant_license) throws DataAccessException {
		List<BookingVO> bookList = (List)sqlSession.selectList("mapper.owner.booking.selectbookList", restaurant_license);
		return bookList;
	}

	@Override
	public void deleteBooking(String booking_id) throws DataAccessException {
		sqlSession.delete("mapper.owner.booking.deleteBooking", booking_id);
	}

}
