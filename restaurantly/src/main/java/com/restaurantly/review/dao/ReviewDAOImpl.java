package com.restaurantly.review.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.restaurantly.menu.vo.MenuVO;
import com.restaurantly.restaurant.vo.RestaurantVO;
import com.restaurantly.review.dto.ReviewDTO;
@Repository("reviewDAO")
public class ReviewDAOImpl implements ReviewDAO{
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<String> selectReviewCategory() throws DataAccessException{
		List<String> reviewList = (List)sqlSession.selectList("mapper.review.selectReviewCategory");
		return reviewList;
	}

	@Override
	public List<ReviewDTO> selectReviewList(String restaurant_license) throws DataAccessException{
		List<ReviewDTO> reviewList = (List)sqlSession.selectList("mapper.review.selectReviewList ", restaurant_license);
		return reviewList ;
	}

	@Override
	public String insertReview(ReviewDTO reviewDTO) throws DataAccessException{
		String review_id = sqlSession.insert("mapper.review.insertReview", reviewDTO);
		return review_id;
	}

	@Override
	public ReviewDTO updateReview(ReviewDTO reviewDTO) throws DataAccessException{
		sqlSession.insert("mapper.review.updateReview", reviewDTO);
		return reviewDTO;
	
	}

	@Override
	public ReviewDTO deleteReview(ReviewDTO reviewDTO) throws DataAccessException{
		sqlSession.selectOne("mapper.review.deleteReview", reviewDTO);
		return reviewDTO;
	
	}

}
